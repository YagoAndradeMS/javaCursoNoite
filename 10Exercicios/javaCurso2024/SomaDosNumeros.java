package javaCurso2024;

import java.util.Scanner;

//*Soma dos Dígitos de um Número*
//- Faça um programa que peça um número inteiro e calcule a soma de seus dígitos.  
//  Exemplo: Para o número 1234, a soma seria \(1 + 2 + 3 + 4 = 10\).

public class SomaDosNumeros {

	public static void main(String[] args) {
		
		//instanciando o Scanner
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite um numero inteiro: ");
		int num = sc.nextInt();
		
		int total = 0;
		
		//Fazendo a soma de todos os digitos
		while (num != 0) {
            // Extrai o último dígito (resto da divisão por 10)
            int digito = num % 10;
            // Adiciona o dígito à soma
            total += digito;
            // Remove o último dígito do número
            num /= 10;
        }
		
		System.out.println("A soma total é igual a " + total);
		sc.close();
	}
}
