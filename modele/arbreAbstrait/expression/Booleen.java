package compilation.modele.arbreAbstrait.expression;

import compilation.Code;
import compilation.exception.SemantiqueException;

/**
 * 
 * classe Booleen héritant d'Expression
 * Creer le code MIPS correspondant aux boolean
 *
 */
public  class Booleen extends Expression {

	protected String valeur;
	
	public Booleen(String v){
		this.valeur=v;
	}
	
	@Override
	public String genererCode() {
		StringBuilder sb = new StringBuilder();
		sb.append("li $v0,"+valeur+line);
		return sb.toString();
	}

	@Override
	public String getType() {
		return Code.BOOLEEN;
	}

	
	@Override
	public String toString() {
		return "boolean de valeur "+ valeur ;
	}

	@Override
	public void verifier() throws SemantiqueException {
	}

	@Override
	public Constante evaluer() {
		return null;
	}

}
