package compilation.modele.arbreAbstrait.instruction;

import compilation.modele.Compilation;


public class EcrireChaine extends Ecrire{

	protected String csteChaine ;

	public EcrireChaine(int ligne, String chaine) {
		super(ligne);
		this.csteChaine = chaine;
		csteChaine = csteChaine.replaceAll("\"\"", "\\\\\"");

	}

	@Override
	public String genererCode() {

		int id = Compilation.getInstance().getNombreId();
		
		StringBuilder chaine = new StringBuilder();

		chaine.append(".data" +line);
		chaine.append("str"+id+": .asciiz "+ csteChaine + line);
		chaine.append("lus"+id+":	.space "+csteChaine.length() +line);
		chaine.append(".text" +line);
		chaine.append("li $v0, 4 " +line);
		chaine.append("la $a0, str"+id +line );
		//chaine.append("li $a1, 255" +line);
		chaine.append("syscall " + line);
		return chaine.toString();


	}

	@Override
	public void verifier() {
	}

	@Override
	public String toString() {
		return "ecrireChaine " + csteChaine + line ;
	}


}
