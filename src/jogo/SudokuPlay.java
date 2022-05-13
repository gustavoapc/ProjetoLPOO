package jogo;
import tabuleiro.Tabuleiro12x12;
import tabuleiro.Tabuleiro9x9;
import tabuleiro.TabuleiroAbstrato;
import java.util.Scanner;

public class SudokuPlay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		int linha, coluna, ajuda;
		String numero;
		Scanner scan = new Scanner(System.in);
		TabuleiroAbstrato sudoku;
		
		int escolha;
		System.out.println("qual Sudoku?");
		escolha = scan.nextInt();
		
		switch(escolha) {
		
		case 1:
			sudoku = new Tabuleiro9x9();
			sudoku.zerarString(sudoku.getTabuleiroGabarito(), "0");
			sudoku.zerarString(sudoku.getErrosEspaço(), " ");
			sudoku.randomTabuleiro(sudoku.getTabuleiroGabarito(), sudoku.getElementosDisponiveis());
			sudoku.copiarTabuleiro();


			// esse primeiro mostrar tabuleiro é só para ver ele completo
			sudoku.mostrarTabuleiro(sudoku.getTabuleiroGabarito());
			sudoku.ocultandoTabuleiro(sudoku.getTabuleiroCompletavel());



			System.out.println();

		

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
						sudoku.botaoAjuda(linha, coluna, sudoku.getElementosDisponiveis());
					}else{
						System.out.println("Digite um numero:");
						numero = scan.next().substring(0, 1);
						sudoku.jogada(linha, coluna, numero, sudoku.getTabuleiroCompletavel(), sudoku.getElementosDisponiveis());
					}
				}else System.out.println("espaço invalido");


			}
			System.out.println("parabens");
			break;
			
		case 2: 
			sudoku = new Tabuleiro12x12();
			sudoku.zerarString(sudoku.getTabuleiroGabarito(), "0");
			sudoku.zerarString(sudoku.getErrosEspaço(), " ");
			sudoku.randomTabuleiro(sudoku.getTabuleiroGabarito(), sudoku.getElementosDisponiveis());
			sudoku.copiarTabuleiro();


			// esse primeiro mostrar tabuleiro é só para ver ele completo
			sudoku.mostrarTabuleiro(sudoku.getTabuleiroGabarito());
			sudoku.ocultandoTabuleiro(sudoku.getTabuleiroCompletavel());



			System.out.println();

			

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
						sudoku.botaoAjuda(linha, coluna, sudoku.getElementosDisponiveis());
					}else{
						System.out.println("Digite um numero:");
						numero = scan.next().substring(0, 1);
						sudoku.jogada(linha, coluna, numero, sudoku.getTabuleiroCompletavel(), sudoku.getElementosDisponiveis());
					}
				}else System.out.println("espaço invalido");


			}
			System.out.println("parabens");
			break;
			
		}			
		
		}
	}
