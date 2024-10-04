package javaCurso2024;
public class OperaConta {
	
	public static void main(String[] args) {
		
		//Criação de conta com saldo inicial 1000,00
		ContaBancaria conta = new ContaBancaria(1000.00);
		
		
		//Operando conta do cliente
		//Exibir o saldo inicial da conta
		System.out.println("Saldo Inicial: " + conta.getSaldo());
		conta.depositar(3);
		System.out.println("O valor total em conta após depósito é: " + conta.getSaldo());
		conta.sacar(500);
		System.out.println("O valor total em conta após saque é: " + conta.getSaldo());

		
		
	}

}