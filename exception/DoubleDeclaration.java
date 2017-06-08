package compilation.exception;

@SuppressWarnings("serial")
public class DoubleDeclaration extends Exception {

	public DoubleDeclaration(String erreur){
		super(erreur);
	}
}
