package teste;

class Animal {
	public void fazerSom() {
		System.out.println("O animal faz um som.");
	}
	
	public static void main(String[] args) {
        Animal meuAnimal = new Cachorro(); // Variável polimórfica
        meuAnimal.fazerSom(); // Saída: "O cachorro late."
        
        meuAnimal = new Gato(); // Mudando para uma instância de Gato
        meuAnimal.fazerSom(); // Saída: "O gato mia."
    }
}

class Cachorro extends Animal {
	@Override
	public void fazerSom() {
		System.out.println("O cachorro late.");
	}
}

class Gato extends Animal {
	@Override
	public void fazerSom() {
		System.out.println("O gato mia.");
	}

}

// A classe Main deve estar fora da classe Animal

	
