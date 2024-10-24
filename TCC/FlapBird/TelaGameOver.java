package FlapBird;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class TelaGameOver {

    private int score;
    private int screenWidth;
    private int screenHeight;

    public TelaGameOver(int score, int screenWidth, int screenHeight) {
        this.score = score;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
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

    // Método para voltar ao menu (opcional, depende da sua lógica)
    public void voltarMenu() {
        // Lógica para voltar ao menu principal
    }
}
