package javaCurso2024;

import java.util.Arrays;
import java.util.List;

public class Filtro {
	public static void main(String[] args) {
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);

		// Filtrando numeros pares, impares e primos:
		// Numeros pares abaixo:
		numeros.stream().filter(n -> n % 2 == 0).forEach(System.out::println);

		// Numeros impares abaixo:
		numeros.stream().filter(n -> n % 2 != 0).forEach(System.out::println);

		// Numeros primos abaixo:
		numeros.stream().filter(Filtro::calculaPrimo).forEach(System.out::println);
	}

	public static boolean calculaPrimo(int n) {
		if (n <= 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		
		return true;

	}
	
}
