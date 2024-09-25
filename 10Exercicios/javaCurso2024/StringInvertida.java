package javaCurso2024;

//*Inversão de String*
//- Escreva um programa que peça uma palavra e exiba essa palavra invertida.  
//  Exemplo: Se o usuário digitar "Java", o programa deve exibir "avaJ".

import java.util.Scanner;

public class StringInvertida {
public static void main(String[] args) {
	
	// instanciando o Scanner(usando ele)
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Digite uma palavra, ela será invertida: ");
	String palavra = sc.nextLine();
	
	String palavraInvertida = new StringBuilder(palavra).reverse().toString();
	
	System.out.println("Ao inverter a palavra '" + palavra + "' ela ficá da seguinte maneira: " + palavraInvertida);
	
	sc.close();
}
}
