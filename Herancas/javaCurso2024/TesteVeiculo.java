package javaCurso2024;

public class TesteVeiculo {
	public static void main(String[] args) {
		Carro carro = new Carro("Toyota", "Corrola", 2004, 4);
		Carro carro1 = new Carro("Camaro", "Voiage", 2008, 4);
		
		Moto moto = new Moto("Honda", "CB500", 2019, true);
		Moto moto1 = new Moto("Bis", "300D", 2015, false);
		
		System.out.println("Detalhes do Carro1: ");
		carro.exibirDetalhes();
		
		System.out.println("\nDetalhes do Carro2: ");
		carro1.exibirDetalhes();
		
		System.out.println("\nDetalhes da Moto1: ");
		moto.exibirDetalhes();
		
		System.out.println("\nDetalhes da Moto2: ");
		moto1.exibirDetalhes();
		
	}
}
