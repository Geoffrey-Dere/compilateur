package compilation.exception;

@SuppressWarnings("serial")
public class LexicalExceptions extends ExceptionGrammaire{
	/**
	 * Classe LexicalExceptions exception
	 * Cette exception est générée par l'analyseur lexical, lorsque un symbole rencontré est non connu
	 */
	public LexicalExceptions(String s,int ligne) {
		super("LEXICAL",s,ligne);
	}

}