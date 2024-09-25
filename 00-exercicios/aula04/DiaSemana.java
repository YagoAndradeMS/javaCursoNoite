package aula04;

import java.util.Scanner;

public class DiaSemana {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Escolha um dia da semana");
		System.out.println("1 Segunda-Feira");
		System.out.println("2 Terça-Feira");
		System.out.println("3 Quarta-Feira");
		System.out.println("4 Quinta-Feira");
		System.out.println("5 Sexta-Feira");
		System.out.println("6 Sabado");
		System.out.println("7 Domingo");
		int escolha = scanner.nextInt();
		String dia = "";

		switch (escolha) {
		case 1:
			dia = "Segunda-Feira";
			break;
		case 2:
			dia = "Terça-Feira";
			break;
		case 3:
			dia = "Quarta-Feira";
			break;
		case 4:
			dia = "Quinta-Feira";
			break;
		case 5:
			dia = "Sexta-Feira";
			break;
		case 6:
			dia = "Sabado";
			break;
		case 7:
			dia = "Domingo";
			break;
		default:
			System.out.println("Digite um numero valido!");
			System.exit(0);
		}

		System.out.println("Hoje é " + dia);

		scanner.close();
	}
}
