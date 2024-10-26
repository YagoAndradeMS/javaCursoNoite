package FlapBird;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PosMorte {
    private JFrame janelaPrincipal; // Referência para a janela principal do jogo
    private FlappyBird flappyBird;  // Referência para a instância do jogo

    public PosMorte(JFrame janelaPrincipal, FlappyBird flappyBird) {
        this.janelaPrincipal = janelaPrincipal;
        this.flappyBird = flappyBird;
    }

    public void mostrarTelaDeFimDeJogo() {
        JPanel panelBotoes = new JPanel();
        panelBotoes.setLayout(new FlowLayout());

        // Botão "Voltar ao Menu Principal"
        JButton botaoVoltar = new JButton("Voltar ao Menu Principal");
        botaoVoltar.setPreferredSize(new Dimension(200, 30));
        botaoVoltar.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(botaoVoltar); // Obtém a janela atual
            frame.setVisible(false); // Oculta a janela do jogo
            janelaPrincipal.setVisible(true); // Torna a janela principal visível
        });

        // Botão "Rejogar"
        JButton botaoRejogar = new JButton("Rejogar");
        botaoRejogar.setPreferredSize(new Dimension(200, 30));
        botaoRejogar.addActionListener(e -> {
            flappyBird.reiniciarJogo(); // Reinicia o jogo
            janelaPrincipal.setVisible(false); // Oculta a janela principal
            new Motor(flappyBird); // Inicia um novo motor com a instância do jogo
        });

        panelBotoes.add(botaoVoltar);
        panelBotoes.add(botaoRejogar);

        // Criação da janela de fim de jogo
        JFrame janelaFimDeJogo = new JFrame("Fim de Jogo");
        janelaFimDeJogo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaFimDeJogo.setSize(400, 200);
        janelaFimDeJogo.setLayout(new BorderLayout());
        janelaFimDeJogo.add(panelBotoes, BorderLayout.CENTER);
        janelaFimDeJogo.setLocationRelativeTo(null); // Centraliza a janela
        janelaFimDeJogo.setVisible(true);
    }
}
