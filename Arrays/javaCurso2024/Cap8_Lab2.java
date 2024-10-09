package javaCurso2024;

import java.util.Scanner;

public class Cap8_Lab2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] ages = new int[6];
		int soma = 0;

		for (int i = 0; i < ages.length; i++) {
			do {
				System.out.println("Digite as idades");
				ages[i] = sc.nextInt();
				
				if(ages[i] <=0) {
					System.out.println("Digite um numero valido \nO numero " + ages[i] + " não é valido\n");
				}
			} while (ages[i] <= 0);
		}

		if(ages.length > 0) {
			for (int i = 0; i < ages.length; i++) {
				soma += ages[i];
				
			}
		}
		
		double media = (double) soma / ages.length;
		
		System.out.println("A média das idades é: " + media);
		sc.close();
	}
}
