package javaCurso2024;

import java.util.Scanner;

public class JavaController {
	
	public int multiplicação(int num, int num2) {
		return num * num2;
	}
	
	public int soma(int num, int num2) {
		return num + num2;
	}
	
	public int subtração(int num, int num2) {
		return num - num2;
	}
	
	public int divisao(int num, int num2) {
		return num / num2;
	}
	
	public int maior(int num, int num2) {
		if(num > num2) {
			return num;
		} else if (num2 > num) {
			return num2;
		} else {
			return num;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		JavaController util = new JavaController();
		
		System.out.println("Digite um numero: ");
		int num = sc.nextInt();
		
		System.out.println("Digite outro numero: ");
		int num2 = sc.nextInt();
		
		System.out.println("A soma do numero " + num + " o numero " + num2 + " é igual há " + util.soma(num, num2));
		
		System.out.println("A subtração do numero " + num + " o numero " + num2 + " é igual há " + util.subtração(num, num2));
		
		System.out.println("A divisão do numero " + num + " o numero " + num2 + " é igual há " + util.divisao(num, num2));
		
		System.out.println("A multiplicação do numero " + num + " o numero " + num2 + " é igual há " + util.multiplicação(num, num2));
		
		System.out.println("O maior numero entre o numero " + num + " e o numero " + num2 + " é: " + util.maior(num, num2));
		sc.close();
	}
}
