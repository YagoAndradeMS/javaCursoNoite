package aula02;

import java.util.Scanner;

public class CompararValor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Captura o primeiro número
        System.out.print("Digite um numero: ");
        int num1 = scanner.nextInt();
        
        // Captura o segundo número
        System.out.print("Digite outro numero: ");
        int num2 = scanner.nextInt();
        
        // Fecha o scanner
        scanner.close();
        
        // Compara os números
        if (num1 > num2) {
            System.out.println("O numero " + num1 + " é maior que o numero " + num2);
        } else if (num2 > num1) {  // Corrigido para verificar se num2 é maior
            System.out.println("O numero " + num2 + " é maior que o numero " + num1);
        } else {
            System.out.println("Os dois numeros têm o mesmo valor");
        }
    }
}
