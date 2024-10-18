package javaCurso2024;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class ImcIac extends JFrame {
    private JTextField weightField;
    private JTextField heightField;
    private JTextField hipWidthField;
    private JTextArea resultArea;
    private JComboBox<String> calculationOptions;

    public ImcIac() {
        // Configuração da janela
        setTitle("Calculadora de IMC e IAC");
        setSize(400, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        // Adicionando opções de cálculo
        add(new JLabel("Escolha o cálculo:"));
        calculationOptions = new JComboBox<>(new String[] {"IMC", "IAC"});
        add(calculationOptions);

        // Campos de entrada
        add(new JLabel("Peso (KG):"));
        weightField = new JTextField();
        add(weightField);

        add(new JLabel("Altura (M):"));
        heightField = new JTextField();
        add(heightField);

        add(new JLabel("Largura do Quadril (cm):"));
        hipWidthField = new JTextField();
        add(hipWidthField);

        JButton calculateButton = new JButton("Calcular");
        add(calculateButton);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        add(new JScrollPane(resultArea));

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateAndDisplayResults();
            }
        });

        setVisible(true);
    }

    private void calculateAndDisplayResults() {
        String selectedCalculation = (String) calculationOptions.getSelectedItem();

        try {
            double weight = Double.parseDouble(weightField.getText());
            double height = Double.parseDouble(heightField.getText());
            double hipWidth = Double.parseDouble(hipWidthField.getText());

            String result = "";

            if ("IMC".equals(selectedCalculation)) {
                double imc = calculateIMC(weight, height);
                result = String.format("IMC: %.2f\n", imc);
            } else if ("IAC".equals(selectedCalculation)) {
                double iac = calculateIAC(hipWidth, height);
                result = String.format("IAC: %.2f\n", iac);
            }
            resultArea.setText(result);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private double calculateIMC(double weight, double height) {
        return weight / (height * height);
    }

    private double calculateIAC(double hipWidth, double height) {
        return (hipWidth - 50) / (height * height); // Correção para a fórmula do IAC
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ImcIac());
    }
}
