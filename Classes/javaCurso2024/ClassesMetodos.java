package javaCurso2024;

import java.util.Scanner;

public class ClassesMetodos {

	// Método 1: calcula a soma de 2 valores:
	public int soma(int a, int b) {
		return a + b;
	}

	public String par(int a) {
	//	if (a % 2 == 0) {
	//		return ("Par");
	//	} else {
	//		return ("Ímpar");
	//	}
		return a % 2 == 0 ? "par" : "impar";
	}

	public String inverte(String palavra) {
		return new StringBuilder(palavra).reverse().toString();
	}

	public int fatorial(int a) {
		int total = 1;
		for (int i = 1; i < a; i++) {
			total += total * i;
		}
		return total;
	}

	public int maior(int[] list) {
		int maior = 0;
		for (int num : list) {
			if (num > maior) {
				maior = num;
			}
		}
		return maior;
	}

	
	// Este método executa outros metodos
	public static void main(String[] args) {
		// Instanciando a classe que criamos:
		ClassesMetodos util = new ClassesMetodos();

//		// Instanciando o Scanner
		Scanner sc = new Scanner(System.in);
		
		int[] numero = {5, 7, 12};
		
		//for (int i = 0; i < 5; i++) {
			
		// System.out.println("Digite um numero: ");
		// numero = {1,2,3};
		//sc.nextLine();
		// }

		//sc.nextLine();

	System.out.println("Digite uma palavra: ");
	String palavra = sc.nextLine();

		// Chamando os métodos:
		System.out.println("Soma de 3 + " + numero[1] + " : " + util.soma(numero[1], 3));

		// Verificar se um numero é par ou ímpar:
		System.out.println("O numero " + numero[1] + " é " + util.par(numero[1]));

		// Inverti uma String
		System.out.println("A palavra " + palavra + " invertida fica da seguinte maneira: " + util.inverte(palavra));

		// Faz a conta do fatorial de um numero:
		System.out.println("O fatorial do numero: " + util.fatorial(numero[1]));
		
		// Encontra o maior numero em um Array
		System.out.println("O maior numero dentro desta lista é o: " + util.maior(numero));
		
		sc.close();
	}
}
