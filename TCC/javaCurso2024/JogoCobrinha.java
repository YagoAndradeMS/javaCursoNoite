package javaCurso2024;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

@SuppressWarnings("serial")
public class JogoCobrinha extends JPanel implements ActionListener {
    private static final int LARGURA_TELA = 500;
    private static final int ALTURA_TELA = 500;
    private static final int TAMANHO_BLOCO = 25;
    private static final int UNIDADES = (LARGURA_TELA * ALTURA_TELA) / (TAMANHO_BLOCO * TAMANHO_BLOCO);
    private static int INTERVALO = 300;

    private final int[] eixoX = new int[UNIDADES];
    private final int[] eixoY = new int[UNIDADES];
    private int corpoCobra = 3;
    private int blocosComidos = 0;
    private int comidaX;
    private int comidaY;

    private char direcao = 'D'; // C - Cima, B - Baixo, E - Esquerda, D - Direita
    private boolean estaRodando = false;
    private Timer timer;
    private Random random;
    private JButton botaoVoltar;
    private JFrame janelaPrincipal;

    public JogoCobrinha(JFrame janelaPrincipal) {
        this.janelaPrincipal = janelaPrincipal; // Armazenar a referência

        random = new Random();
        setPreferredSize(new Dimension(LARGURA_TELA, ALTURA_TELA));
        setBackground(Color.BLUE);
        setFocusable(true);
        addKeyListener(new LeitorDeTeclasAdapter());

        setLayout(new BorderLayout()); // Para usar coordenadas absolutas
        iniciarJogo();
    }

    public void iniciarJogo() {
        criarBloco();
        estaRodando = true;
        timer = new Timer(INTERVALO, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        desenharTela(g);
    }

    public void desenharTela(Graphics g) {
        if (estaRodando) {
            g.setColor(Color.red);
            g.fillOval(comidaX, comidaY, TAMANHO_BLOCO, TAMANHO_BLOCO); // Desenho da comida como círculo vermelho

            for (int i = 0; i < corpoCobra; i++) {
                if (i == 0) {
                    g.setColor(new Color(34, 139, 34)); // Cabeça da cobra (verde escuro)
                } else {
                    g.setColor(new Color(50, 205, 50)); // Corpo da cobra (verde claro)
                }
                g.fillRoundRect(eixoX[i], eixoY[i], TAMANHO_BLOCO, TAMANHO_BLOCO, 10, 10); // Segmentos da cobra
                                                                                             // arredondados

            }
            g.setColor(Color.red);
            g.setFont(new Font("Ink Free", Font.BOLD, 40));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Pontos: " + blocosComidos,
                    (LARGURA_TELA - metrics.stringWidth("Pontos: " + blocosComidos)) / 2, g.getFont().getSize());
        } else {
            fimDeJogo(g);
        }
    }

    private void criarBloco() {
        comidaX = random.nextInt(LARGURA_TELA / TAMANHO_BLOCO) * TAMANHO_BLOCO;
        comidaY = random.nextInt(ALTURA_TELA / TAMANHO_BLOCO) * TAMANHO_BLOCO;
    }

    public void fimDeJogo(Graphics g) {
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics fontePontuacao = getFontMetrics(g.getFont());
        g.drawString("Pontos: " + blocosComidos,
                (LARGURA_TELA - fontePontuacao.stringWidth("Pontos: " + blocosComidos)) / 2, g.getFont().getSize());
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 75));
        FontMetrics fonteFinal = getFontMetrics(g.getFont());
        voltarMenu();
        g.drawString("Fim do Jogo", (LARGURA_TELA - fonteFinal.stringWidth("Fim do Jogo")) / 2, ALTURA_TELA / 2);
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
            revalidate();
            repaint();
        }
    }

    private void reiniciarJogo() {
        corpoCobra = 3;
        blocosComidos = 0;
        direcao = 'D';
        iniciarJogo();

        // Definir a posição inicial da cobra
        for (int i = 0; i < corpoCobra; i++) {
            eixoX[i] = 100 - i * TAMANHO_BLOCO; // Posição inicial no eixo X
            eixoY[i] = 100; // Posição inicial no eixo Y
        }

        criarBloco(); // Recriar o bloco de comida
        estaRodando = true;
        timer.restart(); // Reiniciar o timer
    }

    private void removerBotoes() {
        if (botaoVoltar != null) {
            remove(botaoVoltar.getParent()); // Remove o painel de botões
            botaoVoltar = null; // Reseta o botão para que possa ser recriado depois
            revalidate();
            repaint();
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (estaRodando) {
            andar();
            alcancarBloco();
            validarLimites();
        }
        repaint();
    }

    private void andar() {
        for (int i = corpoCobra; i > 0; i--) {
            eixoX[i] = eixoX[i - 1];
            eixoY[i] = eixoY[i - 1];
        }
        switch (direcao) {
            case 'C':
                eixoY[0] = eixoY[0] - TAMANHO_BLOCO;
                break;
            case 'B':
                eixoY[0] = eixoY[0] + TAMANHO_BLOCO;
                break;
            case 'E':
                eixoX[0] = eixoX[0] - TAMANHO_BLOCO;
                break;
            case 'D':
                eixoX[0] = eixoX[0] + TAMANHO_BLOCO;
                break;
        }
    }

    private void alcancarBloco() {
        if (eixoX[0] == comidaX && eixoY[0] == comidaY) {
            corpoCobra++;
            blocosComidos++;
            INTERVALO = -10 ;
            criarBloco();
         //   tocarSom(); // Toca o som ao comer a comida
        }
    }
    
    private void tocarSom() {
        try {
            File arquivo = new File(getClass().getClassLoader().getResource("comer.wav").toURI());
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(arquivo);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private void validarLimites() {
		for (int i = corpoCobra; i > 0; i--) {
			if (eixoX[0] == eixoX[i] && eixoY[0] == eixoY[i]) {
				estaRodando = false;
				break;
			}
		}

		if (eixoX[0] < 0 || eixoX[0] > LARGURA_TELA - TAMANHO_BLOCO || eixoY[0] < 0
				|| eixoY[0] > ALTURA_TELA - TAMANHO_BLOCO) {
			estaRodando = false;
		}

		if (!estaRodando) {
			timer.stop();
		}
	}

	public class LeitorDeTeclasAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				if (direcao != 'D') {
					direcao = 'E';
				}
				break;
			case KeyEvent.VK_RIGHT:
				if (direcao != 'E') {
					direcao = 'D';
				}
				break;
			case KeyEvent.VK_UP:
				if (direcao != 'B') {
					direcao = 'C';
				}
				break;
			case KeyEvent.VK_DOWN:
				if (direcao != 'C') {
					direcao = 'B';
				}
				break;
			}
		}
	}
}