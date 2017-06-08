package compilation.modele.arbreAbstrait.instruction;

import compilation.Code;
import compilation.exception.SemantiqueException;
import compilation.modele.arbreAbstrait.expression.Identifiant;

public class Lire extends Instruction {

	protected Identifiant var;

	public Lire(String idf, int ligne){
		super(ligne);	
		this.var = new Identifiant(idf, ligne);
	}


	@Override
	public void verifier() throws SemantiqueException {
		var.verifier();	
	}

	@Override
	public String genererCode(){

		StringBuilder chaine = new StringBuilder();

		chaine.append("li $v0 , 5 " +line);
		chaine.append("syscall" +line );

		if(var.getType().equals(Code.BOOLEEN)){

			chaine.append("#exception si $v0 > 1 (variable booléee) " + line);
			chaine.append("tgei $v0, 1" + line);

		}
		return chaine.toString();
	}

	@Override
	public String toString() {
		return "lire  "+ var + line ;
	}

}
