package tabuleiro;

import java.util.ArrayList;

public class TabuleiroHexadecimal extends Tabuleiro{
	
	private final String[] elementosDisponiveisHexa = {"1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G"};
	
	private ArrayList<String[][]> colecaoDeTabuleiros = new ArrayList<>();
	
	private String[][] grid1 = new String[16][16];
	
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