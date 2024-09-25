package aula02;

import java.util.Scanner;

public class MaiorIdade {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite sua idade: ");
		
		int idade = scanner.nextInt();
		
		scanner.close();
		
		if (idade >= 18) {
			System.out.println("Parabens você é maior de idade");
		} else {
			System.out.println("Espere mais um pouco, você é menor de idade!");
		}
	}
}
