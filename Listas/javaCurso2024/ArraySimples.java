package javaCurso2024;

public class ArraySimples {
	public static void main(String[] args) {
		// Criando um array(lista) de frutas:
		String[] frutas = { "Banana", "Maça", "Pera", "Tomate", "Melancia" };

		// Exibindo apenas 1 item do array:
		// System.out.println("Item minha fruta é: " + frutas[0]);

		// Exibir todos os itens do array com for:
		for(int item = 0; item < frutas.length; item++) {
			System.out.println("Fruta: " + frutas[item]);
		}
		
		// for(String nome : frutas) {
		//	System.out.println(nome);
		// }
	}
}