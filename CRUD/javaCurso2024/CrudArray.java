package javaCurso2024;

import java.util.Scanner;

public class CrudArray {

    // Arrays para armazenar nome e idade
    static String[] nomes = new String[10];
    static int[] idades = new int[10];
    static int contador = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Adicionar usuário");
            System.out.println("2. Exibir usuários");
            System.out.println("3. Atualizar usuário");
            System.out.println("4. Deletar usuário");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // Consumir o newline após nextInt()

            switch(opcao) {
                case 1:
                    adicionarUsuario(sc);
                    break;
                case 2:
                    exibirUsuarios();
                    break;
                case 3:
                    atualizarUsuario(sc);
                    break;
                case 4:
                    deletarUsuario(sc);
                    break;
                case 5:
                    System.out.println("Saindo");
                    break;
                default:
                    System.out.println("Opção Inválida.");
            }

        } while (opcao != 5);
        sc.close();
    }

    // Criar (Adicionar usuário):
    public static void adicionarUsuario(Scanner sc) {
        if (contador < nomes.length) {
            System.out.print("Digite o nome: ");
            String nome = sc.nextLine();

            System.out.print("Digite a idade: ");
            int idade = sc.nextInt();
            sc.nextLine(); // Consumir o newline após nextInt()
            
            nomes[contador] = nome;
            idades[contador] = idade;
            contador++;
            System.out.println("Usuário cadastrado com sucesso!");
        } else {
            System.out.println("Limite de usuários atingido!");
        }
    }

    // Ler/exibir usuários cadastrados:
    public static void exibirUsuarios() {
        if (contador == 0) {
            System.out.println("Nenhum usuário cadastrado!");
        } else {
            for (int i = 0; i < contador; i++) {
                System.out.println((i + 1) + ". Nome: " + nomes[i] + ", Idade: " + idades[i]);
            }
        }
    }

    // Atualizar usuários:
    public static void atualizarUsuario(Scanner sc) {
        System.out.print("Digite o número do usuário a ser atualizado: ");
        int index = sc.nextInt() - 1;
        sc.nextLine(); // Consumir o newline após nextInt()

        if (index >= 0 && index < contador) {
            // Pedindo o novo nome e guardando nos seus respectivos arrays:
            System.out.print("Digite o novo nome: ");
            nomes[index] = sc.nextLine();
            
            // Pedindo a nova idade e guardando nos seus respectivos arrays:
            System.out.print("Digite a nova idade: ");
            idades[index] = sc.nextInt();
            sc.nextLine(); // Consumir o newline após nextInt()

            System.out.println("Usuário atualizado com sucesso!");
        } else {
            System.out.println("Usuário não encontrado!");
        }
    }

    // Deletar usuário:
    public static void deletarUsuario(Scanner sc) {
        System.out.print("Digite o número do usuário a ser deletado: ");
        int index = sc.nextInt() - 1;
        sc.nextLine(); // Consumir o newline após nextInt()

        if (index >= 0 && index < contador) {
            for (int i = index; i < contador - 1; i++) {
                nomes[i] = nomes[i + 1];
                idades[i] = idades[i + 1];
            }
            nomes[contador - 1] = null; // Limpar o último valor
            idades[contador - 1] = 0; // Limpar a última idade
            contador--;
            System.out.println("Usuário deletado com sucesso!");
        } else {
            System.out.println("Usuário não encontrado!");
        }
    }
}
