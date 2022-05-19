package jogo;


import java.io.Serializable;
import java.util.Scanner;

import exceptions.AtributoInvalidoException;
import tabuleiro.Tabuleiro;
import tabuleiro.Tabuleiro9x9;
import tabuleiro.Tabuleiro12x12;
import tabuleiro.TabuleiroHexadecimal;

public class Iniciar implements Serializable{
	private  Tabuleiro tabuleiro;
	private  Scanner scan = new Scanner(System.in);
	private  int linha,coluna, ajuda, escolha, dificuldade;
	private  String numero;

	public Iniciar() {
		escolherDificuldade();
		escolherTabuleiro();
		iniciarTabuleiro();
		comecarJogo();
	}

	
	
	
	
	private  void iniciarTabuleiro() {
		tabuleiro.zerarString(tabuleiro.getTabuleiroGabarito(), "0");
		tabuleiro.zerarString(tabuleiro.getErrosEspaço(), " ");
		tabuleiro.randomTabuleiro(tabuleiro.getTabuleiroGabarito(), tabuleiro.getElementosDisponiveis());
		tabuleiro.copiarTabuleiro(tabuleiro.getTabuleiroGabarito(), tabuleiro.getTabuleiroCompletavel());
		tabuleiro.ocultandoTabuleiro(tabuleiro.getTabuleiroCompletavel());
		tabuleiro.zerarString(tabuleiro.getErrosEspaço(), " ");
		
	}
	
	private  void escolherTabuleiro() {
		
		System.out.println("1-Tabuleiro 9x9 \n2-Tabuleiro 12x12\n3-Tabuleiro Hexadecimal");
		
		switch(scanOpcoes()) {
		case 1:
			tabuleiro = new Tabuleiro9x9(dificuldade);
			
			break;

		case 2: 
			tabuleiro = new Tabuleiro12x12(dificuldade*2);
		
			break;
			
		case 3:
			tabuleiro = new TabuleiroHexadecimal(dificuldade*3);
			
			break;
		}
		
		
	}
	
	private void escolherDificuldade() {
		System.out.println("---------SUDOKU---------");
		System.out.println();
		System.out.println("Escolha a Dificuldade:");
		System.out.println("1-FÁCIL");
		System.out.println("2-MÉDIO");
		System.out.println("3-DIFÍCIL");
		switch(scanOpcoes()) {
		case 1:
			dificuldade = 38;
			
			break;

		case 2: 
			dificuldade = 46;
			
		
			break;
			
		case 3:
			dificuldade = 58;
			
			break;
		}
	}
	
	private int scanOpcoes() {
		escolha = scan.nextInt();
		switch(escolha) {
		case 1:
			return escolha;

		case 2: 
			return escolha;
			
			
		case 3:
			return escolha;
			
		default:
			System.out.println("Digite um valor valido");
			scanOpcoes();
		}
		return escolha;
		
		
	}
	
	private  void comecarJogo() {
		
		while(!tabuleiro.ehSudokuResolvido()) {
			tabuleiro.mostrarTabuleiro(tabuleiro.getTabuleiroCompletavel());
			System.out.println("Digite a linha:");
			linha = scan.nextInt()-1;
			System.out.println("Digite a coluna:");
			coluna = scan.nextInt()-1;

			if(tabuleiro.espaçoValido(linha, coluna)) {
				System.out.println("Vai querer ajuda? (0/1) ");
				ajuda = scan.nextInt();
				if(ajuda == 1) {
					tabuleiro.botaoAjuda(linha, coluna, tabuleiro.getElementosDisponiveis());
				}else{
					System.out.println("Digite um numero:");
					numero = scan.next().substring(0, 1);
					try {
						tabuleiro.jogada(linha, coluna, numero, tabuleiro.getTabuleiroCompletavel(), tabuleiro.getElementosDisponiveis());
					}catch(AtributoInvalidoException e) {
						System.out.println(e.getMessage());
					}

				}
			}else System.out.println("espaço invalido");
		}
		tabuleiro.mostrarTabuleiro(tabuleiro.getTabuleiroCompletavel());
		System.out.println("parabens");
	}




}