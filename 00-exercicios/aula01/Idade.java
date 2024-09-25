package aula01;

import java.text.MessageFormat;
import java.util.Scanner;

public class Idade {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Digite quantos anos você tem: ");
		int ano = scanner.nextInt();
		
		System.out.println("Digite quantos meses você tem: ");
		int meses = scanner.nextInt();
		
		System.out.println("Digite quantos dias você tem: ");
		int dias = scanner.nextInt();
		
		float total = (ano * 365) + (meses * 30) + dias;
		
		//System.out.println("Você tem {0}, anos {1}, meses {2}, dias que e igual a um total de {3} dias"+total);
		String mensagem = MessageFormat.format("Você tem {0} anos {1} meses e {2} dias que é igual a um total de {3} dias", ano, meses, dias, total);
		System.out.println(mensagem);
		scanner.close();
	}
}
