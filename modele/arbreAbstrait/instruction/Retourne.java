package compilation.modele.arbreAbstrait.instruction;

import compilation.exception.SemantiqueException;
import compilation.modele.arbreAbstrait.expression.Expression;

public class Retourne extends Instruction {

	protected Expression e;

	public Retourne(Expression e, int ligne) {
		super(ligne);
		this.e = e;
	}

	@Override
	public void verifier() throws SemantiqueException {
		e.verifier();

	}

	@Override
	public String genererCode() {
		StringBuilder sb = new StringBuilder();
		sb.append(e.genererCode());
//		sb.append(" lw $ra, 0($sp)" + line);
//		sb.append("addi $sp, $sp, 4" + line);
//		sb.append("jr $ra # return" + line);
		
		return sb.toString();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
