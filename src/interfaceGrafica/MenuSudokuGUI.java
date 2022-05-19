package interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuSudokuGUI extends JFrame implements ActionListener{
	
	private JLabel label;
	
	private JButton botaoJogar;
	private JButton botaoRanking;
	private JPanel panelMenu;

	public MenuSudokuGUI() {
		menu();
		botoes();
		
	}
	
	public void menu() {
		
		
		this.setTitle("Menu");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(640, 800);
		this.setLayout(null);
		this.setVisible(true);
		
		
		/*panelMenu = new JPanel();
		panelMenu.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		panelMenu.setLayout(new GridLayout(0,1));*/
		
		
		
	}
	
	public void botoes() {
		botaoJogar = new JButton("Jogar");
		botaoJogar.setBounds(100,100,400,50);
		this.add(botaoJogar);
		botaoJogar.addActionListener(this);
		
		botaoRanking = new JButton("Ranking");
		botaoRanking.setBounds(100,200,400,50);
		this.add(botaoRanking);
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();
		 new JogoSudokuGUI();
		
	}
}