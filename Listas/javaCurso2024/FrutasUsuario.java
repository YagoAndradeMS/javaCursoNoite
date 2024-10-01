package javaCurso2024;

import java.util.Scanner;
import java.util.ArrayList;

// Crie um array dinâmico que pergunte ao usuário os nomes das frutas e quando o usuário não quiser digitar mais nenhuma fruta, mostre todas elas na tela

public class FrutasUsuario {
	public static void main(String[] args) {

		// Instanciando o Scanner
		Scanner sc = new Scanner(System.in);
		// Cria uma lista de array dinamica
		ArrayList<String> frutas = new ArrayList<>();

		Boolean sim = true;
		while (sim) {
			System.out.println("Digite o nome de uma fruta: ");
			frutas.add(sc.nextLine());

			Boolean respostaValida = false;

			while (!respostaValida) {

				System.out.println("Você deseja adicionar mais alguma fruta? S/N ");
				String res = sc.nextLine();

				if (res.equalsIgnoreCase("N")) {
					sim = false;
					respostaValida = true;

				} else if (res.equalsIgnoreCase("S")) {
					respostaValida = true;

				} else {

					System.out.println("Digite uma resposta valida");
					System.out.println("Você deseja adicionar mais alguma fruta? S/N ");
					res = sc.nextLine();
				}
			}
		}
		
		System.out.println("\nSua lista de frutas ficou com as seguintes frutas: ");
		for (String fruta : frutas) {
			System.out.println(fruta);
		}
		sc.close();
	}
}