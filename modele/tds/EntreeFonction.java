package compilation.modele.tds;

import java.util.ArrayList;

public class EntreeFonction extends Entree {

	protected ArrayList<String> arguments;

	public EntreeFonction(String idf, ArrayList<String> arguments, int i ) {
		super(idf);
		this.arguments = arguments;
	}

	public EntreeFonction(String idf, ArrayList<SymboleVariable> arguments) {
		super(idf);
		this.arguments = new ArrayList<>();
		
		for(SymboleVariable s : arguments)
			this.arguments.add(s.getType());
	}

	
	public String getIdentificateur() {
		StringBuilder sb = new StringBuilder();
		sb.append(identificateur + "( ");

		if(!arguments.isEmpty())
		sb.append(arguments.get(0));
		for (int i = 1; i < arguments.size(); i++) {
			sb.append("," + arguments.get(i) + " ");
		}

		sb.append(")");

		return sb.toString();
	}

	@Override
	public int hashCode() {
		return super.hashCode() + arguments.hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		EntreeFonction e2 = (EntreeFonction) obj;
		return super.equals(obj) && this.arguments.equals(e2.arguments);
	}

}
