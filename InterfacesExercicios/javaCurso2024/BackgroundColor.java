package javaCurso2024;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class BackgroundColor extends JFrame {
	private JPanel colorPanel;
	
	public BackgroundColor() {
		//Configuração da janela
		setTitle("Troca de Cor de Fundo");
		setSize(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		//Painel para mudança de cor
		colorPanel = new JPanel();
		add(colorPanel, BorderLayout.CENTER);
		
		// Painel com botões
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 3));
		
		//Botão Vermelho
		JButton redButton = new JButton("Vermelho");
		redButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changeBackgroundColor(Color.RED);
			}
		});
		
		buttonPanel.add(redButton);
		
		// Botão Azul 
		JButton blueButton = new JButton("Azul");
		blueButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changeBackgroundColor(Color.BLUE);
			}
		});
		buttonPanel.add(blueButton);
		
		//Botão Verde
		JButton greenButton = new JButton("Verde");
		greenButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changeBackgroundColor(Color.GREEN);
			}
		});
		buttonPanel.add(greenButton);
		
		// Adiciona o painel de botões á janela
		add(buttonPanel, BorderLayout.SOUTH);
		
		// Tornar a janela visivel
		setVisible(true);
	}
	
	// Método para mudar a cor de fundo
	private void changeBackgroundColor(Color color) {
		colorPanel.setBackground(color);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new BackgroundColor());
	}
}















