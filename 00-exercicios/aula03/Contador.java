package aula03;

import java.util.Scanner;

public class Contador {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o numero que deseja iniciar: ");
        
        int i = scanner.nextInt(); //Pega o numero que o usuario digitar
        int total = 0; // Contador de números impressos
        
        while (i <= 343) {
            
            if (i % 7 != 0) { // Pular múltiplos de 7
                
                // Verificar se o número é primo
                if (isPrimo(i)) {
                    System.out.println("Número primo encontrado: " + i);
                }
                
                // Verificar se o número é múltiplo de 13
                if (i % 13 == 0) {
                    System.out.println("Encontrei um múltiplo de 13, você deseja continuar? S/N");
                    String resposta = scanner.nextLine();
                    
                    if (resposta.equalsIgnoreCase("N")) {
                        break; // Interromper o loop se o usuário decidir parar
                    }
                }
                
                // Imprimir o número
                System.out.println(i);
                total++; // Incrementar o contador de números impressos
            }
            
            i += 4; // Incremento de 4 em 4
        }
        
        System.out.println("O total de números exibidos foi de " + total);
        
        scanner.close();
    }
    
    // Método para verificar se o número é primo
    public static boolean isPrimo(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
