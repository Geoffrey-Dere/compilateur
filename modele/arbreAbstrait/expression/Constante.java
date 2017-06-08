package compilation.modele.arbreAbstrait.expression;

import compilation.Code;
import compilation.exception.SemantiqueException;

/**
 * 
 * classe Booleen héritant d'Expression
 * Creer le code MIPS correspondant aux constantes
 *
 */

public class Constante extends Expression {

	public int constante ;

	public Constante(String constante){
		this.constante = new Integer(constante);
	}

	public Constante (int constante){
		this.constante=constante;
	}
	
	@Override
	public String genererCode() {
		StringBuilder sb = new StringBuilder();
		sb.append("# on enregistre " +constante+ " dans  le registre v0" + line);
		sb.append("li $v0, " +constante + line);	

		return sb.toString();
	}

	@Override
	public String getType() {
		return Code.ENTIER;
	}

	
	@Override
	public String toString() {
		return constante+"";
	}

	@Override
	public void verifier() throws SemantiqueException {
		
	}
	
	public int toInteger(){
		return new Integer(constante);
	}
	
	@Override
	public Constante evaluer() {
		return this;
	}
	
	public int getValeur(){
		return constante;
	}
}
