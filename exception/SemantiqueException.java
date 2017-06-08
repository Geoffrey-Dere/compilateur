package compilation.exception;

@SuppressWarnings("serial")
public class SemantiqueException extends Exception {

	public SemantiqueException(){
		super();
	}
	
	public SemantiqueException(int ligne, String texte){
		super("ERREUR SEMANTIQUE: ligne " +ligne +" : " +texte);
	}
}
