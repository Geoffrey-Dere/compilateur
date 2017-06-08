package compilation.modele.arbreAbstrait.instruction;

import compilation.exception.SemantiqueException;
import compilation.modele.arbreAbstrait.ArbreAbstrait;
import compilation.modele.arbreAbstrait.Bloc;
import compilation.modele.tds.SymboleFonction;

public class Fonction extends ArbreAbstrait {

	protected Bloc instructions;
	protected String label;
	protected int numeroBloc;
	protected String nom;
	protected int ligne;

	public Fonction(SymboleFonction e, Bloc bloc, String nom, int ligne) {
		instructions = bloc;
		label = e.getLabel();
		numeroBloc = e.getNumeroRegion();
		this.nom=nom;
		this.ligne=ligne;
	}

	@Override
	public String genererCode() {

		StringBuilder sb = new StringBuilder();

		sb.append(line + line + label + ":" + line);

		// adresse de retour
		sb.append("move $t1, $sp" + line);

		sb.append("add $sp, $sp, -4" + line);
		sb.append("sw $ra, 0($sp)" + line);
		// pointeur bloc (parent)
		sb.append("add $sp, $sp, -4" + line);
		sb.append("sw $fp, 0($sp)" + line);

		sb.append("move $fp,$t1" + line);

		// numero region
		sb.append("add $sp, $sp, -4" + line);
		sb.append("li $t0, " + numeroBloc + line);
		sb.append("sw $t0, 0($sp)" + line);

		// sb.append("sw $ra, 0($sp)" + line);
		 sb.append(this.instructions.genererCode());
		
		//fin
		sb.append("add $sp, $sp, 4" + line);
		sb.append("lw $fp, 0($sp)" + line);
		
		sb.append("addi $sp, $sp, 4" + line);
		sb.append(" lw $ra, 0($sp)" + line);
		

		sb.append("jr $ra # return" + line);
		
		
		sb.append("# fin fonction " + label + line + line + line);

		return sb.toString();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void verifier() throws SemantiqueException {
		instructions.verifier();
		
		boolean check = false;
		for(ArbreAbstrait a : instructions.getInstructions()){
			if(a instanceof Retourne){
				check=true;
				break;
			}
		}
		
		if(check==false){
			throw new SemantiqueException(ligne, "Fonction "+nom+ " :  manque instruction retourne");
		}
		

	}

}
