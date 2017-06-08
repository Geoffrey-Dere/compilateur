package compilation.modele.arbreAbstrait.instruction;

import compilation.modele.arbreAbstrait.expression.Expression;

public abstract class Ecrire extends Instruction {
	protected Expression exp;

	public Ecrire( int ligne){
		super(ligne);	
	}

}
