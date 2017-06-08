package compilation.modele.arbreAbstrait.expression;

import compilation.exception.SemantiqueException;
import compilation.modele.arbreAbstrait.ArbreAbstrait;
/**
 * 
 * classe abstraite Expression h�ritant d'ArbreAbstrait
 * 
 *
 */
/**
 * 
 * classe abstraite Expression h�ritant d'ArbreAbstrait
 * 
 *
 */
public abstract  class Expression extends ArbreAbstrait{

	protected Expression(){

	}
	
	public abstract String getType() throws SemantiqueException;
	public  abstract Constante evaluer();
}
