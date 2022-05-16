package jogo;

import java.util.Scanner;

import tabuleiro.Tabuleiro9x9;
import tabuleiro.Tabuleiro;
import tabuleiro.Tabuleiro12x12;
import tabuleiro.TabuleiroHexadecimal;

public class Play {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Tabuleiro sudoku;
		Iniciar iniciar;

		int escolha;
		System.out.println("qual Sudoku?");
		escolha = scan.nextInt();

		switch(escolha) {
		case 1:
			sudoku = new Tabuleiro9x9();
			iniciar = new Iniciar(sudoku);
			iniciar.comecar();
			
			break;

		case 2: 
			sudoku = new Tabuleiro12x12();
			iniciar = new Iniciar(sudoku);
			iniciar.comecar();
		
			break;
			
		case 3:
			// não esta funcionando para o hexadecimal, irei resolver apos o checkpoint 3
			//sudoku = new TabuleiroHexadecimal();
			//iniciar = new Iniciar(sudoku);
			//iniciar.comecar();

		}
	}
}

	


