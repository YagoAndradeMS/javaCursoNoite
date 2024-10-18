package javaCurso2024;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ContadorCliques extends JFrame {
	private int contador = 0; // Contador de cliques
	private JLabel label; // Rótulo para exibir o contador
	
	public ContadorCliques() {
		// Configurando a Janela
		setTitle("Contador de Cliques");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		// inicializa o JLabel
		label = new JLabel("Contador: " + contador);
		add(label);
		
		// cria o botão
		JButton botao = new JButton("Clique aqui");
		botao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				contador++; //Incrementa o contador
				label.setText("Contador: " + contador);
			}
		});
		
		add(botao); // Adiciona o botão á janela
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ContadorCliques();
	}
}
