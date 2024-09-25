package javaCurso2024;

//*Cálculo de Desconto*
//- Escreva um programa que peça o preço original de um produto e um percentual de desconto. O programa deve calcular o preço final após o desconto.

import java.util.Scanner;

public class CalcDesconto {
	public static void main(String[] args) {
		//instanciando o scanner(usando ele)
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o preço do produto: ");
		float preco = sc.nextFloat();
		
		System.out.println("Digite a porcentagem de desconto que será aplicada: ");
		float desc = sc.nextFloat();
		
		float precoFinal = preco - (preco * ( desc / 100));
		
		System.out.println("O preço final do produto será de: " + precoFinal);
		
		sc.close();
	}
}
