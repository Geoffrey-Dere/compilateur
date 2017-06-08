package compilation.modele.tds;

public abstract class Entree {

	protected String identificateur;

	public Entree(String idf){
		this.identificateur=idf;
	}

	public String getIdentificateur() {
		return identificateur;
	}

	public void setIdentificateur(String identificateur) {
		this.identificateur = identificateur;
	}

	
	public String toString(){
		return identificateur;
	}
	

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((identificateur == null) ? 0 : identificateur.hashCode() + getClass().getName().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entree other = (Entree) obj;
		if (identificateur == null) {
			if (other.identificateur != null)
				return false;
		} else if (!identificateur.equals(other.identificateur))
			return false;
		return true;
	}	
}
