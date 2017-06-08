package compilation.modele.tds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Stack;

import compilation.Code;
import compilation.exception.DoubleDeclaration;
import compilation.modele.Compilation;

public class TableDesSymboles {

	private static TableDesSymboles tds = new TableDesSymboles();

	protected Stack<Integer> pile = new Stack<Integer>();
	protected HashMap<Integer, DicoLocal> hash = new HashMap<Integer, DicoLocal>();
	protected int numeroBloc = 0, numeroEmpile = 0;;

	public static TableDesSymboles getInstance() {
		return tds;
	}

	private TableDesSymboles() {

	}

	public void ajouter(String e, Symbole s, int ligne) {
		try {
			hash.get(pile.peek()).ajouter(new EntreeVariable(e), s);
		} catch (DoubleDeclaration e1) {
			System.out.println("ERREUR SEMANTIQUE : ligne " + ligne + " : "
					+ e1.getMessage());
			Compilation.getInstance().setErreurSemantique(true);
		}
	}

	/**
	 * ajouter des variables
	 * 
	 * @param s
	 * @param type
	 * @param ligne
	 * @param c
	 */
	public void ajouter(String s, String type, int ligne, ArrayList<String> c) {

		DicoLocal dicolocal = hash.get(pile.peek());
		// System.out.println(c.toString());

		if (!type.equals(Code.TABLEAUENTIER)) {
			for (String idf : c) {
				try {
					dicolocal.ajouter(new EntreeVariable(idf),
							new SymboleVariable(s, type, numeroBloc));
				} catch (DoubleDeclaration e) {
					System.out.println("ERREUR SEMANTIQUE : ligne " + ligne
							+ " : " + e.getMessage());
					Compilation.getInstance().setErreurSemantique(true);
				}
			}
		} else {
			for (String idf : c) {
				try {
					dicolocal.ajouter(new EntreeVariable(idf),
							new SymboleTableau(type, 0, numeroBloc));
				} catch (DoubleDeclaration e) {
					System.out.println("ERREUR SEMANTIQUE : ligne " + ligne
							+ " : " + e.getMessage());
					Compilation.getInstance().setErreurSemantique(true);
				}
			}

		}
	}

	public void ajouter(Entree entree, Symbole symbole, int ligne) {
		DicoLocal dicolocal = hash.get(pile.peek());

		try {
			dicolocal.ajouter(entree, symbole);
		} catch (DoubleDeclaration e) {
			System.out.println("ERREUR SEMANTIQUE : ligne " + ligne + " : "
					+ e.getMessage());
			Compilation.getInstance().setErreurSemantique(true);
		}
	}

	public void EntrerBloc() {
		numeroBloc++;
		DicoLocal dico = new DicoLocal(numeroBloc);
		pile.push(numeroBloc);
		hash.put(numeroBloc, dico);
	}

	public void sortirBloc() {
		// numeroBloc--;
		pile.pop();
	}

	public Symbole identifier(Entree e) {

		int taillePile = pile.size()-1 ;
		Symbole symbole = null;
		DicoLocal dico;
	
		while (symbole == null && taillePile >= 0) {

			dico = hash.get(pile.get(taillePile));
			symbole = dico.identifier(e);
			taillePile--;
		}

		return symbole;
	}

	public void empiler() {

		numeroEmpile++;
		pile.push(numeroEmpile);

	}

	public void depiler() {
		pile.pop();
	}

	public int getRegionTete() {
		return pile.peek();
	}

	public boolean hasKey(Entree key) {
		int i = pile.peek();
		return hash.get(i).hasKey(key);
	}

	public String toString() {
		/*
		 * StringBuilder chaine = new StringBuilder(); for (DicoLocal dico :
		 * liste) { chaine.append(dico.toString()); }
		 */
		return "";// chaine.toString();
	}

	public int size() {
		int i = pile.peek();
		return hash.get(i).size();
	}

	public String ToStringListe() {
		StringBuilder sb = new StringBuilder();

		for (Entry<Integer, DicoLocal> entry : hash.entrySet()) {
			DicoLocal dico = entry.getValue();

			sb.append("TABLE SYMBOLE " + dico.getNumeroRegion() + "\n");
			sb.append(dico);
			sb.append("****\n");
		}

		return sb.toString();
	}

	public int getNumeroBloc() {
		return pile.peek();
	}

	public void setNumeroBloc(int numeroBloc) {
		this.numeroBloc = numeroBloc;
	}

}