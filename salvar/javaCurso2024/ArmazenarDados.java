package javaCurso2024;

import java.util.Scanner;
import java.util.prefs.Preferences;

public class ArmazenarDados {

    static Preferences prefs = Preferences.userRoot().node("myApp");
    static final String USER_KEY = "users";
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Adicionar usuário");
            System.out.println("2. Exibir usuários");
            System.out.println("3. Atualizar usuário");
            System.out.println("4. Deletar usuário");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir o newline após nextInt()

            switch(opcao) {
                case 1:
                    adicionarUsuario();
                    break;
                case 2:
                    exibirUsuarios();
                    break;
                case 3:
                    atualizarUsuario();
                    break;
                case 4:
                    deletarUsuario();
                    break;
                case 5:
                    System.out.println("Saindo");
                    break;
                default:
                    System.out.println("Opção Inválida.");
            }

        } while (opcao != 5);
        scanner.close();
    }

    // Criar (Adicionar usuário):
    public static void adicionarUsuario() {
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); // Consumir o newline após nextInt()

        // Adiciona o novo usuário
        String usuarios = prefs.get(USER_KEY, ""); // Recupera os usuários existentes
        String novoUsuario = nome + "," + idade; // Formato: "nome,idade"
        
        if (!usuarios.isEmpty()) {
            usuarios += ";"; // Separador entre usuários
        }
        usuarios += novoUsuario; // Adiciona o novo usuário
        prefs.put(USER_KEY, usuarios); // Salva as preferências
        System.out.println("Usuário cadastrado com sucesso!");
    }

    // Ler/exibir usuários cadastrados:
    public static void exibirUsuarios() {
        String usuarios = prefs.get(USER_KEY, "");
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado!");
        } else {
            String[] listaUsuarios = usuarios.split(";");
            for (int i = 0; i < listaUsuarios.length; i++) {
                String[] dados = listaUsuarios[i].split(",");
                System.out.println((i + 1) + ". Nome: " + dados[0] + ", Idade: " + dados[1]);
            }
        }
    }

    // Atualizar usuários:
    public static void atualizarUsuario() {
        exibirUsuarios(); // Mostrar usuários para o usuário escolher
        System.out.print("Digite o número do usuário a ser atualizado: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir o newline após nextInt()

        String usuarios = prefs.get(USER_KEY, "");
        String[] listaUsuarios = usuarios.split(";");

        if (index >= 0 && index < listaUsuarios.length) {
            // Pedindo o novo nome e a nova idade
            String[] dados = listaUsuarios[index].split(",");
            System.out.print("Digite o novo nome (atual: " + dados[0] + "): ");
            String novoNome = scanner.nextLine();
            System.out.print("Digite a nova idade (atual: " + dados[1] + "): ");
            int novaIdade = scanner.nextInt();
            scanner.nextLine(); // Consumir o newline após nextInt()

            // Atualizando o usuário
            listaUsuarios[index] = novoNome + "," + novaIdade; // Atualiza os dados
            String novosUsuarios = String.join(";", listaUsuarios); // Recria a string de usuários
            prefs.put(USER_KEY, novosUsuarios); // Salva as preferências
            System.out.println("Usuário atualizado com sucesso!");
        } else {
            System.out.println("Usuário não encontrado!");
        }
    }

    // Deletar usuário:
    public static void deletarUsuario() {
        exibirUsuarios(); // Mostrar usuários para o usuário escolher
        System.out.print("Digite o número do usuário a ser deletado: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir o newline após nextInt()

        String usuarios = prefs.get(USER_KEY, "");
        String[] listaUsuarios = usuarios.split(";");

        if (index >= 0 && index < listaUsuarios.length) {
            // Remove o usuário da lista
            String[] novosUsuarios = new String[listaUsuarios.length - 1];
            for (int i = 0, j = 0; i < listaUsuarios.length; i++) {
                if (i != index) {
                    novosUsuarios[j++] = listaUsuarios[i];
                }
            }
            String usuariosAtualizados = String.join(";", novosUsuarios); // Recria a string de usuários
            prefs.put(USER_KEY, usuariosAtualizados); // Salva as preferências
            System.out.println("Usuário deletado com sucesso!");
        } else {
            System.out.println("Usuário não encontrado!");
        }
    }
    
    
}
