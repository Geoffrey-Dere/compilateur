package compilation.exception;

@SuppressWarnings("serial")
public class LexicalExceptions extends ExceptionGrammaire{
	/**
	 * Classe LexicalExceptions exception
	 * Cette exception est g�n�r�e par l'analyseur lexical, lorsque un symbole rencontr� est non connu
	 */
	public LexicalExceptions(String s,int ligne) {
		super("LEXICAL",s,ligne);
	}

}