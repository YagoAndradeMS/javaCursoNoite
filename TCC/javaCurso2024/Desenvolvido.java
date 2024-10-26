package javaCurso2024;

import javax.swing.*;
import java.awt.*;
import FlapBird.FlappyBird; // Importa o pacote do Flappy Bird
import FlapBird.Motor; // Import

public class Desenvolvido {
    public static void main(String[] args) {
        // Criando a primeira janela (Janela Principal)
        JFrame janelaPrincipal = new JFrame("Menu de Jogos");
        janelaPrincipal.setSize(300, 200);
        janelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaPrincipal.setLocationRelativeTo(null);
        janelaPrincipal.setLayout(new GridBagLayout());
        janelaPrincipal.getContentPane().setBackground(new Color(220, 220, 220)); // Cor de fundo

        // Criando um painel para organizar os botões
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new BoxLayout(painelBotoes, BoxLayout.Y_AXIS));
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Margens do painel

        // Criando o botão para abrir o jogo da Cobrinha
        JButton botaoAbrirJanela2 = new JButton("Abrir Jogo da Cobrinha");
        botaoAbrirJanela2.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoAbrirJanela2.setPreferredSize(new Dimension(200, 30));
        botaoAbrirJanela2.setFont(new Font("Arial", Font.BOLD, 14)); // Alterando fonte do botão

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
        botaoAbrirFlappyBird.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoAbrirFlappyBird.setPreferredSize(new Dimension(200, 30));
        botaoAbrirFlappyBird.setFont(new Font("Arial", Font.BOLD, 14)); // Alterando fonte do botão

        // Adicionando ação no botão para abrir o Flappy Bird
        botaoAbrirFlappyBird.addActionListener(e -> {
            FlappyBird jogoFlappy = new FlappyBird(janelaPrincipal);
            
            // Criando a janela para exibir o Flappy Bird
            JFrame janelaFlappyBird = new JFrame("Flappy Bird");
            janelaFlappyBird.add(new Motor(jogoFlappy));  // Motor inicializa o jogo
            janelaFlappyBird.setSize(jogoFlappy.getLargura(), jogoFlappy.getAltura());
            janelaFlappyBird.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            janelaFlappyBird.setLocationRelativeTo(null);
            janelaFlappyBird.setVisible(true);
        });

        // Adicionando os botões ao painel
        painelBotoes.add(botaoAbrirJanela2);
        painelBotoes.add(Box.createRigidArea(new Dimension(0, 10))); // Espaço entre os botões
        painelBotoes.add(botaoAbrirFlappyBird);

        // Adicionando o painel à janela principal
        janelaPrincipal.add(painelBotoes);
        janelaPrincipal.setVisible(true);
    }
}
