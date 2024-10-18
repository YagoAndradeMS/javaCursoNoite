package javaCurso2024;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Exercicios {

	public static void main(String[] args) {
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		
		List<String> nomes = Arrays.asList("Carlos", "Ana", "Paulo", "Yago", "Ricardo");
		
		//Ordenando nomes
		System.out.println("Ordenando nomes: ");
		nomes.stream().sorted().forEach(System.out::println);
		
		// Transformando dados
		System.out.println("\nTransformando dados ");
		List<Integer> quadrados = numeros.stream().map(n -> n * n).collect(Collectors.toList());
		System.out.println(quadrados);
		
		//Reduzindo dados
		System.out.println("\nSomando dados(reduzindo): ");
		int soma = numeros.stream().reduce(0, Integer::sum);
		System.out.println(soma);
		
		//Agrupando dados
		System.out.println("\nAgrupando por tamanho: ");
		Map<Integer, List<String>> agrupadosPorTamanho = nomes.stream().collect(Collectors.groupingBy(String::length));
		System.out.println(agrupadosPorTamanho);
		
		// Limitando e pulando elementos (limit e skip)
		System.out.println("\nLimitando exibição para 3 numeros ");
		numeros.stream().limit(3).forEach(System.out::println);
		
		System.out.println("\nPulando os 2 primeiros e exibindo o restante ");
		numeros.stream().skip(2).forEach(System.out::println);
		
		// Verificando Condições
		// Verificando de 1 numero
		boolean algumMaiorQue7 = numeros.stream().anyMatch(n -> n > 7);
		System.out.println("\nExibi se tem algum numero maior que 7");
		System.out.println(algumMaiorQue7);
		
		// Verificando de varios numeros
		boolean todosPositivos = numeros.stream().allMatch(n -> n > 0);
		System.out.println("\nTodos os numeros são positivos ");
		System.out.println(todosPositivos);
		
		// Verifica se nenhum número é negativo
		boolean nenhumNegativo = numeros.stream().noneMatch(n -> n < 0);
		System.out.println("\nNenhum numero é negativo ");
		System.out.println(nenhumNegativo);
	}
}















