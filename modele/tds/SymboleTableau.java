package compilation.modele.tds;

public class SymboleTableau extends Symbole {

	
	protected int enjambe = 4;
	protected int somme =0 ;
	protected int numeroRegion;
	
	public SymboleTableau (String type, int taille, int numeroBloc){
		super(type, taille);
		this.numeroRegion = numeroBloc;
	}
	
	@Override
	public String toString() {
		return "nb cases " + taille +" , deplacement" + deplacement ;
	}

	public int getEnjambe() {
		return enjambe;
	}

	public void setEnjambe(int enjambe) {
		this.enjambe = enjambe;
	}

	public int getSomme() {
		return somme;
	}

	public void setSomme(int somme) {
		this.somme = somme;
	}	
}
