package aula05;

import java.util.Scanner;

public class VerificarDiaDoMes {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite um mês");
		String mes = sc.nextLine();
		int dia = 0;
		
		//mes = mes.toLowerCase();
		
		switch (mes.toLowerCase()) {
		case "janeiro":
			dia = 31;
			break;
		case "fevereiro":
			dia = 29;
			break;
		case "março":
			dia = 31;
			break;
		case "abril":
			dia = 30;
			break;
		case "maio":
			dia = 31;
			break;
		case "junho":
			dia = 30;
			break;
		case "julho":
			dia = 31;
			break;
		case "agosto":
			dia = 31;
			break;
		case "setembro":
			dia = 30;
			break;
		case "outubro":
			dia = 31;
			break;
		case "novembro":
			dia = 30;
			break;
		case "dezembro":
			dia = 31;
			break;
			default:
			System.out.println("Erro digite um mês valido");
			break;

		}
		
		System.out.println("O mês " + mes + " tem um total de " + dia);
		
		sc.close();
	}
}
