package aula05;

import java.util.Scanner;

public class VerificaPar {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite um numero para verificar se ele é primo: ");
		int num = sc.nextInt();
		int divisor = 0;

		for (int i = num; i > 0; i--) {
			if (num % i == 0) {
				divisor++;
			}
		}

		if (divisor > 2) {
			System.out.println("O numero digitado não é primo");
		} else {
			System.out.println("O numero digitado é primo");
		}

		sc.close();
	}
}
