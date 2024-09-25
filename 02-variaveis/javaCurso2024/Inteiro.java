package javaCurso2024;

//import java.util.Scanner;
import java.text.MessageFormat;

public class Inteiro {

	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		
//		System.out.println("Digite seu nome");
//		String nome = scanner.nextLine();
//		
//		System.out.println("Digite sua idade do " + nome);
//		int idade = scanner.nextInt();
//		
//		scanner.nextLine();
//		
//		System.out.println("Digite seu cep");
//		String cep = scanner.nextLine();
//		
//		scanner.close();
//		
//		System.out.println("O " + nome + " tem " + idade + " anos, e mora no Cep " + cep);
//		
//		String mensagem = MessageFormat.format("Nome: {0}\nIdade: {1}\nCep: {2}", nome, idade, cep);
//		System.out.println(mensagem);
//		
		// Declarando variavel inteira:
//		int somando = 2 + 8;
//		System.out.println("A soma de 2 + 8 é igual a: " + somando);
//		
//		//subtraindo dentro da variavel
//		int subtracao = 10 - 9;
//		System.out.println("A subtracao de 10 - 9 é igual a: " + subtracao);
//		
//		//multiplicação dentro da variavel
//		int multiplicaçao = 2 * 3;
//		System.out.println("A multiplicação de 2 * 3 é igual a: " + multiplicaçao);
//		
//		//divisao dentro da variavel
//		int divisao = 4 / 8;
//		System.out.println("A divisão de 4 / 8 é igual a: " + divisao);
//		
		//Numero inteiro com virgula:
		double salario = 10000;
		
		//Variavel de texto:
		String nome = "Maria";
		
		//Variavel inteira:
		int idade = 25;
		
		String mensagem = MessageFormat.format("Meu nome é {0}, meu salario é {1}, e tenho {2}, anos", nome, salario, idade);
		System.out.println(mensagem);
	}
}
