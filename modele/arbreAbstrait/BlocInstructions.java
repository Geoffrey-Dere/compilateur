package compilation.modele.arbreAbstrait;

import java.lang.reflect.Array;
import java.util.ArrayList;

import compilation.exception.SemantiqueException;
import compilation.modele.Compilation;
import compilation.modele.arbreAbstrait.instruction.Instruction;
import compilation.modele.tds.TableDesSymboles;
/**
 * 
 * classe BlocInstructions 
 * contient l'arbre abstrait généré par l'analyseur syntaxique
 */

public class BlocInstructions extends ArbreAbstrait {

	
	protected ArrayList<ArbreAbstrait> blocs = new ArrayList<ArbreAbstrait>();
	protected ArrayList<ArbreAbstrait> fonctions = new ArrayList<ArbreAbstrait>();
	
	
	public BlocInstructions(){		
	}
	
	
	public void add(ArbreAbstrait a){
		this.blocs.add(a);
	}

	public void addFonction(ArbreAbstrait a){
		this.fonctions.add(a);
	}

	@Override
	public String genererCode() {

		StringBuilder sb = new StringBuilder();

		for (int i = 0 ; i < blocs.size() ; i++){
			
			sb.append(blocs.get(i).genererCode());	
		}
		
		sb.append(line+"end:"+line);
		sb.append("# fin du programme"+line);
		sb.append("li $v0, 10   # retour au systeme"+line);
		sb.append("syscall"+line);
		
		for (ArbreAbstrait a :  fonctions){
			sb.append(a.genererCode());
		}

		return sb.toString();
	}

	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (ArbreAbstrait a: blocs){
			sb.append(a.toString());
		}
		
		return sb.toString();
	}


	public void verifier() {
		for(ArbreAbstrait bloc : blocs){
			try {
				bloc.verifier();
			} catch (SemantiqueException e) {
				System.out.println(e.getMessage());
				Compilation.getInstance().setErreurSemantique(true);
			}
		}
		
		for(ArbreAbstrait bloc : fonctions ){
			try {
				bloc.verifier();
			} catch (SemantiqueException e) {
				System.out.println(e.getMessage());
				Compilation.getInstance().setErreurSemantique(true);
			}
		}
	}



}
