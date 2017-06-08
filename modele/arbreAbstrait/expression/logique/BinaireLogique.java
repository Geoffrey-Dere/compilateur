package compilation.modele.arbreAbstrait.expression.logique;

import compilation.modele.arbreAbstrait.expression.Binaire;
import compilation.modele.arbreAbstrait.expression.Constante;
import compilation.modele.arbreAbstrait.expression.Expression;
/**
 * 
 * classe abstraite BinaireLogique h�ritant Binaire
 * Correspond � une operation logique avec deux expressions de bool�ennes
 * le r�sultat l'op�ration est de type bool�enne
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
