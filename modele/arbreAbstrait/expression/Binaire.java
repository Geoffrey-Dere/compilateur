package compilation.modele.arbreAbstrait.expression;

import compilation.Code;
import compilation.exception.SemantiqueException;

/**
 * 
 * classe Binaire héritant d'Expression 
 */

public abstract class  Binaire extends Expression {

	protected Expression e1;
	protected Expression e2;
	protected int ligne = -1;
	protected String typeOperation;

	
	protected Binaire(Expression e1, Expression e2){
		this.e1=e1;
		this.e2=e2;
	}

	protected Binaire(Expression e1, Expression e2, int ligne){
		this.e1=e1;
		this.e2=e2;
		this.ligne=ligne+1;
	}

	@Override
	public void verifier() throws SemantiqueException {

		 typeOperation = getType();
	}

	public String getType() throws SemantiqueException{

		e1.verifier();
		e2.verifier();
		String fg = e1.getType();
		String fd = e2.getType();
				
		if(! fg.equals(fd)){
			throw new SemantiqueException(ligne, "incompatible type entre entier et booléen");
		}

		return fg;
	}

	public String getTypeOperation() {
		return typeOperation;
	}

	public void setTypeOperation(String typeOperation) {
		this.typeOperation = typeOperation;
	}
	
}
