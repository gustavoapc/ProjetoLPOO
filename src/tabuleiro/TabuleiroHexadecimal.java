package tabuleiro;

public class TabuleiroHexadecimal extends TabuleiroAbstrato{
	
	private final String[] elementosDisponiveisHexa = {"1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G"};
	
	
	public TabuleiroHexadecimal() {
		super(4,4);
		
	}
	
	public String[] getElementosDisponiveisHexa() {
		return elementosDisponiveisHexa;
	}
}