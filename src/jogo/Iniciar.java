package jogo;


import java.util.Scanner;

import exceptions.AtributoInvalidoException;
import tabuleiro.Tabuleiro;
import tabuleiro.Tabuleiro9x9;
import tabuleiro.Tabuleiro12x12;
import tabuleiro.TabuleiroHexadecimal;

public class Iniciar {
	private Tabuleiro tabuleiro;

	Scanner scan = new Scanner(System.in);
	int linha,coluna, ajuda;
	String numero;

	public Iniciar(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public void comecar() {

		tabuleiro.zerarString(tabuleiro.getTabuleiroGabarito(), "0");
		tabuleiro.zerarString(tabuleiro.getErrosEspaço(), " ");
		tabuleiro.randomTabuleiro(tabuleiro.getTabuleiroGabarito(), tabuleiro.getElementosDisponiveis());
		tabuleiro.copiarTabuleiro(tabuleiro.getTabuleiroGabarito(), tabuleiro.getTabuleiroCompletavel());
		//tabuleiro.mostrarTabuleiro(tabuleiro.getTabuleiroGabarito());
		tabuleiro.ocultandoTabuleiro(tabuleiro.getTabuleiroCompletavel());
		
		while(!tabuleiro.ehTabuleirosIguais()) {

			tabuleiro.mostrarTabuleiro(tabuleiro.getTabuleiroCompletavel());
			tabuleiro.zerarString(tabuleiro.getErrosEspaço(), " ");
			System.out.println("Digite a linha:");
			linha = scan.nextInt();
			System.out.println("Digite a coluna:");
			coluna = scan.nextInt();

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
		System.out.println("parabens");
	}




}