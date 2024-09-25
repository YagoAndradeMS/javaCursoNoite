package javaCurso2024;

import java.util.Scanner;

//*Contagem de Letras e Espaços*
//- Escreva um programa que peça uma frase e conte quantas letras (a-z) e quantos espaços em branco ela contém.

public class ContagemLetras {
public static void main(String[] args) {
	
	//Instanciando o Scanner
	Scanner sc = new Scanner(System.in);
	
	//Pedindo a frase para o usuario
	System.out.println("Digite uma frase ");
	String frase = sc.nextLine();
	
	//Variaveis para armazenar o valor das letras e espaços
	int contLetras = 0;
	int contEspacos = 0;
	
	//Contagem das letras e espaços
	for(int i = 0; i < frase.length(); i++) {
		char c = frase.charAt(i);
		
		if(Character.isLetter(c)) {
			contLetras++;
		} else if (Character.isWhitespace(c)) {
			contEspacos++;
		}
	}
	
	//Exibindo a contagem para o usuario
	System.out.println("O total de letras na frase é de " + contLetras);
	System.out.println("O total de espaços na frase é de " + contEspacos);
	
	sc.close();
}
}
