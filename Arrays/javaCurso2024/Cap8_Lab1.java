package javaCurso2024;

import java.util.Scanner;

public class Cap8_Lab1 {

		public static int biggestNumber(int[] numbers) {
			int bigger = 0;
			
			for (int number : numbers) {
				if (number > bigger) {
					bigger = number;
				}
			}
			return bigger;
		}
		
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			int[] numbers = new int[4];
			
			for(int i = 0; i < numbers.length; i++) {
				System.out.println("Digite um numero: ");
				numbers[i] = sc.nextInt();
			}
			
			System.out.println("O maior numero digitado foi: " + biggestNumber(numbers));
			
			sc.close();
		}
}
