//////////////////////////////////////////////////////////////////////
//
//    TypeCheckVisitor - Walk the parser tree to do the semantic
//                       typecheck for the Asl programming language
//
//    Copyright (C) 2020-2030  Universitat Politecnica de Catalunya
//
//    This library is free software; you can redistribute it and/or
//    modify it under the terms of the GNU General Public License
//    as published by the Free Software Foundation; either version 3
//    of the License, or (at your option) any later version.
//
//    This library is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
//    Affero General Public License for more details.
//
//    You should have received a copy of the GNU Affero General Public
//    License along with this library; if not, write to the Free Software
//    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
//
//    contact: José Miguel Rivero (rivero@cs.upc.edu)
//             Computer Science Department
//             Universitat Politecnica de Catalunya
//             despatx Omega.110 - Campus Nord UPC
//             08034 Barcelona.  SPAIN
//
//////////////////////////////////////////////////////////////////////

#include "TypeCheckVisitor.h"
#include "antlr4-runtime.h"

#include "../common/TypesMgr.h"
#include "../common/SymTable.h"
#include "../common/TreeDecoration.h"
#include "../common/SemErrors.h"

#include <iostream>
#include <string>

// uncomment the following line to enable debugging messages with DEBUG*
//#define DEBUG_BUILD
#include "../common/debug.h"

// using namespace std;


// Constructor
TypeCheckVisitor::TypeCheckVisitor(TypesMgr       & Types,
                                   SymTable       & Symbols,
                                   TreeDecoration & Decorations,
                                   SemErrors      & Errors) :
  Types{Types},
  Symbols{Symbols},
  Decorations{Decorations},
  Errors{Errors} {
}

// Accessor/Mutator to the attribute currFunctionType
TypesMgr::TypeId TypeCheckVisitor::getCurrentFunctionTy() const {
  return currFunctionType;
}

void TypeCheckVisitor::setCurrentFunctionTy(TypesMgr::TypeId type) {
  currFunctionType = type;
}

// Methods to visit each kind of node:
//
antlrcpp::Any TypeCheckVisitor::visitProgram(AslParser::ProgramContext *ctx) {
  DEBUG_ENTER();
  SymTable::ScopeId sc = getScopeDecor(ctx);
  Symbols.pushThisScope(sc);
  for (auto ctxFunc : ctx->function()) { 
    visit(ctxFunc);
  }
  if (Symbols.noMainProperlyDeclared())
    Errors.noMainProperlyDeclared(ctx);
  Symbols.popScope();
  Errors.print();
  DEBUG_EXIT();
  return 0;
}

antlrcpp::Any TypeCheckVisitor::visitFunction(AslParser::FunctionContext *ctx) {
  DEBUG_ENTER();
  SymTable::ScopeId sc = getScopeDecor(ctx);
  TypesMgr::TypeId Tfunc = getTypeDecor(ctx);
  Symbols.pushThisScope(sc);
  setCurrentFunctionTy(Tfunc);
  visit(ctx->statements());
  Symbols.popScope();
  DEBUG_EXIT();
  return 0;
}

// antlrcpp::Any TypeCheckVisitor::visitDeclarations(AslParser::DeclarationsContext *ctx) {
//   DEBUG_ENTER();
//   antlrcpp::Any r = visitChildren(ctx);
//   DEBUG_EXIT();
//   return r;
// }

// antlrcpp::Any TypeCheckVisitor::visitVariable_decl(AslParser::Variable_declContext *ctx) {
//   DEBUG_ENTER();
//   antlrcpp::Any r = visitChildren(ctx);
//   DEBUG_EXIT();
//   return r;
// }

// antlrcpp::Any TypeCheckVisitor::visitType(AslParser::TypeContext *ctx) {
//   DEBUG_ENTER();
//   antlrcpp::Any r = visitChildren(ctx);
//   DEBUG_EXIT();
//   return r;
// }

antlrcpp::Any TypeCheckVisitor::visitStatements(AslParser::StatementsContext *ctx) {
  DEBUG_ENTER();
  visitChildren(ctx);
  DEBUG_EXIT();
  return 0;
}

antlrcpp::Any TypeCheckVisitor::visitAssignStmt(AslParser::AssignStmtContext *ctx) {
  DEBUG_ENTER();
  visit(ctx->left_expr());
  TypesMgr::TypeId t1 = getTypeDecor(ctx->left_expr());

  visit(ctx->expr());
  TypesMgr::TypeId t2 = getTypeDecor(ctx->expr());

  if ((not Types.isErrorTy(t1)) and (not getIsLValueDecor(ctx->left_expr())))
    Errors.nonReferenceableLeftExpr(ctx->left_expr());
  if ((not Types.isErrorTy(t1)) and (not Types.isErrorTy(t2)) and
      (not Types.copyableTypes(t1, t2)))
    Errors.incompatibleAssignment(ctx->ASSIGN());
    
  DEBUG_EXIT();
  return 0;
}


antlrcpp::Any TypeCheckVisitor::visitIfStmt(AslParser::IfStmtContext *ctx) {
  DEBUG_ENTER();
  visit(ctx->expr());
  TypesMgr::TypeId t1 = getTypeDecor(ctx->expr());
  if ((not Types.isErrorTy(t1)) and (not Types.isBooleanTy(t1)))
    Errors.booleanRequired(ctx);
  for (auto stms : ctx->statements())
    visit(stms);
  DEBUG_EXIT();
  return 0;
}

antlrcpp::Any TypeCheckVisitor::visitWhileStmt(AslParser::WhileStmtContext *ctx) {
  DEBUG_ENTER();
  visit(ctx->expr());
  TypesMgr::TypeId t1 = getTypeDecor(ctx->expr());
  if ((not Types.isErrorTy(t1)) and (not Types.isBooleanTy(t1)))
    Errors.booleanRequired(ctx);
  visit(ctx->statements());
  DEBUG_EXIT();
  return 0;
}

antlrcpp::Any TypeCheckVisitor::visitReadStmt(AslParser::ReadStmtContext *ctx) {
  DEBUG_ENTER();
  visit(ctx->left_expr());
  TypesMgr::TypeId t1 = getTypeDecor(ctx->left_expr());

  if ((not Types.isErrorTy(t1)) and (not Types.isPrimitiveTy(t1)) and
      (not Types.isFunctionTy(t1)))
    Errors.readWriteRequireBasic(ctx);
  if ((not Types.isErrorTy(t1)) and (not getIsLValueDecor(ctx->left_expr())))
    Errors.nonReferenceableExpression(ctx);
  DEBUG_EXIT();
  return 0;
}

antlrcpp::Any TypeCheckVisitor::visitWriteExpr(AslParser::WriteExprContext *ctx) {
  DEBUG_ENTER();
  visit(ctx->expr());

  TypesMgr::TypeId t1 = getTypeDecor(ctx->expr());
  if ((not Types.isErrorTy(t1)) and (not Types.isPrimitiveTy(t1)))
    Errors.readWriteRequireBasic(ctx);

  DEBUG_EXIT();
  return 0;
}

antlrcpp::Any TypeCheckVisitor::visitReturnExpr(AslParser::ReturnExprContext *ctx) {
  DEBUG_ENTER();

  TypesMgr::TypeId Tfunc = getCurrentFunctionTy();
  TypesMgr::TypeId Tret = Types.getFuncReturnType(Tfunc);
  TypesMgr::TypeId Texpr;
  
  if (ctx->expr()) {
    visit(ctx->expr());
    Texpr = getTypeDecor(ctx->expr());
  } 
  else Texpr = Types.createVoidTy();

  if (not Types.isErrorTy(Texpr) and not Types.isErrorTy(Tret) and
      not Types.copyableTypes(Tret, Texpr))
    Errors.incompatibleReturn(ctx->RETURN());

  DEBUG_EXIT();
  return 0;
}

antlrcpp::Any TypeCheckVisitor::visitWriteString(AslParser::WriteStringContext *ctx) {
  DEBUG_ENTER();
  antlrcpp::Any r = visitChildren(ctx);
  DEBUG_EXIT();
  return r;
}

antlrcpp::Any TypeCheckVisitor::visitSwapExpr(AslParser::SwapExprContext *ctx) {
  DEBUG_ENTER();

  visit(ctx->left_expr(0));
  TypesMgr::TypeId t1 = getTypeDecor(ctx->left_expr(0));
  visit(ctx->left_expr(1));
  TypesMgr::TypeId t2 = getTypeDecor(ctx->left_expr(1));

  if ((not Types.isErrorTy(t1) and not Types.isErrorTy(t2)) and not Types.equalTypes(t1,t2)) {
    Errors.incompatibleArgumentsInSwap(ctx);
  }

  DEBUG_EXIT();
  return 0;
}

antlrcpp::Any TypeCheckVisitor::visitSwitchExpr(AslParser::SwitchExprContext *ctx) {
  DEBUG_ENTER();

  visit(ctx->expr(0));
  TypesMgr::TypeId t0 = getTypeDecor(ctx->expr(0));

  //Recorro todos los cases a partir del segundo expr (el primer caso)
  for (uint i = 1; i < ctx->expr().size(); ++i) {
    visit(ctx->expr(i));
    TypesMgr::TypeId ti = getTypeDecor(ctx->expr(i));
    if ((not Types.isErrorTy(t0) and not Types.isErrorTy(ti)) and 
        not Types.comparableTypes(t0, ti, "=")) {
      Errors.incompatibleValueInSwitch(ctx->expr(i));
    }
    visit(ctx->statements(i-1));
  }

  if (ctx->DEFAULT()) {
    visit(ctx->statements(ctx->expr().size()-1));
  }

  DEBUG_EXIT();
  return 0;
}

antlrcpp::Any TypeCheckVisitor::visitLeft_expr(AslParser::Left_exprContext *ctx) {
  DEBUG_ENTER();
  visit(ctx->ident());
  TypesMgr::TypeId tID = getTypeDecor(ctx->ident());
  bool b = getIsLValueDecor(ctx->ident());
  
  //ARRAY
  if (ctx->expr()) {
    visit(ctx->expr());
    TypesMgr::TypeId tEXPR = getTypeDecor(ctx->expr());
    bool synt_valid = not Types.isErrorTy(tID);

    if ((not Types.isErrorTy(tID)) and (not Types.isArrayTy(tID))) {
      Errors.nonArrayInArrayAccess(ctx->ident());
      tID = Types.createErrorTy();
      b = false;
      synt_valid = false;
    }

    if ((not Types.isErrorTy(tEXPR)) and (not Types.isIntegerTy(tEXPR))) {
      Errors.nonIntegerIndexInArrayAccess(ctx->expr());
//      synt_valid = false;
    }

    if (synt_valid) {
      tID = Types.getArrayElemType(tID);
      b = true;
    }
  }

  putTypeDecor(ctx, tID);
  putIsLValueDecor(ctx, b);
  
  DEBUG_EXIT();
  return 0;
}

antlrcpp::Any TypeCheckVisitor::visitArrayIndex(AslParser::ArrayIndexContext *ctx) {
  DEBUG_ENTER();

  //DECORACION DEL ACCESO AL ARRAY
  visit(ctx->ident());
  TypesMgr::TypeId tID = getTypeDecor(ctx->ident());
  bool b = getIsLValueDecor(ctx->ident());

  if ((not Types.isErrorTy(tID)) and (not Types.isArrayTy(tID))) 
    Errors.nonArrayInArrayAccess(ctx);

  if (Types.isArrayTy(tID))
		putTypeDecor(ctx, Types.getArrayElemType(tID));
 
  putIsLValueDecor(ctx, b);

  //COMPROBACION DEL ITERADOR
  visit(ctx->expr());
  TypesMgr::TypeId t1 = getTypeDecor(ctx->expr());

  if ((not Types.isErrorTy(t1)) and (not Types.isIntegerTy(t1)))
    Errors.nonIntegerIndexInArrayAccess(ctx->expr()); 

  DEBUG_EXIT();
  return 0;
 }

antlrcpp::Any TypeCheckVisitor::visitUnary(AslParser::UnaryContext *ctx) {
  DEBUG_ENTER();
  visit(ctx->expr());
  TypesMgr::TypeId t1 = getTypeDecor(ctx->expr());
  
  if(ctx->NOT()) { // NOT
	  if (((not Types.isErrorTy(t1)) and (not Types.isBooleanTy(t1))))
		Errors.incompatibleOperator(ctx->op);
	  TypesMgr::TypeId t = Types.createBooleanTy();
	  putTypeDecor(ctx, t);
  }
  else { // MINUS or PLUS
	  if (((not Types.isErrorTy(t1)) and (not Types.isNumericTy(t1))))
		Errors.incompatibleOperator(ctx->op);
	  if(Types.isNumericTy(t1)) putTypeDecor(ctx, t1);
	  else {
		  TypesMgr::TypeId t = Types.createIntegerTy();
		  putTypeDecor(ctx, t);
	  }
  }
  
  putIsLValueDecor(ctx, false);
  DEBUG_EXIT();
  return 0;
}

antlrcpp::Any TypeCheckVisitor::visitArithmetic(AslParser::ArithmeticContext *ctx) {
  DEBUG_ENTER();
  visit(ctx->expr(0));
  TypesMgr::TypeId t1 = getTypeDecor(ctx->expr(0));
  visit(ctx->expr(1));
  TypesMgr::TypeId t2 = getTypeDecor(ctx->expr(1));
  if (((not Types.isErrorTy(t1)) and (not Types.isNumericTy(t1))) or
      ((not Types.isErrorTy(t2)) and (not Types.isNumericTy(t2))))
    Errors.incompatibleOperator(ctx->op);
  
  if (ctx->MOD() and (Types.isFloatTy(t1) or Types.isFloatTy(t2)))
    Errors.incompatibleOperator(ctx->op);

  TypesMgr::TypeId t = Types.createIntegerTy();
  if (Types.isFloatTy(t1) or Types.isFloatTy(t2))
    t = Types.createFloatTy();
  putTypeDecor(ctx, t);
  putIsLValueDecor(ctx, false);
  DEBUG_EXIT();
  return 0;
}

antlrcpp::Any TypeCheckVisitor::visitProcCall(AslParser::ProcCallContext *ctx) {
  DEBUG_ENTER();
  visit(ctx->ident());
  TypesMgr::TypeId tID = getTypeDecor(ctx->ident());

  bool error = false;

  //NO CALLEABLE
  if (not Types.isFunctionTy(tID) and not Types.isErrorTy(tID)) {
    Errors.isNotCallable(ctx->ident());
    error = true;
  }

  if (Types.isFunctionTy(tID)) {
//    TypesMgr::TypeId tf = Types.getFuncReturnType(tID);

    if (Types.getNumOfParameters(tID) != ctx->expr().size()) {
      Errors.numberOfParameters(ctx);
      error = true;
    }
  }

  int i = 0;
  for (auto e : ctx->expr()) {
    visit(e);
    if (not error and not Types.isErrorTy(tID)) {
      TypesMgr::TypeId tp = Types.getParameterType(tID,i);
      TypesMgr::TypeId te = getTypeDecor(e);

      if (not Types.isErrorTy(tp) and not Types.isErrorTy(te) and
        not Types.equalTypes(tp,te)) {
          if(not (Types.isFloatTy(tp) and Types.isIntegerTy(te)))
            Errors.incompatibleParameter(e,i+1,ctx);
        }
    }
    ++i;
  }

  DEBUG_EXIT();
  return 0;
}

antlrcpp::Any TypeCheckVisitor::visitFuncCall(AslParser::FuncCallContext *ctx) {
  DEBUG_ENTER();
  visit(ctx->ident());
  TypesMgr::TypeId tID = getTypeDecor(ctx->ident());

  bool error = false;

  //NO CALLEABLE
  if (not Types.isFunctionTy(tID) and not Types.isErrorTy(tID)) {
    Errors.isNotCallable(ctx->ident());
    error = true;
  }

  if (Types.isFunctionTy(tID)) {
    TypesMgr::TypeId tf = Types.getFuncReturnType(tID);

    //ES VOID
    if (Types.isVoidTy(tf)) Errors.isNotFunction(ctx->ident());
    else   
        putTypeDecor(ctx, tf);
    putIsLValueDecor(ctx, false);

    if (Types.getNumOfParameters(tID) != ctx->expr().size()) {
      Errors.numberOfParameters(ctx);
      error = true;
    }

  }

  int i = 0;
  for (auto e : ctx->expr()) {
    visit(e);
    if (not error and not Types.isErrorTy(tID)) {
      TypesMgr::TypeId tp = Types.getParameterType(tID,i);
      TypesMgr::TypeId te = getTypeDecor(e);

      //if (Types.isErrorTy(tp)) std::cerr << Types.to_string(tp) << std::endl;

      if (not Types.isErrorTy(tp) and not Types.isErrorTy(te) and
        not Types.equalTypes(tp,te)) {
          if(not (Types.isFloatTy(tp) and Types.isIntegerTy(te)))
            Errors.incompatibleParameter(e,i+1,ctx);
        }
    }
    ++i;
  }

  DEBUG_EXIT();
  return 0;
}

antlrcpp::Any TypeCheckVisitor::visitParenthesis(AslParser::ParenthesisContext *ctx) {
  DEBUG_ENTER();
  visit(ctx->expr());
  TypesMgr::TypeId t1 = getTypeDecor(ctx->expr());

  putTypeDecor(ctx, t1);
  putIsLValueDecor(ctx, false);
  DEBUG_EXIT();
  return 0;
}


antlrcpp::Any TypeCheckVisitor::visitBoolean(AslParser::BooleanContext *ctx) {
  DEBUG_ENTER();
  visit(ctx->expr(0));
  TypesMgr::TypeId t1 = getTypeDecor(ctx->expr(0));
  visit(ctx->expr(1));
  TypesMgr::TypeId t2 = getTypeDecor(ctx->expr(1));
  std::string oper = ctx->op->getText();
  if (((not Types.isErrorTy(t1)) and (not Types.isBooleanTy(t1))) or
      ((not Types.isErrorTy(t2)) and (not Types.isBooleanTy(t2))))
    Errors.incompatibleOperator(ctx->op);
  TypesMgr::TypeId t = Types.createBooleanTy();
  putTypeDecor(ctx, t);
  putIsLValueDecor(ctx, false);
  DEBUG_EXIT();
  return 0;
}

antlrcpp::Any TypeCheckVisitor::visitRelational(AslParser::RelationalContext *ctx) {
  DEBUG_ENTER();
  visit(ctx->expr(0));
  TypesMgr::TypeId t1 = getTypeDecor(ctx->expr(0));
  visit(ctx->expr(1));
  TypesMgr::TypeId t2 = getTypeDecor(ctx->expr(1));
  std::string oper = ctx->op->getText();
  if ((not Types.isErrorTy(t1)) and (not Types.isErrorTy(t2)) and
      (not Types.comparableTypes(t1, t2, oper)))
    Errors.incompatibleOperator(ctx->op);
  TypesMgr::TypeId t = Types.createBooleanTy();
  putTypeDecor(ctx, t);
  putIsLValueDecor(ctx, false);
  DEBUG_EXIT();
  return 0;
}

antlrcpp::Any TypeCheckVisitor::visitValue(AslParser::ValueContext *ctx) {
  DEBUG_ENTER();
  if (ctx->INTVAL()) {
    TypesMgr::TypeId t = Types.createIntegerTy();
    putTypeDecor(ctx, t);
  }
  else if (ctx->FLOATVAL()) {
    TypesMgr::TypeId t = Types.createFloatTy();
    putTypeDecor(ctx, t);
  }
  else if (ctx->CHARVAL()) {
    TypesMgr::TypeId t = Types.createCharacterTy();
    putTypeDecor(ctx, t);
  }
  else if (ctx->BOOLVAL()) {
    TypesMgr::TypeId t = Types.createBooleanTy();
    putTypeDecor(ctx, t);
  }
  putIsLValueDecor(ctx, false);
  DEBUG_EXIT();
  return 0;
}

antlrcpp::Any TypeCheckVisitor::visitExprIdent(AslParser::ExprIdentContext *ctx) {
  DEBUG_ENTER();
  visit(ctx->ident());
  TypesMgr::TypeId t1 = getTypeDecor(ctx->ident());
  putTypeDecor(ctx, t1);
  bool b = getIsLValueDecor(ctx->ident());
  putIsLValueDecor(ctx, b);
  DEBUG_EXIT();
  return 0;
}

antlrcpp::Any TypeCheckVisitor::visitIdent(AslParser::IdentContext *ctx) {
  DEBUG_ENTER();
  std::string ident = ctx->getText();

  //if (Symbols.findInStack(ident) == -1) {
  //  Errors.undeclaredIdent(ctx->ID());
  //  TypesMgr::TypeId te = Types.createErrorTy();
  //  putTypeDecor(ctx, te);
  //  putIsLValueDecor(ctx, true);
  //}
  //else {
  //  TypesMgr::TypeId t1 = Symbols.getType(ident);
  //  putTypeDecor(ctx, t1);
  //  if (Symbols.isFunctionClass(ident))
  //    putIsLValueDecor(ctx, false);
  //  else
  //    putIsLValueDecor(ctx, true);
  //}

  if (Symbols.findInStack(ident) == -1) {
		Errors.undeclaredIdent(ctx->ID());
		putTypeDecor(ctx, Types.createErrorTy());
		putIsLValueDecor(ctx, true);
	} else {
		putTypeDecor(ctx, Symbols.getType(ident));
		putIsLValueDecor(ctx, not Symbols.isFunctionClass(ident));
	}


  DEBUG_EXIT();
  return 0;
}


// Getters for the necessary tree node atributes:
//   Scope, Type ans IsLValue
SymTable::ScopeId TypeCheckVisitor::getScopeDecor(antlr4::ParserRuleContext *ctx) {
  return Decorations.getScope(ctx);
}
TypesMgr::TypeId TypeCheckVisitor::getTypeDecor(antlr4::ParserRuleContext *ctx) {
  return Decorations.getType(ctx);
}
bool TypeCheckVisitor::getIsLValueDecor(antlr4::ParserRuleContext *ctx) {
  return Decorations.getIsLValue(ctx);
}

// Setters for the necessary tree node attributes:
//   Scope, Type ans IsLValue
void TypeCheckVisitor::putScopeDecor(antlr4::ParserRuleContext *ctx, SymTable::ScopeId s) {
  Decorations.putScope(ctx, s);
}
void TypeCheckVisitor::putTypeDecor(antlr4::ParserRuleContext *ctx, TypesMgr::TypeId t) {
  Decorations.putType(ctx, t);
}
void TypeCheckVisitor::putIsLValueDecor(antlr4::ParserRuleContext *ctx, bool b) {
  Decorations.putIsLValue(ctx, b);
}
