//////////////////////////////////////////////////////////////////////
//
//    Asl - Another simple language (grammar)
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

grammar Asl;

//////////////////////////////////////////////////
/// Parser Rules
//////////////////////////////////////////////////

// A program is a list of functions
program : function+ EOF
        ;

// A function has a name, a list of parameters and a list of statements
function
        : FUNC ID '(' (parameter_decl (',' parameter_decl)* )? ')' (':' basic_type)? declarations statements ENDFUNC
        ;

parameter_decl
        : ID ':' type
        ;

declarations
        : (variable_decl)*
        ;

variable_decl
        : VAR ID (',' ID)* ':' type
        ;

type
        : basic_type
        | array_type
        ;

array_type
        : ARRAY '[' INTVAL ']' OF basic_type
        ;

basic_type    
        : INT
        | BOOL
        | FLOAT
        | CHAR
        ;

statements
        : (statement)*
        ;

// The different types of instructions
statement
          // Assignment
        : left_expr ASSIGN expr ';'           # assignStmt
          // if-then-else statement (else is optional)
        | IF expr THEN statements (ELSE statements)? ENDIF       # ifStmt
          // while-do statmen
        | WHILE expr DO statements ENDWHILE   # whileStmt
          // A function/procedure call has a list of arguments in parenthesis (possibly empty)
        | ident '(' (expr (',' expr)* )? ')' ';'                   # procCall
          // Read a variable
        | READ left_expr ';'                    # readStmt
          // Write an expression
        | WRITE expr ';'                        # writeExpr
          // Write a string     
        | WRITE STRING ';'                      # writeString
          // Return an expresion
        | RETURN (expr)? ';'                    #returnExpr
        ;

// Grammar for left expressions (l-values in C++)
left_expr 
        : ident ( '[' expr ']' )?
        ;

// Grammar for expressions with boolean, relational and aritmetic operators
expr    : '(' expr ')'                                  # parenthesis
        | ident '[' expr ']'                            # arrayIndex
        | ident '(' (expr (',' expr)* )? ')'            # funcCall
        | op=(NOT | MINUS | PLUS) expr                  # unary
        | expr op=(MUL | DIV | MOD) expr                # arithmetic
        | expr op=(PLUS | MINUS) expr                   # arithmetic
        | expr op=(EQUAL | LS | BS | LE | BE | DIFF) expr # relational
        | expr op=AND expr                              # boolean
        | expr op=OR expr                               # boolean
        | (INTVAL | FLOATVAL | CHARVAL | BOOLVAL)       # value
        | ident                                         # exprIdent
        ;

// Identifiers
ident   : ID 
        ;

//////////////////////////////////////////////////
/// Lexer Rules
//////////////////////////////////////////////////

ASSIGN    : '=' ;

EQUAL     : '==' ;
DIFF      : '!=';
NOT       : 'not';
AND       : 'and';
OR        : 'or';

PLUS      : '+' ;
MINUS     : '-';
MUL       : '*';
DIV       : '/';
MOD       : '%';

LS        : '<';
BS        : '>';
LE        : '<=';
BE        : '>=';

VAR       : 'var';
INT       : 'int';
BOOL      : 'bool';
FLOAT     : 'float';
CHAR      : 'char';
ARRAY     : 'array';
OF        : 'of' ;

RETURN    : 'return' ;
IF        : 'if' ;
THEN      : 'then' ;
ELSE      : 'else' ;
ENDIF     : 'endif' ;
WHILE     : 'while' ;
DO        : 'do';
ENDWHILE  : 'endwhile';
FUNC      : 'func' ;
ENDFUNC   : 'endfunc' ;

READ      : 'read' ;
WRITE     : 'write' ;

INTVAL    : ('0'..'9')+ ;
FLOATVAL  : ('0'..'9')+ '.' ('0'..'9')+;
CHARVAL   : '\'' (.|ESC_SEQ) '\'';
BOOLVAL   : 'true' | 'false';
ID        : ('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')* ;
 
// Strings (in quotes) with escape sequences
STRING    : '"' ( ESC_SEQ | ~('\\'|'"') )* '"' ;

fragment
ESC_SEQ   : '\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\') ;

// Comments (inline C++-style)
COMMENT   : '//' ~('\n'|'\r')* '\r'? '\n' -> skip ;

// White spaces
WS        : (' '|'\t'|'\r'|'\n')+ -> skip ;
// Alternative description
// WS        : [ \t\r\n]+ -> skip ;
