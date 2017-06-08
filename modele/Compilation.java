package compilation.modele;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import compilation.exception.LexicalExceptions;
import compilation.exception.SyntaxicExceptions;
import compilation.modele.analyse.AnalyseurLexical;
import compilation.modele.analyse.AnalyseurSyntaxique;
import compilation.modele.arbreAbstrait.BlocInstructions;
import compilation.modele.tds.TableDesSymboles;


/**
 * Classe Compilation singleton 
 *
 *Lis le fichier d'entr�e, 
 *compile le langage plic en assembleur
 *
 * @author Geoffrey Deremetz & Jimmy Falck
 *
 */
public class Compilation {

	private static Compilation modele = new Compilation();

	private boolean erreurSemantique = false ;
	private String pathFichier ;
	private String codePlic ;
	private String codeCompile = null;
	
	private int nombreId = 0 ;
	
	public static Compilation getInstance(){
		return modele ;
	}

	private Compilation(){

	}

	public void compiler(String fichier) {

		try{

			//lecture du fichier
			ouvrirFichier(fichier);

			//analyse du code du fichier
			AnalyseurSyntaxique analyseur = new AnalyseurSyntaxique(
					new AnalyseurLexical(
							new ByteArrayInputStream(codePlic.getBytes()))) ;


			BlocInstructions bloc = (BlocInstructions) analyseur.parse().value;
			
			bloc.verifier();
//			
//			System.out.println("******************");
//			System.out.println(TableDesSymboles.getInstance().ToStringListe());
//			System.out.println("******************");
			//System.out.println(TableDesSymboles.getInstance().toString());
			
			//System.out.println("**"+bloc.toString());
			//bloc.genererCode();
			//erreurSemantique =true;
			if (erreurSemantique == false) {
				codeCompile = genererEcriteMips(bloc);
				//System.out.println(codeCompile );
				

				// ecriture dans le fichier asm
				ecrireFichier();
				System.out.println("COMPILATION OK");
				//System.out.println("nouveau fichier "+pathFichier);
				//String[] tab = { pathFichier };
				//new MarsLaunch(tab);
	
			}

		} catch (LexicalExceptions le) {
			System.out.println(le.getMessage());
			System.exit(1);


		} catch (SyntaxicExceptions se) {
			System.out.println(se.getMessage());
			System.exit(1);

		} catch (FileNotFoundException f){
			System.out.println("impossible d\'ouvrir le fichier " + fichier);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	private String genererEcriteMips(BlocInstructions bloc) {
			
				StringBuilder sb = new StringBuilder();
				String line = System.getProperty("line.separator");
				
				sb.append("main :"+line);
				sb.append("# initialiser s7 avec sp (initialisation de la base des variables)"+line);
				sb.append("move $s7,$sp"+line);
				sb.append("move $fp,$sp"+line);
				int deplacement = TableDesSymboles.getInstance().size();
				sb.append("addi $sp, $sp, " + -deplacement*4 + line);
				sb.append(line + line + line);
				sb.append(bloc.genererCode());
				
				
		return sb.toString();
	}

	
	
	/**
	 * 
	 * @param fichier
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void ouvrirFichier(String fichier) throws FileNotFoundException, IOException {

		int taille = fichier.length();

		String extension = fichier.substring(taille - 5);

		//verification de la bonne extension
		if (extension.compareTo(".plic") != 0) {
			System.out.println("Erreur de fichier ! Fichier de type '.plic' requis");
			System.exit(2);
		}
		//lecture du fichier

		BufferedReader br = new BufferedReader(new FileReader(fichier));
		Path path = Paths.get(fichier);

		StringBuilder sb = new StringBuilder();
		String line = br.readLine();

		while (line != null) {
			sb.append(line);
			sb.append(System.lineSeparator());
			line = br.readLine();
		}
		br.close();

		pathFichier = path.toString();
		codePlic= sb.toString();

	}

	/**
	 * Fonction permettant d'�crire le r�sultat de la compilation dans le fichier .asm
	 */
	protected void ecrireFichier(){
		Charset ENCODING = StandardCharsets.UTF_8;
		StringBuilder sb = new StringBuilder(codeCompile);
		int taille = pathFichier.length();
		//pathFichier = pathFichier.substring(0,taille - 5);
		
		/*
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		String date_string = dateFormat.format(date); 
		pathFichier+=date_string +".asm";	
		*/	
		
	//	System.out.println("++++"+pathFichier);
	
		modifierextension();
		if(System.getProperty ( "os.name" ).equals("Linux")){
			pathFichier = "/tmp/"+pathFichier;
		}
	
		Path path = Paths.get(pathFichier);

		try (BufferedWriter writer = Files.newBufferedWriter(path, ENCODING)) {
			writer.write(sb.toString());
			writer.close();

		} catch (IOException e) {
			System.out.println("erreure lors de l'enregistrement du fichier");
			System.exit(1);
		}
	}

	/**
	 * fonction qui change l'extension .plic en .asm
	 */
	private void modifierextension() {

		int taille = pathFichier.length();
		pathFichier = pathFichier.substring(0,taille - 5) + ".asm";
	}




	/** SETTER GETTER **/

	public boolean isErreur(){
		return erreurSemantique;
	}


	public boolean isErreurSemantique() {
		return erreurSemantique;
	}


	public void setErreurSemantique(boolean b){
		this.erreurSemantique = b;
	}

	public String getPathFichier() {
		return pathFichier;
	}

	public void setPathFichier(String pathFichier) {
		this.pathFichier = pathFichier;
	}

	public String getCodePlic() {
		return codePlic;
	}

	public void setCodePlic(String codePlic) {
		this.codePlic = codePlic;
	}
	
	public int  getNombreId(){
		nombreId++;
		return nombreId;
	
	}
}
