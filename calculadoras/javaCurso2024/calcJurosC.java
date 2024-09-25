package javaCurso2024;

import java.util.Scanner;

public class calcJurosC {

    public static void main(String[] args) {

        // Instanciando o Scanner para receber os inputs do usuário
        Scanner scanner = new Scanner(System.in);

        // Pegando os dados do cálculo
        System.out.println("Digite o capital investido inicial (R$): ");
        double capitalInicial = scanner.nextDouble();

        System.out.println("Digite o valor que será investido mensalmente (R$): ");
        double aporteMensal = scanner.nextDouble();

        System.out.println("Digite a taxa de juros anual (em %): ");
        double taxaJurosAnual = scanner.nextDouble();

        System.out.println("Digite o tempo que o dinheiro será investido (em anos): ");
        int anos = scanner.nextInt();

        // Fechando o scanner
        scanner.close();

        // Convertendo a taxa de juros anual para mensal (dividir por 12)
        double taxaJurosMensal = (taxaJurosAnual / 100) / 12;

        // Convertendo o tempo em anos para meses
        int totalMeses = anos * 12;

        // Calculando o montante do capital inicial (sem aporte)
        double montanteCapitalInicial = capitalInicial * Math.pow(1 + taxaJurosMensal, totalMeses);

        // Calculando o montante dos aportes mensais (se houver)
        double montanteAportes = aporteMensal * (Math.pow(1 + taxaJurosMensal, totalMeses) - 1) / taxaJurosMensal;

        // Somando os montantes
        double montanteFinal = montanteCapitalInicial + montanteAportes;

        // Exibindo os resultados
        System.out.printf("O montante final após %d meses é: R$ %.2f%n", totalMeses, montanteFinal);
        System.out.printf("O lucro obtido foi de: R$ %.2f%n", (montanteFinal - (capitalInicial + aporteMensal * totalMeses)));
    }
}
