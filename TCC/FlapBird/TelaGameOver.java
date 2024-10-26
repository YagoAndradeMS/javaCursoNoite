package FlapBird;

import java.awt.*;
import javax.swing.*;

public class TelaGameOver extends JPanel {

    private int score;
    private int screenWidth;
    private int screenHeight;

    private JButton botaoVoltar;
    private JFrame janelaPrincipal;

    public TelaGameOver(int score, int screenWidth, int screenHeight, JFrame janelaPrincipal) {
        this.score = score;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.janelaPrincipal = janelaPrincipal; // Armazena a referência da janela principal
        setLayout(new BorderLayout()); // Define o layout do JPanel
        voltarMenu(); // Configura os botões ao criar a tela
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGameOver(g); // Chama o método para desenhar a tela de "Game Over"
    }

    public void drawGameOver(Graphics g) {
        // Exibir a pontuação final
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics fontePontuacao = g.getFontMetrics(g.getFont());
        g.drawString("Pontos: " + score,
                (screenWidth - fontePontuacao.stringWidth("Pontos: " + score)) / 2, g.getFont().getSize());

        // Mensagem de fim de jogo
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 75));
        FontMetrics fonteFinal = g.getFontMetrics(g.getFont());
        g.drawString("Fim do Jogo",
                (screenWidth - fonteFinal.stringWidth("Fim do Jogo")) / 2, screenHeight / 2);
    }

    public void voltarMenu() {
        if (botaoVoltar == null) {
            JPanel panelBotoes = new JPanel();
            panelBotoes.setLayout(new FlowLayout());

            // Botão "Voltar ao Menu Principal"
            botaoVoltar = new JButton("Voltar ao Menu Principal");
            botaoVoltar.setPreferredSize(new Dimension(200, 30));
            botaoVoltar.addActionListener(e -> {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(botaoVoltar); // Obtém a janela atual
                frame.setVisible(false); // Oculta a janela do jogo
                // Torna a janela principal visível
                janelaPrincipal.setVisible(true); // Use a referência armazenada
            });

            // Botão "Rejogar"
            JButton botaoRejogar = new JButton("Rejogar");
            botaoRejogar.setPreferredSize(new Dimension(200, 30));
            botaoRejogar.addActionListener(e -> {
                reiniciarJogo(); // Chama o método para reiniciar o jogo
                removerBotoes(); // Remove os botões após reiniciar
            });

            // Adiciona os botões ao painel
            panelBotoes.add(botaoVoltar);
            panelBotoes.add(botaoRejogar);

            // Adiciona o painel à interface
            add(panelBotoes, BorderLayout.SOUTH);
        }
    }

    private void reiniciarJogo() {
        // Lógica para reiniciar o jogo
        // Você precisará implementar isso de acordo com sua lógica de jogo
    }

    private void removerBotoes() {
        // Lógica para remover os botões da tela
        remove(botaoVoltar.getParent()); // Remove o painel de botões
        revalidate();
        repaint();
    }
}
