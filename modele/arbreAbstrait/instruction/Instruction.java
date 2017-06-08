package compilation.modele.arbreAbstrait.instruction;

import compilation.exception.SemantiqueException;
import compilation.modele.arbreAbstrait.ArbreAbstrait;

public abstract class Instruction extends ArbreAbstrait {

	protected int ligne;

	protected Instruction(int ligne){
		this.ligne = ligne;
	}

	public abstract void verifier() throws SemantiqueException;
}
