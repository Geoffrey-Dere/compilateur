package compilation.modele.arbreAbstrait.expression.logique;

import compilation.Code;
import compilation.exception.SemantiqueException;
import compilation.modele.arbreAbstrait.expression.Expression;
/**
 * 
 * classe Different h�ritant BinaireLogique
 * 
 *permet d'effectuer l'operation logique != en MIPS
 */
public class Different extends BinaireLogique {

	public Different(Expression e1, Expression e2) {
		super(e1, e2);
	}

	public Different(Expression e1, Expression e2, int ligne){
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

		// sne = vrai si diff�rent
		sb.append("sne $v0, $v0 , $t8");

		sb.append(line);
		return sb.toString();
	}

	@Override
	public String toString() {
		return e1 +"!="+e2+line;
	}

	@Override
	public void verifier() throws SemantiqueException {

		if (! (e1.getType().equals(Code.ENTIER) && e2.getType().equals(Code.ENTIER)) )
			throw new SemantiqueException(ligne , ": operateur '!=' necessite 2 operandes entiers");		
	}
}
