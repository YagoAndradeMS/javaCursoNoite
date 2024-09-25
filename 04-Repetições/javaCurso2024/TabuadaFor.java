package javaCurso2024;

import java.util.Scanner;

public class TabuadaFor {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Digite o numero que deseja ver a tabuada ");
	int n = sc.nextInt();
	
	System.out.println("Você quer calcular a tabuada do " + n + " até que numero: ");
	int ta = sc.nextInt();
	
	System.out.println("Tabuada do " + n);
	
	for(int i = 0; i <= ta; i++) {
		int resultado = i * n;
		System.out.println(n +" X"
				+ " " + i + " = " + resultado );
		
	}
	
	sc.close();
}
}
