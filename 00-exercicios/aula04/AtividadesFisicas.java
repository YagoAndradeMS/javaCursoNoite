package aula04;

import java.util.Scanner;

public class AtividadesFisicas {

	public static void main(String[] args) {

		// Instanciando a classe scanner (usando ela)
		Scanner scanner = new Scanner(System.in);

		// Exibe o menu de opções
		System.out.println("Escolha uma atividade Física: ");
		System.out.println("1. Corrida");
		System.out.println("2. Caminhada");
		System.out.println("3. Ciclismo");
		System.out.println("4. Natação");
		System.out.println("5. Alpinismo");
		System.out.println("6. Paraquedismo");

		// Recebe a escolha do usuário
		int opcao = scanner.nextInt();
		int calorias = 0;
		String atividade = "";

		// Estrutura switch para selecionar atividade e calcular as calorias:
		switch (opcao) {
		case 1:
			atividade = "Corrida";
			calorias = 300;
			break;
		case 2:
			atividade = "Caminhada";
			calorias = 150;
			break;
		case 3:
			atividade = "Ciclismo";
			calorias = 250;
			break;
		case 4:
			atividade = "Natação";
			calorias = 280;
			break;
		case 5:
			atividade = "Alpinismo";
			calorias = 400;
			break;
		case 6:
			atividade = "Paraquedismo";
			calorias = 100;
			break;
		default:
			System.out.println("Opção invalida! Tente novamente.");
			System.exit(0);
		}
		
		//Exibe o resultado da escolha
		System.out.println("Você escolheu a atividade: " + atividade);
		System.out.println("Calorias queimadas em 30 min: " + calorias + " Kcal");
		
		scanner.close();
	}
}
