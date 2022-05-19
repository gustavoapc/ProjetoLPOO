package tabuleiro;

import exceptions.AtributoInvalidoException;

public interface TabuleiroGameLogic {
	
	void jogada(int linha, int coluna, String elemento, String[][] tabuleiro, String[] range)
			throws AtributoInvalidoException;
	
	void apagar(int linha, int coluna, String[][] tabuleiro);
	
	boolean espaçoValido(int linha, int coluna);
	
	boolean ehSudokuResolvido();
	
	boolean existeElemento(String elemento, String[] range);
	
	void executarAjuda(int linha, int coluna, String[] elementosDisponiveis);
	
	void botaoAjuda(int linha, int coluna, String[] ElementosDisponiveis);
	
}
