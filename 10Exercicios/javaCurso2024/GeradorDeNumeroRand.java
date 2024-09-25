package javaCurso2024;

import java.util.Random;

//*Gerador de Números Aleatórios*
//- Crie um programa que gere 5 números aleatórios entre 1 e 100 e exiba-os.

public class GeradorDeNumeroRand {

	public static void main(String[] args) {

		// Instanciando a classe Random
		Random random = new Random();

		System.out.println("Gerando 5 numeros aleatórios entre 1 e 100");
		
		//Gera e exibe 5 números aleatórios
		for( int i = 0; i < 5; i++) {
			int numeroAleatorio = random.nextInt(100) + 1;
			System.out.println("O numero sorteado foi " + numeroAleatorio);
		}
	}
}
