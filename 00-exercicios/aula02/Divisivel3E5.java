package aula02;

import java.util.Scanner;

public class Divisivel3E5 {

	public static void main(String[] args) {
		// Instanciando a classe Scanner(usando ela);
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite um numero inteiro: ");
		int num = scanner.nextInt();
		
		scanner.close();
		
		if (num % 3 == 0 && num % 5 == 0) {
			System.out.println("O numero é divisivel por 3 e 5");
		} else {
			System.out.println("O numero não é divisivel por 3 e 5");
		}
	}
}
