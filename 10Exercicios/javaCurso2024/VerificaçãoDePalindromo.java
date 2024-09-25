package javaCurso2024;

import java.util.Scanner;

//*Verificação de Palíndromo*
//- Crie um programa que peça uma palavra e verifique se ela é um palíndromo (palavra que é igual de frente para trás).  
//  Exemplo: "arara" é um palíndromo.

public class VerificaçãoDePalindromo {
	public static void main(String[] args) {
		
		//instanciando o Scanner(usando ele)
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite uma palavra para saber se ela e um palíndromo: ");
		String palavra = sc.nextLine();
		
		//Removendo os spaços e invertendo a palavra
		String palavraFormatada = palavra.replaceAll("\\s+", "").toLowerCase();
		String palavraInversa = new StringBuilder(palavraFormatada).reverse().toString();
		
		//Verificando se a inversão da palavra e igual a ela
		if(palavraFormatada.equals(palavraInversa)) {
			System.out.println("A palavra '" + palavra + "' é um palíndromo");
		} else {
			System.out.println("A palavra '" + palavra + "' não é um palíndromo");
		}
		
		sc.close();
	}
}
