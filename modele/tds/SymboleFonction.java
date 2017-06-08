package compilation.modele.tds;

import java.util.ArrayList;

import compilation.modele.Compilation;

public class SymboleFonction extends Symbole {

	protected ArrayList<String> arguments;
	protected String label;
	protected int numeroRegion;

	public SymboleFonction(String statut, String type,
			ArrayList<SymboleVariable> arguments, String idf) {
		
		super(statut, type, 0);
		label = idf + "" + Compilation.getInstance().getNombreId();
		
		int positionArgument = 0;

		for (SymboleVariable e : arguments) {
			positionArgument-= 4;
			e.setDeplacement(positionArgument);
			
		}

		numeroRegion = TableDesSymboles.getInstance().getNumeroBloc();
		
	}

	@Override
	public String toString() {
		return null;
	}

	@Override
	public boolean equals(Object obj) {
		SymboleFonction s = (SymboleFonction) obj;
		return arguments.equals(s.arguments);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getNumeroRegion() {
		return numeroRegion;
	}

	public void setNumeroRegion(int numeroRegion) {
		this.numeroRegion = numeroRegion;
	}

	
	
}
