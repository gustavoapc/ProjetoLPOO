package tabuleiro;

public class Tabuleiro9x9 extends TabuleiroAbstrato {

	private final String[] elementosDisponiveis9x9 = {"1","2","3","4","5","6","7","8","9"};
	
	public Tabuleiro9x9() {
		super(3, 3);
		
	}
		
	public String[] getElementosDisponiveis9x9() {
		return elementosDisponiveis9x9;
	}
	
}