package javaCurso2024;

import java.util.Scanner;

public class CalcJurosSimples {

	public static void main(String[] args) {
		// Instanciando o Scanner(usando ele)
		Scanner scanner = new Scanner(System.in);

		// Entrada de valores
		System.out.println("Capital a investir(R$): ");
		double capital = scanner.nextDouble();

		System.out.println("Qual é a taxa de juros(%): ");
		double taxa = scanner.nextDouble();

		System.out.println("Tempo em anos: ");
		int tempo = scanner.nextInt();

		// Calculo dos juros simples:
		double juros = (capital * taxa * tempo) / 100;
		System.out.println("O valor dos juros é: " + juros);

		// Resultado final:
		System.out.println("O seu capital total é de: " + (capital + juros));

		scanner.close();
	}

}
