package javaCurso2024;

import java.util.Scanner;

//*Comparação de Três Números*
//- Faça um programa que peça três números inteiros e exiba o maior e o menor deles.

public class CompararNum {

	public static void main(String[] args) {

		// Instanciando o Scanner
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite um numero: ");
		int num = sc.nextInt();

		System.out.println("Digite outro numero: ");
		int num1 = sc.nextInt();

		System.out.println("Digite mais um numero: ");
		int num2 = sc.nextInt();

		if (num > num1 && num1 < num2) {
			System.out.println("O maior numero é o " + num + " e o menor é o " + num1);

		} else if (num > num2 && num2 < num1) {
			System.out.println("O maior numero é o " + num + " e o menor é o " + num2);
			
		} else if (num1 > num && num < num2) {
			System.out.println("O maior numero é o " + num1 + " e o menor é o " + num);
			
		} else if (num1 > num2 && num2 < num) {
			System.out.println("O maior numero é o " + num1 + " e o menor é o " + num2);
			
		} else if (num2 > num && num < num1) {
			System.out.println("O maior numero é o " + num2 + " e o menor é o " + num);
			
		} else if (num2 > num1 && num1 < num) {
			System.out.println("O maior numero é o " + num2 + " e o menor é o " + num1);
			
		} else {
			System.out.println("Por favor não digite numeros iguais");
		}
		
		sc.close();
	}
}