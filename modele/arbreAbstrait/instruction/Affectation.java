package compilation.modele.arbreAbstrait.instruction;

import compilation.Code;
import compilation.exception.SemantiqueException;
import compilation.modele.arbreAbstrait.expression.Expression;
import compilation.modele.arbreAbstrait.expression.Identifiant;

public class Affectation extends Instruction{

	protected Identifiant var;
	protected Expression exp;
	protected String type;

	public Affectation (Identifiant var, Expression exp, int ligne) throws SemantiqueException{

		super(ligne);
		this.var = var;
		this.exp=exp;	
		
	}

	@Override
	public String genererCode() {

		StringBuilder chaine = new StringBuilder();

		if(var.getType().equals(Code.ENTIER)){
			chaine.append(exp.genererCode());
			chaine.append("sw $v0, " + var.getDeplacement() + "($s7) "+line);	

		} else if (var.getType().equals(Code.TABLEAUENTIER)){

		}


		return chaine.toString();
	}

	@Override
	public String toString() {
		return var +" = "+ exp + line;
	}

	@Override
	public void verifier() throws SemantiqueException{
		
		var.verifier();
		exp.verifier();

		if(!var.getType().equals(exp.getType())){
			throw new SemantiqueException(ligne, "affectation entre un booleen et un entier");
		}
		this.type = var.getType();
	}	
}
