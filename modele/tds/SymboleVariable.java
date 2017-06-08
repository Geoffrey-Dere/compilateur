package compilation.modele.tds;


public class SymboleVariable extends Symbole {

	protected int numeroRegion;
	
	public SymboleVariable(String type){
		super();
		this.type=type;
	}
		
	public SymboleVariable(String statut, String type){
		super(statut, type,1);
		this.numeroRegion = TableDesSymboles.getInstance().getNumeroBloc();
	}

	public SymboleVariable(String statut, String type, int numeroBloc){
		super(statut, type,1);
		this.numeroRegion = numeroBloc;
	}

	@Override
	public String toString() {
		return "(type="+type +", statut ="+statut+", deplacement="+deplacement+ ", taille: "+taille+")";
	}

	public int getNumeroRegion() {
		return numeroRegion;
	}

	public void setNumeroRegion(int numeroRegion) {
		this.numeroRegion = numeroRegion;
	}
	
	
	
	
	
	
}
