package aula03;

import java.util.Scanner;

public class PositivoNegativo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int num = 1;
		while (num > 0) {
			System.out.println("Insira um numero:");
			num = scanner.nextInt();
			System.out.println(num);
			
			scanner.close();
		}
		
	}
}
