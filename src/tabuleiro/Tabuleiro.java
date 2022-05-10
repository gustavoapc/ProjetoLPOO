package tabuleiro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Tabuleiro {
	Random random = new Random(); // função random
	 
	private  final int tamanhoGrid;
	private final int quantidadeElemDisponiveis;
	private String[][] tabuleiroGabarito;
	private String[][] tabuleiroCompletavel;
	private String[][] errosEspaço;
	//transformar essa classe abstrata
	
	


	// diferente em cada tipo de sudoku
	private final String[] elementosDisponiveis;
	
	private ArrayList<String> rangeElementos = new ArrayList<>(); 
	
	public Tabuleiro(int tamanhoGrid, int quantidade) {
		this.tamanhoGrid = tamanhoGrid;
		this.quantidadeElemDisponiveis = quantidade;
		this.tabuleiroGabarito = new String[tamanhoGrid][tamanhoGrid];
		this.tabuleiroCompletavel = new String[tamanhoGrid][tamanhoGrid];
		this.errosEspaço = new String[tamanhoGrid][tamanhoGrid];
		this.elementosDisponiveis = new String[]{"1","2","3","4","5","6","7","8","9"};
	}	
	
	public int getQuantidadeElemDisponiveis() {
		return quantidadeElemDisponiveis;
	}
	
	public String[][] getTabuleiroGabarito() {
		return tabuleiroGabarito;
	}

	

	public void setTabuleiroGabarito(String[][] tabuleiroGabarito) {
		this.tabuleiroGabarito = tabuleiroGabarito;
	}



	public String[][] getTabuleiroCompletavel() {
		return tabuleiroCompletavel;
	}



	public void setTabuleiroCompletavel(String[][] tabuleiroCompletavel) {
		this.tabuleiroCompletavel = tabuleiroCompletavel;
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

	
	public String[] getElementosDisponiveis() {
		return elementosDisponiveis;
	}

	// numeros possiveis para colocar no tabuleiro random
	public void criarRange() {
		//Integer para se transformar numa String
		for(Integer i=0; i<quantidadeElemDisponiveis;i++) {
			rangeElementos.add(elementosDisponiveis[i]);
			
		}
	}
	
	public void zerarString(String[][] tabuleiro, String string) {
		for(int i=0; i<tamanhoGrid; i++) {
			for(int j=0; j<tamanhoGrid; j++) {
				tabuleiro[i][j] = string;
			}
		}
	}
	
	
	public void randomTabuleiro(String[][] tabuleiro) {
		int numeroRandom;
		criarRange();
		int tentativas=200;
		
			for(int linha=0; linha<tamanhoGrid;linha++) {
			criarRange();
			for(int coluna=0; coluna<tamanhoGrid; coluna++) {
				numeroRandom = random.nextInt(rangeElementos.size());
				String nString = rangeElementos.get(numeroRandom);
				
				tabuleiro[linha][coluna]= rangeElementos.get(numeroRandom);
				
				if(numeroRepeteTudo(linha, coluna, rangeElementos.get(numeroRandom), tabuleiro)) {
					tabuleiro[linha][coluna] = "0";
					coluna--;
					if(tentativas>0) {
						tentativas--;	
					}else {
						// se ele entrar em loop infinito, o loop vai começar do zero
						linha=-1;
						coluna=-1;
						rangeElementos.removeAll(rangeElementos);
						criarRange();
						zerarString(tabuleiroGabarito, "0");
						tentativas=200;
						break;
						
					}
				}else {
					rangeElementos.remove(nString);
				}		
			}
			
		}
			
		
		
	}
	
	// Descobri que equals() da erro se o for null
	
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
		
		int linhaSub = linha-(linha%(tamanhoGrid/3));
		int colunaSub = coluna-(coluna%(tamanhoGrid/3));
		
		
		for(int i=linhaSub; i<linhaSub+3;i++) {
			for(int j=colunaSub; j<colunaSub+3; j++) {
				
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
		int zeros=4;
	
		//vai de submatriz em submatriz
		for(int linha=0; linha<tamanhoGrid;linha+=3) {
			for(int coluna=0; coluna<tamanhoGrid; coluna+=3) {
				while(zeros>0) {
					for(int i= linha; i<linha+3;i++) {
						for(int j=coluna; j<coluna+3; j++) {
							if(random.nextInt(43)>32 && zeros>0) {
								tabuleiro[i][j]="0";
								zeros--;
							}
							
						}
					
					}	
				}
				
			zeros=4;
			}
			
		}
		
	}
	
	public void copiarTabuleiro() {
		for(int i=0;i<tamanhoGrid;i++) {
			for(int j=0;j<tamanhoGrid;j++) {
				tabuleiroCompletavel[i][j] = tabuleiroGabarito[i][j];
			}
		}
	}
	
	public void preencher(int linha, int coluna, String numero, String[][] tabuleiro) {
		tabuleiro[linha][coluna]=numero;
	}
	
	public boolean espaçoValido(int linha, int coluna) {
		if(tabuleiroCompletavel[linha][coluna]=="0" 
				|| tabuleiroCompletavel[linha][coluna] != tabuleiroGabarito[linha][coluna] ) {
			return true;
		}
		return false;
	}
	
	// criar um metodo que identifique se o espaço valido eh igual ao do gabarito
	public boolean ehIgualGabarito(int linha, int coluna) {
		if(tabuleiroGabarito[linha][coluna] == tabuleiroCompletavel[linha][coluna]) {
			return true;
		}
		return false;
	}
	
	public boolean ehTabuleirosIguais() {
		for(int linha=0;linha<tamanhoGrid; linha++) {
			for(int coluna=0;coluna<tamanhoGrid; coluna++) {
				if(tabuleiroGabarito[linha][coluna] != tabuleiroCompletavel[linha][coluna]) {
					return false;
				}
				
			}
			
		}
		return true;
	}
	
	
	public void jogada(int linha, int coluna, String numero, String[][] tabuleiro) {
		
			preencher(linha, coluna, numero, tabuleiro);
				if(numeroRepeteTudo(linha, coluna, numero, tabuleiro)) {
					preencher(linha, coluna, "0", tabuleiro);
					verErros(linha, coluna, numero);
					//usar throws
					System.out.println("numero repete");
				}
		
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
		int linhaSub = linha-(linha%(tamanhoGrid/3));
		int colunaSub = coluna-(coluna%(tamanhoGrid/3));
		
		
		for(int i=linhaSub; i<linhaSub+3;i++) {
			for(int j=colunaSub; j<colunaSub+3; j++) {
				
				
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
	
	
	
	public void executarAjuda(int linha, int coluna) {
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
		
	
	public void botaoAjuda(int linha, int coluna) {
			executarAjuda(linha, coluna);
		}
}
	