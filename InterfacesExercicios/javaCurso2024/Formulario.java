package javaCurso2024;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formulario {
	public static void main(String[] args) {
		//Criação da janela principal
		JFrame frame = new JFrame("Formulário Simples");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 200);
		frame.setLayout(new FlowLayout());
		
		//Campos de texto para nome e idade
		JTextField nomeField = new JTextField(15);
		nomeField.setToolTipText("Digite seu nome");
		
		JTextField idadeField = new JTextField(15);
		idadeField.setToolTipText("Digite sua idade");
		
		// Botão para enviar as informações
		JButton button = new JButton("Enviar");
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String nome = nomeField.getText();
				String idade = idadeField.getText();
				
				//Exibir um JOptionPane com as informações inseridas
				JOptionPane.showMessageDialog(frame, "Nome: " + nome + "\nIdade: " + idade);
			}
		});
		
		frame.add(new JLabel("Nome:"));
		frame.add(nomeField);
		frame.add(new JLabel("Idade:"));
		frame.add(idadeField);
		frame.add(button);
		
		//Tornar a janela visivel
		frame.setVisible(true);
	}
}
