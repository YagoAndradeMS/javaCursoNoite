package javaCurso2024;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

//Exercício 02: Crie um programa que peça o nome de algumas pessoas e ao final sorteia uma destas pessoas!

public class SorteioAlunos {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> alunos = new ArrayList<>();
		Random random = new Random();

		Boolean sim = true;
		Boolean respostaValida = false;
		String res;

		while (sim) {
			System.out.println("\nDigite o nome de um aluno para inscreve-lo no sorteio: ");
			alunos.add(sc.nextLine());
			respostaValida = false;

			if (alunos.get(alunos.size() - 1).isEmpty()) {
				System.out.println("Nenhum nome foi digitado!");
				alunos.remove(alunos.size() - 1);
			} 

			while (!respostaValida) {
				System.out.println("Você quer adicionar mais algum aluno? S/N");
				res = sc.nextLine();

				if (res.equalsIgnoreCase("n")) {
					respostaValida = true;
					sim = false;
				} else if (res.equalsIgnoreCase("s")) {
					respostaValida = true;
				} else {
					System.out.println("Digite uma resposta válida.");
				}
			}
		}
		
		int rand = random.nextInt(alunos.size() );
		System.out.println("O aluno sorteado foi o " + alunos.get(rand));

		sc.close();
	}
}
