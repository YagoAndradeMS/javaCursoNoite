package javaCurso2024;

import java.util.Scanner;
import java.util.Arrays;

//*Ordenação de um Vetor de Números*
//- Crie um programa que peça 5 números ao usuário, armazene-os em um vetor e depois exiba-os em ordem crescente.

public class OrganizadorDeVetor {
	public static void main(String[] args) {
		
		//Instanciando o Scanner
		Scanner sc = new Scanner(System.in);
		
		int[] numeros = new int[5];
		
		System.out.println("Digite 5 numeros: ");
		for(int i = 0; i < 5; i++) {
			System.out.println("numero " + (i + 1) + " :");
			numeros[i] = sc.nextInt();
		}
		
		//Organizando o vetor
		Arrays.sort(numeros);
		
		System.out.print("Seu vetor em ordem crescente fica da seguinte forma: ");
		
		for(int num : numeros) {
			System.out.print(" " + num);
		}
		
		sc.close();
		
	}
}
