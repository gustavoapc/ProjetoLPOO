package jogo;
import tabuleiro.Tabuleiro;
import java.util.Scanner;

public class Iniciar {
	
	public void SodokuPlay(){
		Tabuleiro sudoku = new Tabuleiro(9,9);
		Scanner scan = new Scanner(System.in);
		
		sudoku.zerarString(sudoku.getTabuleiroGabarito(), "0");
		sudoku.zerarString(sudoku.getErrosEspa�o(), " ");
		
		sudoku.randomTabuleiro(sudoku.getTabuleiroGabarito());
		sudoku.copiarTabuleiro();
		
		
		// esse primeiro mostrar tabuleiro � s� para ver ele completo
		sudoku.mostrarTabuleiro(sudoku.getTabuleiroGabarito());
		sudoku.ocultandoTabuleiro(sudoku.getTabuleiroCompletavel());
		
		
		
		System.out.println();
		
		int linha, coluna, ajuda;
	
		String numero;
		
		while(!sudoku.ehTabuleirosIguais()) {
			
			sudoku.mostrarTabuleiro(sudoku.getTabuleiroCompletavel());
			sudoku.zerarString(sudoku.getErrosEspa�o(), " ");
			
			System.out.println("Digite a linha:");
			linha = scan.nextInt();
			System.out.println("Digite a coluna:");
			coluna = scan.nextInt();
			if(sudoku.espa�oValido(linha, coluna)) {
				System.out.println("Vai querer ajuda? (0/1) ");
				ajuda = scan.nextInt();
				if(ajuda == 1) {
					sudoku.botaoAjuda(linha, coluna);
				}else{
					System.out.println("Digite um numero:");
					numero = scan.next().substring(0, 1);
					sudoku.jogada(linha, coluna, numero, sudoku.getTabuleiroCompletavel());
				}
			}else System.out.println("espa�o invalido");
			
				
		}
		System.out.println("parabens");

	}
}
	

