package javaCurso2024;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

@SuppressWarnings("serial")
public class JogoCobrinha extends JPanel implements ActionListener {
    private static final int LARGURA_TELA = 500;
    private static final int ALTURA_TELA = 500;
    private static final int TAMANHO_BLOCO = 25;
    private static final int UNIDADES = (LARGURA_TELA * ALTURA_TELA) / (TAMANHO_BLOCO * TAMANHO_BLOCO);
    private static final int INTERVALO = 200;
    private final int[] eixoX = new int[UNIDADES];
    private final int[] eixoY = new int[UNIDADES];
    private int corpoCobra = 6;
    private int blocosComidos = 0;
    private int blocoX;
    private int blocoY;
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
        setBackground(Color.white);
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
			g.fillOval(blocoX, blocoY, TAMANHO_BLOCO, TAMANHO_BLOCO);

			for (int i = 0; i < corpoCobra; i++) {
				if (i == 0) {
					g.setColor(Color.green);
					g.fillRect(eixoX[0], eixoY[0], TAMANHO_BLOCO, TAMANHO_BLOCO);
				} else {
					g.setColor(new Color(45, 180, 0));
					g.fillRect(eixoX[i], eixoY[i], TAMANHO_BLOCO, TAMANHO_BLOCO);
				}
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
		blocoX = random.nextInt(LARGURA_TELA / TAMANHO_BLOCO) * TAMANHO_BLOCO;
		blocoY = random.nextInt(ALTURA_TELA / TAMANHO_BLOCO) * TAMANHO_BLOCO;
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
	        JPanel panelBotao = new JPanel();
	        panelBotao.setLayout(new FlowLayout());

	        botaoVoltar = new JButton("Voltar ao Menu Principal");
	        botaoVoltar.setPreferredSize(new Dimension(200, 30));
	        botaoVoltar.addActionListener(e -> {
	            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(botaoVoltar); // Obtém a janela atual
	            frame.setVisible(false); // Oculta a janela do jogo
	            // Torna a janela principal visível
	            janelaPrincipal.setVisible(true); // Use a referência armazenada
	        });

	        panelBotao.add(botaoVoltar);
	        add(panelBotao, BorderLayout.SOUTH);
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
		if (eixoX[0] == blocoX && eixoY[0] == blocoY) {
			corpoCobra++;
			blocosComidos++;
			criarBloco();
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
