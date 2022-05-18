package tabuleiro;

import java.util.ArrayList;

public class TabuleiroHexadecimal extends Tabuleiro{
	
	private final String[] elementosDisponiveisHexa = {"1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G"};
	
	private ArrayList<String[][]> colecaoDeTabuleiros = new ArrayList<>();
	
	private static String[][] grid1 = {{"7","6","E","D","2","C","4","8","G","3","9","B","1","F","5","A"},
								{"9","5","3","B","1","A","7","F","2","8","C","6","4","D","E","G"},
								{"4","G","F","1","6","D","9","B","A","E","7","5","2","C","8","3"},
								{"2","A","C","8","3","G","5","E","F","1","D","4","9","7","6","B"},
								{"F","3","D","E","G","5","C","A","4","6","B","9","7","2","1","8"},
								{"6","2","G","C","B","7","F","9","D","A","1","8","7","2","1","8"},
								{"B","9","8","7","4","6","1","D","3","2","5","E","A","G","C","F"},
								{"A","4","1","5","E","2","8","3","C","F","G","7","6","B","9","D"},
								{"D","E","6","4","C","B","2","5","1","7","8","G","3","A","F","9"},
								{"5","F","B","G","D","1","A","6","9","C","4","3","E","8","2","7"},
								{"8","1","A","9","F","E","3","7","6","B","2","D","C","4","G","5"},
								{"3","C","7","2","8","9","G","4","E","5","F","A","D","1","B","6"},
								{"G","D","2","3","A","4","6","1","B","9","E","F","8","5","7","C"},
								{"1","8","9","F","7","3","D","2","5","G","A","C","B","6","4","E"},
								{"E","7","4","6","5","F","B","C","8","D","3","1","G","9","A","2"},
								{"C","B","5","A","9","8","E","G","7","4","6","2","F","3","D","1"},
							};
	
	
	
	public TabuleiroHexadecimal() {
		super(4,4);
		
	}
	
	
	public String[] getElementosDisponiveis() {
		return elementosDisponiveisHexa;
	}
	
	public void gridNaLista() {
		colecaoDeTabuleiros.add(grid1);
	}
	
	
	
	
	public void randomTabuleiro(String[][] tabuleiro, String[] elementosDisponiveis) {
		gridNaLista();
		copiarTabuleiro(colecaoDeTabuleiros.get(random.nextInt(colecaoDeTabuleiros.size())), tabuleiro);
	}
	
	
}