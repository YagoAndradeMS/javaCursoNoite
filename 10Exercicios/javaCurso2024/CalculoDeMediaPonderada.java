package javaCurso2024;

import java.util.Scanner;

//*Cálculo de Média Ponderada*
//- Faça um programa que peça três notas e seus respectivos pesos. O programa deve calcular e exibir a média ponderada dessas notas.

public class CalculoDeMediaPonderada {
	public static void main(String[] args) {
		
		//Instanciando o Scanner
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite a primeira nota: ");
		float nota = sc.nextFloat();
		System.out.println("Digite o peso da primeira nota: ");
		float peso = sc.nextFloat();
		
		System.out.println("Digite a segunda nota: ");
		float nota1 = sc.nextFloat();
		System.out.println("Digite o peso da segunda nota: ");
		float peso1 = sc.nextFloat();
		
		System.out.println("Digite a terceira nota: ");
		float nota2 = sc.nextFloat();
		System.out.println("Digite o peso da segunda nota: ");
		float peso2 = sc.nextFloat();
		
		float pesoTotal = peso + peso1 + peso2;
		
		float notaFinal = (nota * peso + nota1 * peso1 + nota2 * peso2) / pesoTotal;
		
		System.out.printf("A média ponderada é: %.2f\n", notaFinal);
		
		sc.close();
    }
		
	}

