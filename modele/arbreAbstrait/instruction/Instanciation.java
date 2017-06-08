package compilation.modele.arbreAbstrait.instruction;

import compilation.Code;
import compilation.exception.SemantiqueException;
import compilation.modele.arbreAbstrait.expression.Expression;
import compilation.modele.arbreAbstrait.expression.Identifiant;
import compilation.modele.tds.EntreeVariable;
import compilation.modele.tds.Symbole;
import compilation.modele.tds.SymboleTableau;
import compilation.modele.tds.TableDesSymboles;

public class Instanciation extends Instruction {

	protected Identifiant var;
	protected String type;
	protected int taille;

	protected Instanciation(int ligne) {
		super(ligne);
	}

	public Instanciation(Identifiant idf, String e, Expression exp, int ligne) {
		super(ligne);

		var = idf;
		this.type=e;
		taille = exp.evaluer().toInteger();

		Symbole symbole = TableDesSymboles.getInstance().identifier( new EntreeVariable(var.getIdf()));

		symbole.setDeplacement();
		symbole.setTaille(taille);	
	}


	@Override
	public void verifier() throws SemantiqueException {
		var.verifier();

		if (!var.getType().equals(Code.TABLEAUENTIER)){
			throw new SemantiqueException(ligne, var.getIdf() + " n'est pas un tableau ");
		}




	}

	@Override
	public String genererCode() {
		return "";
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
