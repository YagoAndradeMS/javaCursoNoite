package javaCurso2024;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Calc extends JFrame implements ActionListener {

	private JTextField display;
	private StringBuilder currentInput;
	private double num1 = 0, num2 = 0;
	private String operator = "";
	String buttonPressed = "";

	public Calc() {
		// Configurações da Janela
		setTitle("Calculadora");
		setSize(300, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		// Campo de texto para exibir o resultado
		display = new JTextField();
		display.setFont(new Font("Arial", Font.BOLD, 24));
		display.setEditable(false);
		add(display, BorderLayout.NORTH);

		// Painel para os botões
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(5, 3, 5, 5));

		// Criação dos botões
		String[] buttons = { "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+", "C" };

		for (String text : buttons) {
			JButton button = new JButton(text);
			button.setFont(new Font("Arial", Font.BOLD, 18));
			button.addActionListener(this);
			buttonPanel.add(button);
		}

		add(buttonPanel, BorderLayout.CENTER);

		// Inicializar o input atual
		currentInput = new StringBuilder();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		// Lógica para limpar o display
		if (command.equals("C")) {
			resetCalculator();
			return;
		}

		// Lógica para os operadores
		if ("+-*/".contains(command)) {
			if (currentInput.length() > 0) {
				try {
					num1 = Double.parseDouble(currentInput.toString());
						operator = command;
						
						buttonPressed += " " + operator + " ";
					
					currentInput.setLength(0); // Limpa para o próximo número

				} catch (NumberFormatException ex) {
					display.setText("Erro: Entrada Inválida");
					currentInput.setLength(0);
				}
			}
			return;
		} else if(command != "=") {
			 buttonPressed += command;  // Adicionar ao display os números também	
		}
		


		// Lógica para o "=" (resultado)
		if (command.equals("=")) {
			if (currentInput.length() > 0) {
				try {
					num2 = Double.parseDouble(currentInput.toString());
					double result = calcular(num1, num2, operator);
					buttonPressed += " = " + result;
					display.setText(String.valueOf(result));
					buttonPressed = "";
				} catch (ArithmeticException ex) {
					display.setText("Erro: Divisão por 0");
				} catch (NumberFormatException ex) {
					display.setText("Erro: Entrada Inválida");
				}
				currentInput.setLength(0); // Limpa para nova operação
			}
			return;
		}

		// Adiciona dígitos ao input atual
		currentInput.append(command); // Concatenar os dígitos corretamente
		display.setText(buttonPressed); // Atualiza a exibição após cada número
	}

	// Método para realizar a operação matemática
	private double calcular(double num1, double num2, String operator) throws ArithmeticException {
		switch (operator) {
		case "+":
			return num1 + num2;
		case "-":
			return num1 - num2;
		case "*":
			return num1 * num2;
		case "/":
			if (num2 == 0) {
				throw new ArithmeticException("Divisão por zero");
			}
			return num1 / num2;
		default:
			return 0;
		}
	}

	// Método para resetar a calculadora
	private void resetCalculator() {
		currentInput.setLength(0);
		display.setText("");
		buttonPressed = "";
		num1 = num2 = 0;
		operator = "";
	}

	// Método principal para executar a calculadora
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			Calc calc = new Calc();
			calc.setVisible(true);
		});
	}
}