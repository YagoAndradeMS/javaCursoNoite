package javaCurso2024;

import java.util.Scanner;

public class Votar2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();

        scanner.close();

        // Determinar a faixa etária
        String faixaEtaria = obterFaixaEtaria(idade);

        // Usar switch para decidir a mensagem com base na faixa etária
        switch (faixaEtaria) {
            case "PROIBIDO":
                System.out.println("Você é proibido de votar!");
                break;
            case "FACULTATIVO":
                System.out.println("Você tem o voto facultativo!");
                break;
            case "OBRIGATORIO":
                System.out.println("Você é obrigado a votar!");
                break;
            default:
                System.out.println("Faixa etária não identificada.");
                break;
        }
    }

    private static String obterFaixaEtaria(int idade) {
        if (idade < 16) {
            return "PROIBIDO";
        } else if (idade >= 16 && idade < 18 || idade > 65) {
            return "FACULTATIVO";
        } else if (idade >= 18 && idade < 65) {
            return "OBRIGATORIO";
        } else {
            return "INVALIDO"; // Para qualquer idade não coberta, caso exista alguma.
        }
    }
}
