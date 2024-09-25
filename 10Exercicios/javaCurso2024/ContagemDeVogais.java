package javaCurso2024;

import java.text.Normalizer;

//*Contagem de Vogais em uma Frase*
//- Escreva um programa que peça uma frase e conte quantas vogais (a, e, i, o, u) ela contém.

import java.util.Scanner;

public class ContagemDeVogais {
public static void main(String[] args) {
	//Instanciando o Scanner(usando ele)
	Scanner sc = new Scanner(System.in);
	
	//Pegando uma frase do usuario
	System.out.println("Digite uma frase: ");
	String frase = sc.nextLine();
	
	//Formatando a frase
	String fraseMini = frase.toLowerCase();
	String fraseNormal = Normalizer.normalize(fraseMini, Normalizer.Form.NFD);
	
	int quantidadeVogais = 0;
	
	//Verificando se tem alguma vogal na frase
	for(int i = 0; i < fraseNormal.length(); i++) {
		
		char c = fraseNormal.charAt(i);
		if (c == 'a' || c == 'e' || c == 'i' || c =='o' || c == 'u') {
			quantidadeVogais++; 
		}
	}
	
	//Mandando mensagem para o usuario
	System.out.println("A quantidade total de vogais na frase '" + frase + "' é de:  " + quantidadeVogais);
	
	sc.close();
}
}
