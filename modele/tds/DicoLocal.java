package compilation.modele.tds;

import java.util.HashMap;
import java.util.Map;

import compilation.exception.DoubleDeclaration;

public class DicoLocal {

	protected HashMap<Entree, Symbole> table = new HashMap<Entree, Symbole>();

	protected int numeroRegion;

	public DicoLocal(int numeroRegion) {
		this.numeroRegion = numeroRegion;
	}

	public void ajouter(Entree e, Symbole s) throws DoubleDeclaration {

		if (table.containsKey(e)) {

			throw new DoubleDeclaration("double declaration "
					+ e.getIdentificateur());
		}

		table.put(e, s);
	}

	public Symbole identifier(Entree e) {
		return table.get(e);
	}

	public boolean hasKey(Entree key) {
		return table.containsKey(key);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DicoLocal other = (DicoLocal) obj;
		if (table == null) {
			if (other.table != null)
				return false;
		} else if (!table.equals(other.table))
			return false;
		return true;
	}

	public int size() {
		int size = 0;
		for (Map.Entry<Entree, Symbole> entree : table.entrySet()) {
			size += entree.getValue().getTaille();
		}
		return size;
	}

	public String toString() {
		StringBuilder chaine = new StringBuilder();

		for (Map.Entry<Entree, Symbole> entree : table.entrySet()) {
			Symbole s = entree.getValue();
			chaine.append("Cle : " + entree.getKey());
			chaine.append(" -- " + s.getClass().getSimpleName()
					+ " --  Valeur : " + entree.getValue() + "\n");
		}
		return chaine.toString();
	}

	public HashMap<Entree, Symbole> getH() {
		return table;
	}

	public int getNumeroRegion() {
		return numeroRegion;
	}

	public void setNumeroRegion(int numeroRegion) {
		this.numeroRegion = numeroRegion;
	}

	/*
	 * public static void main(String[] a ) throws DoubleDeclaration{
	 * 
	 * DicoLocal dico = new DicoLocal(); Entree e = new Entree("e"); Entree aa =
	 * new Entree("a"); dico.ajouter(e, null); dico.ajouter(new Entree("e"),
	 * null);
	 * 
	 * HashMap<Entree, Symbole> table = dico.getH();
	 * System.out.println(table.containsKey(new Entree("e")));
	 * System.out.println(e.equals(aa)); }
	 */

}
