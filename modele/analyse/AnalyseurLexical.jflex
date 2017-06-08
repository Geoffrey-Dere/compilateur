package compilation.modele.analyse ;

import java_cup.runtime.Symbol;
import compilation.exception.LexicalExceptions;      
%%
   
%class AnalyseurLexical
%public

%line
%column
    
%type Symbol
%eofval{
        return symbol(CodesLexicaux.EOF) ;
%eofval}

%cup

%yylexthrow{
LexicalExceptions
%yylexthrow}   
  
   
%{
  private Symbol symbol(int type) {
	return new Symbol(type, yyline, yycolumn) ;
  }

  private Symbol symbol(int type, Object value) {
	return new Symbol(type, yyline, yycolumn, value) ;
  }
%}


%state commentaire

csteEntiere = [0-9]*
csteChaine = \"([^\"]|\"\")*\"
idf = [a-zA-Z]([a-zA-Z0-9])* 
commentaireSlashSlash = [/][/].*


%%




"("			{ return symbol(CodesLexicaux.PAROUV) ; }

")" 		{ return symbol(CodesLexicaux.PARFER) ; }

"+" 		{ return symbol(CodesLexicaux.PLUS) ; }

"-" 		{ return symbol(CodesLexicaux.MOINS) ; }

"*" 		{ return symbol(CodesLexicaux.MULT) ; }

"==" 		{ return symbol(CodesLexicaux.EGAL) ; }

"!=" 		{ return symbol(CodesLexicaux.DIFFERENT) ; }

"<"			{ return symbol(CodesLexicaux.INFERIEUR) ; }

">"       	{ return symbol(CodesLexicaux.SUPERIEUR) ; }

"="			{ return symbol(CodesLexicaux.EGAL) ; }

";" 		{ return symbol(CodesLexicaux.POINTVIRGULE) ; }

"," 		{ return symbol(CodesLexicaux.VIRGULE) ; }

"["			{ return symbol(CodesLexicaux.CROCHO) ; }

"]" 		{ return symbol(CodesLexicaux.CROCHF) ; }

"retourne"  { return symbol(CodesLexicaux.retourne, yytext()) ;}

"publique" 	{ return symbol(CodesLexicaux.publicVar, yytext()) ;}

"privee" 	{ return symbol(CodesLexicaux.priveeVar, yytext()) ; }

"entier" 	{ return symbol(CodesLexicaux.entier, yytext()) ; }

"booleen" 	{ return symbol(CodesLexicaux.booleen, yytext()) ; }

{csteEntiere} { return symbol(CodesLexicaux.csteEntiere, yytext()) ; }

"vrai" 	  { return symbol(CodesLexicaux.VRAI, yytext()) ;}

"faux" 	  { return symbol(CodesLexicaux.FAUX, yytext()) ;}

"classe" { return symbol(CodesLexicaux.classe, yytext()) ;}

"debut" { return symbol(CodesLexicaux.debut, yytext()) ;}

"fin" 	{ return symbol(CodesLexicaux.FIN, yytext()) ;}

"lire"  	{ return symbol(CodesLexicaux.lire, yytext()) ; }

"ecrire"  	{ return symbol(CodesLexicaux.ecrire, yytext()) ; }

"nouveau" { return symbol(CodesLexicaux.nouveau, yytext()) ; }

{csteChaine}		{return symbol(CodesLexicaux.csteChaine, yytext() ) ; }
	
{idf}   { return symbol(CodesLexicaux.idf, yytext()) ; }


[\r\t\n|\r\n| \n]*                         {}

.          {throw new LexicalExceptions("symbole inconnu \""+yytext()+"\" ",yyline); }






<YYINITIAL> {commentaireSlashSlash} { }





