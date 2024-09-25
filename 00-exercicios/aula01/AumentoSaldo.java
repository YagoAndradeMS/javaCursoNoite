package aula01;

import java.util.Scanner;

public class AumentoSaldo {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
				
		System.out.println("Digite um numero: ");
		int num = scanner.nextInt();
		
		int acrescimo = (int) (num * 0.01);
		
		System.out.println(num + acrescimo);
		scanner.close();
	}
}
