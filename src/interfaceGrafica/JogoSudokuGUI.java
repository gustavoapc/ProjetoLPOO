package interfaceGrafica;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tabuleiro.Tabuleiro;
import tabuleiro.Tabuleiro12x12;
import tabuleiro.Tabuleiro9x9;
import tabuleiro.TabuleiroHexadecimal;

public class JogoSudokuGUI extends JFrame{
	
	private JPanel panelTabuleiro;
	private JButton[][] botoesTabuleiro;
	
	private Tabuleiro tabuleiro;
	
	
	public JogoSudokuGUI() {
		tabuleiro = new Tabuleiro9x9(38);
		IniciarframeTabuleiro();
		//iniciarPanelJogo(tabuleiro);
	}
	
	private void IniciarframeTabuleiro() {
		this.setTitle("Tabuleiro");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		iniciarPanelJogo();
		this.setSize(800, 800);
		
		this.setVisible(true);
		
		
		
	}
	
	private void iniciarPanelJogo() {
			panelTabuleiro = new JPanel();
			panelTabuleiro.setLayout(new GridLayout(tabuleiro.getTamanhoGrid(),tabuleiro.getTamanhoGrid()));
			panelTabuleiro.setBorder(new EmptyBorder(4,4,4,4));
			panelTabuleiro.setBackground(new Color(150,150,150));
			
			criarTabuleiro();
			
			
			botoesTabuleiro = new JButton[tabuleiro.getTamanhoGrid()][tabuleiro.getTamanhoGrid()];
			
			//colocar os valores nos botoes
			for(int i =0; i < tabuleiro.getTamanhoGrid();i++) {
				for(int j =0; j < tabuleiro.getTamanhoGrid();j++) {
					if(tabuleiro.getTabuleiroCompletavel()[i][j].equals("0")) {
						botoesTabuleiro[i][j] = new JButton();
					}else botoesTabuleiro[i][j] = new JButton(tabuleiro.getTabuleiroCompletavel()[i][j]);
					panelTabuleiro.add(botoesTabuleiro[i][j]);
					botoesTabuleiro[i][j].setFocusable(false);
				}
			}
			
			this.add(panelTabuleiro);
			
	}
	
	private void criarTabuleiro() {
		tabuleiro.zerarString(tabuleiro.getTabuleiroGabarito(), "0");
		tabuleiro.zerarString(tabuleiro.getErrosEspaço(), " ");
		tabuleiro.randomTabuleiro(tabuleiro.getTabuleiroGabarito(), tabuleiro.getElementosDisponiveis());
		tabuleiro.copiarTabuleiro(tabuleiro.getTabuleiroGabarito(), tabuleiro.getTabuleiroCompletavel());
		//tabuleiro.mostrarTabuleiro(tabuleiro.getTabuleiroGabarito());
		tabuleiro.ocultandoTabuleiro(tabuleiro.getTabuleiroCompletavel());
	}
	
	private void atualizarBotoes() {
		
		
	}
	
	
}
