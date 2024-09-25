package aula02;

import java.util.Scanner;

public class ParImpar {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite um numero inteiro");
		int num = scanner.nextInt();
		
		scanner.close(); 
		
		if (num % 2 == 0) {
			System.out.println("O numero " + num + " é par");
		} else {
			System.out.println("O numero " + num + " é impar");
		}
	}
}
