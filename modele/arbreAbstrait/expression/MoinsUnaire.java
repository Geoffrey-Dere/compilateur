package compilation.modele.arbreAbstrait.expression;

import compilation.Code;
import compilation.exception.SemantiqueException;

/**
 * 
 * classe MoinsUnaire héritant d'Expression
 * 
 *Permet de générer le code MIPS d'une valeur negatif ou l'inverse d'un booleen
 *
 */
public class MoinsUnaire extends Expression {

	protected Expression e;

	public MoinsUnaire(Expression e){
		this.e=e;
	}

	@Override
	public String genererCode() {

		StringBuilder sb = new StringBuilder( e.genererCode());	
		if (e instanceof Booleen){
			sb.append("li $t8, 1"+line);
			sb.append("xor $v0,$v0,$t8" +line);	
		} else {
			sb.append("sub $v0,$zero,$v0"+line);	
		}
		return sb.toString();
	}

	@Override
	public String getType() throws SemantiqueException{
		return e.getType();
	}

	@Override
	public String toString() {
		return "-" + e;
	}

	@Override
	public void verifier() throws SemantiqueException {
		e.verifier();

	}

	@Override
	public Constante evaluer() {
		return new Constante (- e.evaluer().toInteger());
	}
}
