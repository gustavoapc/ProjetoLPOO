package jogo;
import tabuleiro.Tabuleiro12x12;
import java.util.Scanner;

public class Iniciar12x12 {
	
	public void SudokuPlay(){
		Tabuleiro12x12 sudoku = new Tabuleiro12x12();
		Scanner scan = new Scanner(System.in);
		
		sudoku.zerarString(sudoku.getTabuleiroGabarito(), "0");
		sudoku.zerarString(sudoku.getErrosEspaço(), " ");
		
		sudoku.randomTabuleiro(sudoku.getTabuleiroGabarito(), sudoku.getElementosDisponiveis12x12());
		sudoku.copiarTabuleiro();
		
		
		// esse primeiro mostrar tabuleiro é só para ver ele completo
		sudoku.mostrarTabuleiro(sudoku.getTabuleiroGabarito());
		sudoku.ocultandoTabuleiro(sudoku.getTabuleiroCompletavel());
		
		
		
		System.out.println();
		
		int linha, coluna, ajuda;
	
		String numero;
		
		while(!sudoku.ehTabuleirosIguais()) {
			
			sudoku.mostrarTabuleiro(sudoku.getTabuleiroCompletavel());
			sudoku.zerarString(sudoku.getErrosEspaço(), " ");
			
			System.out.println("Digite a linha:");
			linha = scan.nextInt();
			System.out.println("Digite a coluna:");
			coluna = scan.nextInt();
			if(sudoku.espaçoValido(linha, coluna)) {
				System.out.println("Vai querer ajuda? (0/1) ");
				ajuda = scan.nextInt();
				if(ajuda == 1) {
					sudoku.botaoAjuda(linha, coluna, sudoku.getElementosDisponiveis12x12());
				}else{
					System.out.println("Digite um numero:");
					numero = scan.next().substring(0, 1).toUpperCase();
					sudoku.jogada(linha, coluna, numero, sudoku.getTabuleiroCompletavel());
				}
			}else System.out.println("espaço invalido");
			
				
		}
		System.out.println("parabens");

	}
}