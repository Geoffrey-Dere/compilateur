package compilation.modele.arbreAbstrait;

import compilation.exception.SemantiqueException;
import compilation.modele.arbreAbstrait.instruction.Instruction;


public abstract class  ArbreAbstrait {
	
	/**
	 * 
	 * classe abstraite ArbreAbstrait
	 * 
	 *
	 */
	//permet de passer des lignes
		public final static String line = System.getProperty("line.separator");
		
		//retourne le code MIPS correspondant
		public abstract String genererCode();
				
		public abstract String toString();
		
		public abstract void verifier() throws SemantiqueException ;
		
	}
