package compilation.modele.arbreAbstrait.expression.arithmetique;

import compilation.modele.arbreAbstrait.expression.Binaire;
import compilation.modele.arbreAbstrait.expression.Expression;
/**
 * 
 * classe abstraite BinaireArithmetique héritant Binaire
 * Correspond à une operation arithmetique avec deux expressions de type arithmétique ou booléenne
 * le résultat de l'opération est le même que 
 */
public abstract class BinaireArithmetique extends Binaire{

	protected BinaireArithmetique(Expression e1, Expression e2) {
		super(e1, e2);
	}

	protected BinaireArithmetique(Expression e1, Expression e2,int ligne) {
		super(e1, e2,ligne);
	}

}
