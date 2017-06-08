package compilation.modele.arbreAbstrait.expression;

import java.util.ArrayList;

import compilation.Code;
import compilation.exception.SemantiqueException;
import compilation.modele.tds.EntreeFonction;
import compilation.modele.tds.SymboleFonction;
import compilation.modele.tds.TableDesSymboles;

public class IdentifiantFonction extends Expression {

	protected String type;
	protected String idfFonction;
	protected ArrayList<Expression> parametre;
	protected int ligne;
	protected int tailleParametre;
	protected String label;
	protected int numeroBloc;

	public IdentifiantFonction(String idf, ArrayList<Expression> parametre,
			int ligne) {
		this.idfFonction = idf;
		this.parametre = parametre;
		this.ligne = ligne;
	}

	@Override
	public String getType() throws SemantiqueException {
		return Code.ENTIER;
	}

	@Override
	public Constante evaluer() {
		return null;
	}

	@Override
	public String genererCode() {

		StringBuilder sb = new StringBuilder();
		sb.append("add $sp, $sp , -" + tailleParametre + line);
		for (int i = 0; i < parametre.size(); i++) {
			sb.append(parametre.get(i).genererCode());
			sb.append("sw $v0," + i * 4 + "($sp)" + line);
		}

		sb.append("jal " + label + line);
		sb.append("add $sp, $sp , +" + tailleParametre + line);

		return sb.toString();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void verifier() throws SemantiqueException {

		ArrayList<String> type = new ArrayList<>();

		for (Expression e : parametre) {
			e.verifier();
			type.add(e.getType());
		}

		EntreeFonction entreeFonction = new EntreeFonction(idfFonction, type, 0);

		SymboleFonction symbole = (SymboleFonction) TableDesSymboles
				.getInstance().identifier(entreeFonction);

		if (symbole == null) {
			throw new SemantiqueException(ligne, "fonction "
					+ entreeFonction.getIdentificateur() + " introuvable ");
		} else {

			label = symbole.getLabel();
			tailleParametre = symbole.getTaille();
			numeroBloc = symbole.getNumeroRegion();
		}
	}

}
