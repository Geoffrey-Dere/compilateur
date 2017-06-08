package compilation.modele.arbreAbstrait.expression.arithmetique;

import compilation.modele.arbreAbstrait.expression.Binaire;
import compilation.modele.arbreAbstrait.expression.Expression;
/**
 * 
 * classe abstraite BinaireArithmetique h�ritant Binaire
 * Correspond � une operation arithmetique avec deux expressions de type arithm�tique ou bool�enne
 * le r�sultat de l'op�ration est le m�me que 
 */
public abstract class BinaireArithmetique extends Binaire{

	protected BinaireArithmetique(Expression e1, Expression e2) {
		super(e1, e2);
	}

	protected BinaireArithmetique(Expression e1, Expression e2,int ligne) {
		super(e1, e2,ligne);
	}

}
