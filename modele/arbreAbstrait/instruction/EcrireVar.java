package compilation.modele.arbreAbstrait.instruction;

import compilation.exception.SemantiqueException;
import compilation.modele.arbreAbstrait.expression.Binaire;
import compilation.modele.arbreAbstrait.expression.Expression;
import compilation.modele.arbreAbstrait.expression.Identifiant;

public class EcrireVar extends Ecrire {
	protected Identifiant var;
	protected Expression exp;

	public EcrireVar(Expression e, int ligne){
		super(ligne);
		exp = e;
	}


	@Override
	public void verifier() throws SemantiqueException {		
		exp.verifier();
	}

	@Override
	public String genererCode() {

		StringBuilder chaine = new StringBuilder();

		chaine.append(line+"# ecriture variable"+line);
		chaine.append(exp.genererCode());
		chaine.append("move $t0,$v0"+line);
		chaine.append("li $v0, 1 " +line);
		chaine.append("la $a0, ($t0)" +line );
		//chaine.append("li $a1, 255" +line);
		chaine.append("syscall " + line);
		return chaine.toString();
	}

	@Override
	public String toString() {
		return "lire  "+ exp + line ;
	}

}