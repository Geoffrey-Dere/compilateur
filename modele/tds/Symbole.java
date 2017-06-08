package compilation.modele.tds;

public abstract class Symbole {

	protected String type;
	protected String statut ; 
	protected int deplacement;
	protected int taille;
	
	public abstract String toString();

	protected Symbole (){
	}
	
	
	protected Symbole (String statut, String type, int taille){
		this.type=type;
		this.statut = statut;
		this.taille = taille;
		this.deplacement = TableDesSymboles.getInstance().size() *4;
	}
	
	
	protected Symbole (String type, int taille){
		this.type=type;
		this.taille = taille;
		this.deplacement = TableDesSymboles.getInstance().size() *4;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDeplacement() {
		return deplacement;
	}

	public void setDeplacement(int deplacement) {
		this.deplacement = deplacement;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public int getTaille() {
		return taille;
	}
	
	public void setTaille(int taille){
		this.taille = taille;
	}

	public void setDeplacement() {
		deplacement = TableDesSymboles.getInstance().size() *4;		
	}
}
