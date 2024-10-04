package javaCurso2024;

import java.util.Scanner;

public class CrudArray {
	
	// Arrays para armazenar nome e idade 
	static String[] nomes = new String[10];
	static int[] idades = new int[10];
	static int contador = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcao;
		
		do {
			System.out.println("\n--- Menu ---");
			System.out.println("1. Adicionar usuário");
			System.out.println("2. Exibir usuário");
			System.out.println("3. Atualizar usuário");
			System.out.println("4. Deletar usuário");
			System.out.println("5. Sair");
			System.out.println("Escolha uma opção: ");
			opcao = sc.nextInt();
			
			switch(opcao) {
			case 1:
				adicionarUsuario(sc);
				break;
			case 2:
				exibirUsuarios(sc);
				break
			case 3:
				atualizarUsuario(sc);
				break
			case 4:
				deletarUsuario(sc);
				break
			case 5:
				System.out.println("Saindo");
				break
			default:
			System.out.println("Opção Inválida.");		
			}
			
		} while (opcao != 5);
		sc.close();
	}
	// Criar (Adicionar usuario):
	public static void adicionarUsuario(Scanner sc) {
		if (contador < nomes.length) {
			System.out.println("Digite o nome: ");
			String nome = sc.nextLine();
			
			System.out.println("Digite a idade: ");
			int idade = sc.nextInt();
			nomes[contador] = nome;
			idades[contador] = idade;
			contador++;
			System.out.println("Usuário cadastrado com Sucesso!");
		} else {
			System.out.println("Limite de idade atingido!");
		}
	}
}












