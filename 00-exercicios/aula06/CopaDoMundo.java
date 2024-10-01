package aula06;

public class CopaDoMundo {
	public static void main(String[] args) {
		
		int ano = 2024;
		
		for(int i = 1930; i < ano; i += 4) {
			if (i == 1942 || i == 1946) {
				System.out.println("Neste ano não teve copa do mundo por conta da guerra, ano = " + i);
			} else {
				System.out.println("Copa do mundo de " + i + "!");
			}
		}
	}
}
