package javaCurso2024;

import java.util.Scanner;

public class CalcJurosCompostos {

    public static void main(String[] args) {

        // Instanciando o Scanner (usando ele)
        Scanner scanner = new Scanner(System.in);

        // Pegando os dados do cálculo
        System.out.println("Digite o capital investido inicial (R$): ");
        double capital = scanner.nextDouble();

        System.out.println("Digite o valor que será investido mensalmente (R$): ");
        double capitalMensal = scanner.nextDouble();

        System.out.println("Digite a taxa de juros anual (em %): ");
        double taxa = scanner.nextDouble();

        System.out.println("Digite o tempo que o dinheiro será investido (em anos): ");
        int tempo = scanner.nextInt();

        // Fechando o scanner
        scanner.close();

        // Convertendo a taxa anual para mensal e decimal
        double taxaMensal = (taxa / 100) / 12;

        // Calculando o número total de meses
        int totalMeses = tempo * 12;

        // Inicializando o montante apenas com o capital inicial
        double montante = capital;

        // Calculando juros compostos mês a mês usando o laço for
        for (int i = 1; i <= totalMeses; i++) {
            // Aplicando juros compostos ao montante existente
            montante += montante * taxaMensal;

            // Adicionando o investimento mensal após os juros
            montante += capitalMensal;

            // Exibindo o valor acumulado a cada mês (opcional)
            System.out.printf("Mês %d: Montante acumulado = R$ %.2f%n", i, montante);
        }

        // Exibindo o resultado final após o período de investimento
        System.out.printf("O montante final após %d meses é: R$ %.2f%n", totalMeses, montante);
    }
}
