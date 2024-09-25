package javaCurso2024;

import java.util.Scanner;

//Crie um código que avalie se uma pessoa pode ou não votar.
//
//se for menor de 16: proibido votar.
//
//se for maior ou igual a 16 e menor de 18 ou maior de 65: voto facultativo.
//
//se for maior que 18 e menor que 65: voto obrigatório.

public class Votar {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Digite sua idade: ");
		int idade = scanner.nextInt();
		
		scanner.close();
		
		if (idade < 16) {
			System.out.println("Você e proibido de votar!");
		} else if (idade >= 16 && idade < 18 || idade > 65) {
			System.out.println("Você tem o voto facultativo!");
		} else {
			System.out.println("Você é obrigado a votar!");
		}
	}
}
