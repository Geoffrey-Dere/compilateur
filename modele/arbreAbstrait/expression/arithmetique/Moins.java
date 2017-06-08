package compilation.modele.arbreAbstrait.expression.arithmetique;

import compilation.Code;
import compilation.modele.arbreAbstrait.expression.Constante;
import compilation.modele.arbreAbstrait.expression.Expression;
/**	
 * 	
 * classe Moins héritant BinaireArithmetique
 * 
 *permet d'effectuer l'operation arithmetique "soustraction" en MIPS
 */
public class Moins extends BinaireArithmetique{

	public Moins(Expression e1, Expression e2) {
		super(e1, e2);
	}

	public Moins(Expression e1, Expression e2, int ligne){
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
			sb.append("sub $v0,$t8,$v0" +line);
		} else {
			// ou-exclusif
			sb.append("xor $v0,$v0,$t8" +line);		
		}
		sb.append(line);
		return sb.toString();
	}


	@Override
	public String toString() {
		return e1 + "-"+ e2;
	}

	@Override
	public Constante evaluer() {
		return new Constante(e1.evaluer().toInteger() - e2.evaluer().toInteger());
	}
}
