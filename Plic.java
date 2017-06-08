package compilation;

import compilation.modele.Compilation;


/**
 * Classe d'entr�e de l'application
 * Prend en param�tre le fichier plic � compiler
 * @author Geoffrey Deremetz  & Jimmy Falck
 *
 */
public class Plic{

	public Plic(String fichier) {

		Compilation modele = Compilation.getInstance();
		modele.compiler(fichier);
	}


	public static void main(String[] a) throws Exception{
		
		if (a.length != 2) {
			System.out.println("Erreur d'arguments ! Usage : Plic fichier.plic MainClass");
			System.exit(1);
		}
		new Plic(a[0]);
	}

}



