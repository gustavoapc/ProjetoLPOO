package tabuleiro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import exceptions.AtributoInvalidoException;


public abstract class Tabuleiro implements TabuleiroGameLogic {
	Random random = new Random(); // função random

	private final int tamanhoGrid;
	private final int tamanhoLinhaSub;
	private final int tamanhoColunaSub;
	private final int quantidadeElemDisponiveis;
	
	private String[][] tabuleiroGabarito;
	private String[][] tabuleiroCompletavel;
	private String[][] errosEspaço;

	private ArrayList<String> rangeElementos = new ArrayList<>(); 

	public Tabuleiro(int linha, int coluna) {
		this.tamanhoLinhaSub = linha;
		this.tamanhoColunaSub = coluna;
		this.tamanhoGrid = linha*coluna;
		this.quantidadeElemDisponiveis = linha*coluna;
		this.tabuleiroGabarito = new String[tamanhoGrid][tamanhoGrid];
		this.tabuleiroCompletavel = new String[tamanhoGrid][tamanhoGrid];
		this.errosEspaço = new String[tamanhoGrid][tamanhoGrid];

	}	

	public String[][] getTabuleiroGabarito() {
		return tabuleiroGabarito;
	}

	public String[][] getTabuleiroCompletavel() {
		return tabuleiroCompletavel;
	}


	public String[][] getErrosEspaço() {
		return errosEspaço;
	}



	public void setErrosEspaço(String[][] errosEspaço) {
		this.errosEspaço = errosEspaço;
	}



	public int getTamanhoGrid() {
		return tamanhoGrid;
	}



	public int getQuantidadeElemDisponiveis() {
		return quantidadeElemDisponiveis;
	}


	public ArrayList<String> getRangeElementos() {
		return rangeElementos;
	}

	public abstract String[] getElementosDisponiveis();


	// numeros possiveis para colocar no tabuleiro random
	public void criarRange(String[] elementosDisponiveis) {
		for(int i=0; i<quantidadeElemDisponiveis;i++) {
			rangeElementos.add(elementosDisponiveis[i]);

		}
	}

	public void zerarString(String[][] tabuleiro, String string){
		for(int i=0; i<tamanhoGrid; i++) {
			for(int j=0; j<tamanhoGrid; j++) {
				tabuleiro[i][j] = string;
			}
		}


	}


	public void randomTabuleiro(String[][] tabuleiro, String[] elementosDisponiveis) {
		int numeroRandom;

		for(int linha=0; linha<tamanhoGrid;linha++) {
			criarRange(elementosDisponiveis);
			int tentativas = 0;
			for(int coluna=0; coluna<tamanhoGrid; coluna++) {
				numeroRandom = random.nextInt(rangeElementos.size());
				String nString = rangeElementos.get(numeroRandom);

				tabuleiro[linha][coluna]= rangeElementos.get(numeroRandom);

				if(numeroRepeteTudo(linha, coluna, rangeElementos.get(numeroRandom), tabuleiro)) {
					tabuleiro[linha][coluna] = "0";
					coluna--;
					if(tentativas<200) {
						tentativas++;	
					}else {
						// se ele entrar em loop infinito, o loop vai começar do zero
						linha=-1;
						coluna=-1;
						rangeElementos.removeAll(rangeElementos);
						criarRange(elementosDisponiveis);
						zerarString(tabuleiroGabarito, "0");

						
						break;

					}
				}else {
					rangeElementos.remove(nString);
					
				}		

			}
			
		}

	}

	public void mostrarTabuleiro(String[][] tabuleiro) {
		for(int i=0;i<tamanhoGrid;i++) {
			for(int j=0;j<tamanhoGrid;j++) {
				if(tabuleiro[i][j].equals("0")) {
					System.out.print(" "+ errosEspaço[i][j]);
				}else System.out.print(tabuleiro[i][j]+ errosEspaço[i][j]);	
			}
			System.out.println();
		}

	}




	public boolean numeroRepeteLinha(int linha, int coluna, String numero, String[][] tabuleiro) {

		for(int i=0; i<tamanhoGrid; i++) {
			if(i!=coluna) {

				if(tabuleiro[linha][i].equals(numero)) {
					//System.out.println("Linha: repetiu em "+linha+"x"+i);
					return true;

				}
			}

		}
		return false;
	}

	public boolean numeroRepeteColuna(int linha, int coluna, String numero, String[][] tabuleiro) {

		for(int i=0; i<tamanhoGrid; i++) {
			if(i!=linha) {
				if(tabuleiro[i][coluna].equals(numero)) {
					//System.out.println("Coluna: repetiu em "+i+"x"+coluna);
					return true;

				}
			}
		}
		return false;
	}


	public boolean numeroRepeteSub(int linha, int coluna, String numero, String[][] tabuleiro) {

		int linhaSub = linha-(linha%(tamanhoLinhaSub));
		int colunaSub = coluna-(coluna%(tamanhoColunaSub));


		for(int i=linhaSub; i<linhaSub+tamanhoLinhaSub;i++) {
			for(int j=colunaSub; j<colunaSub+tamanhoColunaSub; j++) {

				// só nao vai checar no local onde ta o n
				if((i!=linha) || (j!=coluna)) {
					if(tabuleiro[i][j].equals(numero)) {
						//System.out.println("Sub: repetiu em "+i+"x"+j);
						return true;

					}
				}

			}
		}
		return false;
	}

	//todos estao funcionais
	public boolean numeroRepeteTudo(int linha, int coluna, String numero, String[][] tabuleiro) {
		return numeroRepeteLinha(linha, coluna, numero, tabuleiro) || numeroRepeteColuna(linha, coluna, numero, tabuleiro) || numeroRepeteSub(linha, coluna, numero, tabuleiro);
	}

	public void ocultandoTabuleiro(String[][] tabuleiro){
		//cada "caixa" ira ter 4 zeros
		int zeros=38;
		int linha, coluna;
		//vai de submatriz em submatriz
		while(zeros>0) {
			linha= random.nextInt(tamanhoGrid);
			coluna= random.nextInt(tamanhoGrid);
			if(tabuleiro[linha][coluna] != "0") {
				tabuleiro[linha][coluna] = "0";
				zeros--;
			}

		}

	}

	public void copiarTabuleiro(String[][] tabuleiro1, String[][] tabuleiro2) {
		for(int i=0;i<tamanhoGrid;i++) {
			for(int j=0;j<tamanhoGrid;j++) {
				tabuleiro2[i][j] = tabuleiro1[i][j];
			}
		}
	}

	public void preencher(int linha, int coluna, String numero, String[][] tabuleiro) 
			throws AtributoInvalidoException {
		if(numero == null || numero == "") {
			throw new AtributoInvalidoException("Erro pois o elemento não deve ser null ");
		}else tabuleiro[linha][coluna]=numero;
	}

	public void apagar(int linha, int coluna, String[][] tabuleiro) {
		tabuleiro[linha][coluna]="0";
	}

	public boolean espaçoValido(int linha, int coluna) {
		if(tabuleiroCompletavel[linha][coluna]=="0" 
				|| tabuleiroCompletavel[linha][coluna] != tabuleiroGabarito[linha][coluna] ) {
			return true;
		}
		return false;
	}


	// metodo para saber se o jogo ainda esta ocorrendo
	public boolean ehTabuleirosIguais() {
		for(int linha=0;linha<tamanhoGrid; linha++) {
			for(int coluna=0;coluna<tamanhoGrid; coluna++) {
				if(!tabuleiroGabarito[linha][coluna].equals(tabuleiroCompletavel[linha][coluna])) {
					return false;
				}

			}

		}
		return true;
	}


	public void jogada(int linha, int coluna, String elemento, String[][] tabuleiro, String[] range)
			throws AtributoInvalidoException {

		if(elemento == "") {
			apagar(linha, coluna, tabuleiro);
			//colocar metodo que procure a string no array
		}else{
			if(existeElemento(elemento, range)) {
				preencher(linha, coluna, elemento, tabuleiro);
				if(numeroRepeteTudo(linha, coluna, elemento, tabuleiro)) {
					preencher(linha, coluna, "0", tabuleiro);
					verErros(linha, coluna, elemento);
					//usar throws
					System.out.println("numero repete");
				}
				
			}else throw new AtributoInvalidoException("Elemento não existente");

		}


	}

	public boolean existeElemento(String elemento, String[] range){

		for(int i=0; i<range.length; i++) {
			if(elemento.equals(range[i])) {
				return true;
			}
		}
		return false;

	}





	// Esses "*" para visualizar que o numero repete
	public void verErrosLinha(int linha, int coluna, String numero) {

		for(int i=0; i<tamanhoGrid; i++) {
			if(i!=coluna) {

				if(tabuleiroCompletavel[linha][i].equals(numero)) {
					errosEspaço[linha][i] = "*" ;

				}
			}

		}

	}

	public void verErrosColuna(int linha, int coluna, String numero) {
		for(int i=0; i<tamanhoGrid; i++) {
			if(i!=linha) {
				if(tabuleiroCompletavel[i][coluna].equals(numero)) {
					errosEspaço[i][coluna] = "*" ;


				}
			}
		}

	}

	public void verErrosSub(int linha, int coluna, String numero) {
		int linhaSub = linha-(linha%(tamanhoLinhaSub));
		int colunaSub = coluna-(coluna%(tamanhoColunaSub));
		for(int i=linhaSub; i<linhaSub+tamanhoLinhaSub;i++) {
			for(int j=colunaSub; j<colunaSub+tamanhoColunaSub; j++) {

				if((i!=linha) || (j!=coluna)) {
					if(tabuleiroCompletavel[i][j].equals(numero)) {
						errosEspaço[i][j] = "*" ;

					}
				}

			}
		}



	}


	public void verErros(int linha, int coluna, String numero) {
		verErrosLinha(linha, coluna, numero);
		verErrosColuna(linha, coluna, numero);
		verErrosSub(linha, coluna, numero);
	}



	public void executarAjuda(int linha, int coluna, String[] elementosDisponiveis) {
		boolean r=false;
		System.out.print("Ajuda: ");
		for(int i =0; i<elementosDisponiveis.length;i++) {
			if(!numeroRepeteTudo(linha, coluna, elementosDisponiveis[i], tabuleiroCompletavel)) {
				System.out.print(elementosDisponiveis[i]+" ");
				r=true;
			}
		}
		if(!r) {
			System.out.print("nenhum elemento disponivel");
		}
		System.out.println();
	}


	public void botaoAjuda(int linha, int coluna, String[] ElementosDisponiveis) {
		executarAjuda(linha, coluna, ElementosDisponiveis);
	}
}


