package compilation.exception;


@SuppressWarnings("serial")
public abstract class ExceptionGrammaire extends Exception {

	public ExceptionGrammaire(String id, String s, int ligne) {
		super("ERREUR "+id +": ligne no "+ ligne +" : "+ s+".");
	}

	public ExceptionGrammaire(String id, String s,int ligne, Object value) {
		super("ERREUR "+id +": ligne no "+ ligne +" : "+ s+" \"" +value+"\"");
	}
}
