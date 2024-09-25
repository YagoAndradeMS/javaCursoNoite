package aula02;

import java.util.Scanner;

public class PositivoNegZero {

	public static void main(String[] args) {
	
		// Instanciando a classe Scanner(usando ela);
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Digite um numero inteiro: ");
		int num = scanner.nextInt();
		
		scanner.close();
		
		if (num == 0) {
			System.out.println("O numero é igual zero");
		} else if (num > 0) {
			System.out.println("O numero é positivo");
		} else {
			System.out.println("O numero é negativo");
		}
		
	}
}
