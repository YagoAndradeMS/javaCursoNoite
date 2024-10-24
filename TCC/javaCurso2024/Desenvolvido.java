package javaCurso2024;

import javax.swing.*;
import FlapBird.FlappyBird; // Importa o pacote do Flappy Bird

public class Desenvolvido {
    public static void main(String[] args) {
        // Criando a primeira janela (Janela Principal)
        JFrame janelaPrincipal = new JFrame("Janela Principal");
        janelaPrincipal.setSize(300, 200);
        janelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaPrincipal.setLayout(null);
        janelaPrincipal.setLocationRelativeTo(null);

        // Criando o botão para abrir o jogo da Cobrinha
        JButton botaoAbrirJanela2 = new JButton("Abrir Jogo da Cobrinha");
        botaoAbrirJanela2.setBounds(80, 50, 140, 30);

        // Adicionando ação no botão para abrir a segunda janela (Jogo da Cobrinha)
        botaoAbrirJanela2.addActionListener(e -> {
            JogoCobrinha abrirJanela2 = new JogoCobrinha(janelaPrincipal);
            
            // Criando a janela para exibir o jogo da cobrinha
            JFrame janelaSecundaria = new JFrame("Jogo da Cobrinha");
            janelaSecundaria.add(abrirJanela2);
            janelaSecundaria.pack();
            janelaSecundaria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            janelaSecundaria.setLocationRelativeTo(null);
            janelaSecundaria.setVisible(true);
        });

        // Criando o botão para abrir o jogo do Flappy Bird
        JButton botaoAbrirFlappyBird = new JButton("Abrir Flappy Bird");
        botaoAbrirFlappyBird.setBounds(80, 100, 140, 30);

        // Adicionando ação no botão para abrir o Flappy Bird
        botaoAbrirFlappyBird.addActionListener(e -> {
            FlappyBird jogoFlappy = new FlappyBird();
            
            // Criando a janela para exibir o Flappy Bird
            JFrame janelaFlappyBird = new JFrame("Flappy Bird");
            janelaFlappyBird.add(new Motor(jogoFlappy));  // Motor inicializa o jogo
            janelaFlappyBird.setSize(jogoFlappy.getLargura(), jogoFlappy.getAltura());
            janelaFlappyBird.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            janelaFlappyBird.setLocationRelativeTo(null);
            janelaFlappyBird.setVisible(true);
        });

        // Adicionando os botões à janela principal
        janelaPrincipal.add(botaoAbrirJanela2);
        janelaPrincipal.add(botaoAbrirFlappyBird);
        janelaPrincipal.setVisible(true);
    }
}
