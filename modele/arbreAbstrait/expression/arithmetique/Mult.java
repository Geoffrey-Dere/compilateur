package compilation.modele.arbreAbstrait.expression.arithmetique;

import compilation.Code;
import compilation.modele.arbreAbstrait.expression.Constante;
import compilation.modele.arbreAbstrait.expression.Expression;
/**
 * 
 * 
 * classe Mult héritant BinaireArithmetique
 * 
 *permet d'effectuer l'operation arithmetique "multiplier" en MIPS
 */
public class Mult extends BinaireArithmetique {

	public Mult(Expression e1, Expression e2) {
		super(e1, e2);
	}

	public Mult(Expression e1, Expression e2, int ligne){
		super(e1,e2,ligne);
	}

	@Override
	public String genererCode() {
		StringBuilder sb = new StringBuilder();

		sb.append(e1.genererCode());
		sb.append("sw $v0,0($sp)"+line);
		sb.append("add $sp, $sp, -4"+line);
		sb.append(e2.genererCode());
		sb.append("add $sp, $sp, 4"+line);
		sb.append("lw $t8, 0($sp)"+line);

		if (typeOperation.equals(Code.ENTIER)){
			sb.append("mul $v0,$v0,$t8" +line);
		} else {
			// opérateur AND 
			sb.append("and $v0,$v0,$t8" +line);		
		}
		sb.append(line);
		return sb.toString();
	}

	public Constante evaluer() {
		return new Constante(e1.evaluer().toInteger() * e2.evaluer().toInteger());
	}
	
	@Override
	public String toString() {
		return  e1 + "*"+ e2;
	}
}
