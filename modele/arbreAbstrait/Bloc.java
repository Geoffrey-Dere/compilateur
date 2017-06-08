package compilation.modele.arbreAbstrait;

import java.util.ArrayList;

import compilation.exception.SemantiqueException;
import compilation.modele.tds.TableDesSymboles;

public class Bloc extends ArbreAbstrait {

	protected ArrayList<ArbreAbstrait> instructions = new ArrayList<ArbreAbstrait>();

	public Bloc(ArrayList<ArbreAbstrait> instructions) {
		this.instructions = instructions;
	}

	public Bloc() {
	}

	@Override
	public String genererCode() {

		StringBuilder sb = new StringBuilder();

		for (ArbreAbstrait a : instructions) {
			sb.append(a.genererCode());
		}

		return sb.toString();

	}

	public void add(ArbreAbstrait a) {
		instructions.add(a);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void verifier() throws SemantiqueException {

		TableDesSymboles.getInstance().empiler();


		for (ArbreAbstrait a : instructions) {
			a.verifier();
		}

		TableDesSymboles.getInstance().depiler();

	}


	public ArrayList<ArbreAbstrait> getInstructions(){
		return this.instructions;
	}

}
