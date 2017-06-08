package compilation.modele.arbreAbstrait.expression;

import compilation.exception.SemantiqueException;
import compilation.modele.tds.Entree;
import compilation.modele.tds.EntreeVariable;
import compilation.modele.tds.Symbole;
import compilation.modele.tds.TableDesSymboles;

public class Identifiant extends Expression {

	protected Entree variable;
	protected String type;
	protected int ligne;
	protected int deplacement;
	protected Expression indice;
	protected int numeroBloc;

	public Identifiant(String a) {
		this.variable = new EntreeVariable(a);
		numeroBloc = TableDesSymboles.getInstance().getNumeroBloc();
	}

	public Identifiant(String a, int ligne) {
		this.variable = new EntreeVariable(a);
		this.ligne = ligne;
		numeroBloc = TableDesSymboles.getInstance().getNumeroBloc();
	}

	public Identifiant(String a, Expression e, int ligne) {
		this.variable = new EntreeVariable(a);
		this.ligne = ligne;
		this.indice = e;
		numeroBloc = TableDesSymboles.getInstance().getNumeroBloc();
	}

	@Override
	public String genererCode() {
		StringBuilder chaine = new StringBuilder();
		chaine.append("# code variable " + line);
		chaine.append("lw $v0, " + deplacement + "($s7)" + line);
		return chaine.toString();
	}

	@Override
	public void verifier() throws SemantiqueException {
		Symbole symbole = TableDesSymboles.getInstance().identifier(variable);

		if (symbole == null) {

			throw new SemantiqueException(ligne, "variable "
					+ variable.getIdentificateur() + " indéfinie ");
		}

		this.type = symbole.getType();
		this.deplacement = symbole.getDeplacement();
	}

	public String getIdf() {
		return this.variable.getIdentificateur();
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return ""+ variable ;
	}

	public Entree getVariable() {
		return variable;
	}

	public void setVariable(Entree variable) {
		this.variable = variable;
	}

	public int getLigne() {
		return ligne;
	}

	public void setLigne(int ligne) {
		this.ligne = ligne;
	}

	public int getDeplacement() {
		return deplacement;
	}

	public void setDeplacement(int deplacement) {
		this.deplacement = deplacement;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Expression getIndice() {
		return indice;
	}

	public void setIndice(Expression indice) {
		this.indice = indice;
	}

	@Override
	public Constante evaluer() {
		assert (1 == 2);
		return null;
	}

	public int getNumeroBloc() {
		return numeroBloc;
	}

	public void setNumeroBloc(int numeroBloc) {
		this.numeroBloc = numeroBloc;
	}

}
