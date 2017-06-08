package compilation.exception;

import java_cup.runtime.Symbol;

@SuppressWarnings("serial")
public class SyntaxicExceptions extends ExceptionGrammaire{

	
	public SyntaxicExceptions(String s,int ligne, Symbol s2) {	
		super("SYNTAXIQUE",s,ligne,s2.value);
		
	}

}