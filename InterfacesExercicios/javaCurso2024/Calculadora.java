package javaCurso2024;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Calculadora extends JFrame {
	private JTextField number1Field;
	private JTextField number2Field;
	private JLabel resultLabel;
	
	public Calculadora() {
		//Configuração da janela
		setTitle("Calculadora Básica");
		setSize(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(4,2));
		
		//Campos de entrada
		add(new JLabel("Número 1:"));
		number1Field = new JTextField();
		add(number1Field);
		
		add(new JLabel("Número 2:"));
		number2Field = new JTextField();
		add(number2Field);
		
		JButton addButton = new JButton("Somar");
		add(addButton);
		
		resultLabel = new JLabel("Resultado");
		add(resultLabel);
		
		addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateSum();
            }
        });
		
		setVisible(true);
	}
	
	private void calculateSum() {
		try {
			double number1 = Double.parseDouble(number1Field.getText());
			double number2 = Double.parseDouble(number2Field.getText());
			double sum = number1 + number2;
			
			resultLabel.setText("Resultado: " + sum);
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "Por favor, insira números válidos", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new MCalc());
	}
}




















