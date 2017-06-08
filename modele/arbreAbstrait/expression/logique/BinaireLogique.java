package compilation.modele.arbreAbstrait.expression.logique;

import compilation.modele.arbreAbstrait.expression.Binaire;
import compilation.modele.arbreAbstrait.expression.Constante;
import compilation.modele.arbreAbstrait.expression.Expression;
/**
 * 
 * classe abstraite BinaireLogique héritant Binaire
 * Correspond à une operation logique avec deux expressions de booléennes
 * le résultat l'opération est de type booléenne
 */
public abstract class BinaireLogique extends Binaire{

	protected BinaireLogique(Expression e1, Expression e2) {
		super(e1, e2);
	}

	protected BinaireLogique(Expression e1, Expression e2, int ligne) {
		super(e1, e2, ligne);
	}
	
	public Constante evaluer(){
		assert(1==2);
		return null;
	}

}
