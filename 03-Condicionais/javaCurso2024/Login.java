package javaCurso2024;

import java.util.Scanner;

public class Login {

	public static void main(String[] args) {
		// Instanciando a classe Scanner(usando ela);
		Scanner scanner = new Scanner(System.in);

		// Variaveis fixas de nome de usuario e senha:
		String usuarioCorreto = "admin";
		String senhaCorreta = "123";

		// Número maximo de tentativas
		int tentativasMaximas = 3;
		int tentativas = 0; // contador de tentativos

		// Tentativa de login01:
		System.out.println("Digite o nome do usuario: ");
		String usuario = scanner.nextLine();

		System.out.println("Digite a senha: ");
		String senha = scanner.nextLine();

		if (usuario.equals(usuarioCorreto) && senha.equals(senha)) {
			System.out.println("Login realizado com sucesso! Bem-vindo.");
		} else {
			// tentativas = tentativas + 1;
			tentativas++; // mesma coisa que a linha de cima!
			System.out.println("Usuário ou senha incorretos, tente novamente!");

			// tentativa de login 02:
			System.out.println("Digite o nome de usuário: ");
			usuario = scanner.nextLine();

			System.out.println("Digite a senha: ");
			senha = scanner.nextLine();

			if (usuario.equals(usuarioCorreto) && senha.equals(senhaCorreta)) {
				System.out.println("Login realizado com sucesso! Bem vindo.");
			} else {
				tentativas++;
				System.out.println("Usuário ou senha incorretos, tente novamente!");

				// Tentativa final:
				System.out.println("Tentativa final, seu login será bloqueado!");
				
				System.out.println("Digite o nome de usuário: ");
				usuario = scanner.nextLine();

				System.out.println("Digite a senha: ");
				senha = scanner.nextLine();

				if (usuario.equals(usuarioCorreto) && senha.equals(senhaCorreta)) {
					System.out.println("Login realizado com sucesso! Bem vindo.");
				} else {
					tentativas++;
					
					System.out.println("Acesso bloqueado após 3 tentativas erradas!");
				}
			}
		}

		scanner.close();

	}
}
