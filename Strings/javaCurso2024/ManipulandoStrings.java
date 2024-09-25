package javaCurso2024;

public class ManipulandoStrings {
	public static void main(String[] args) {

		// Criando Strings:
		String texto = "Bem vindo ao Curso Intermediario de Java";
		String texto2 = "Vamos aprender sobre Strings!";

		// 1.Comprimento da string:
		// System.out.println("Comprimento da string: " + texto.length());

		// 2.Contatenar Strings:
		String textoCompleto = texto + "\n" + texto2;
		// System.out.println(textoCompleto);

		// 3.Converter para MAIUSCULAS E MINUSCULAS:
		// System.out.println("MAIUSCULAS: " + texto.toUpperCase());
		// System.out.println("minusculas: " + texto2.toLowerCase());
		// System.out.println("Apenas a primeira letra maiuscula: " +
		// texto.substring(0,1).toUpperCase() + texto.substring(1).toLowerCase());
		//
		// Transformando a primeira letra de cada palavra em maiuscula
		// String[] palavras = texto.split(" ");
		// String resultado = "";
		//
		// for (String palavra : palavras) {
		// if(palavra.length() > 0) {
		// // Converte a primeira letra para MAIÚSCULA e concatena com o restante
		// resultado += Character.toUpperCase(palavra.charAt(0));
		// resultado += palavra.substring(1);
		// resultado += " ";
		// }
		// }
		// resultado.trim();
		//
		// System.out.println(resultado);

		// 4.Substituir uma parte da String:
		// String novoTexto = texto.replace("Java", "PHP");
		// System.out.println("Texto após a substituição: " + novoTexto);

		// 5.Buscar por uma substring:
		// int posicao = texto.indexOf("Curso");
		// System.out.println("Posição da palavra 'curso': " + posicao);

		// 6.Verificar se uma string começa ou termina com uma substring:
		// System.out.println("Começa com 'Bem': " + texto.startsWith("Bem"));

		// 7.Dividir uma String:
		// String nomeCompleto = "Yago Andrade Matias da Silva";
		// String[] palavras = nomeCompleto.split(" ");
		// System.out.println("Partes do nome completo: ");
		// for (String palavra : palavras) {
		// System.out.println(palavra);
		// }
		
		// 8. Remover espaços:
		String textoComEspaços = "            Texto               com espcaços.         ";
		System.out.println("Texto sem espaços: '" + textoComEspaços.trim().replaceAll("\\s+", " ") + "'");

	}
}
