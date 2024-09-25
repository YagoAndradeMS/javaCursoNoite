package aula01;

public class medias {
	public static void main(String[] args) {
		
		float media1 = (8 + 9 + 7) / 3.0f; 
		System.out.println("A media dos numeros 8, 9 e 7 é igual a " + media1);
		
		float media2 = (4 + 5 + 6) / 3.0f;
		System.out.println("A media dos numeros 4, 5 e 6 é igual a " + media2);
		
		float media3 = (media1 + media2) / 2;
		System.out.println("A soma das duas medias é igual " + (media1 + media2));
		System.out.println();
		System.out.println("A media da soma das duas medias é igual a " + media3);
	}
}
