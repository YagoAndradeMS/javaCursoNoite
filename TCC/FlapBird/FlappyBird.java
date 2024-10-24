package FlapBird;
import java.util.ArrayList;
import java.util.Random;

public class FlappyBird implements Jogo {

    private boolean gameOver = false;
    private int score = 0;
    public double ground_offset = 0;
    public double background_offset = 0;
    public double gvx = 100;  // Velocidade do chão
    public double bvx = 50;   // Velocidade do fundo (geralmente mais lento que o chão)
    
    public Passaro passaro; // Cria o passaro
    
    public ArrayList<Cano> canos = new ArrayList<>();
    public Random gerador = new Random();
    public Timer timer_cano;
            
    public FlappyBird() {
        passaro = new Passaro(35, (getLargura() -112)/2 + 24/2);
        timer_cano  = new Timer(3, true, addCano());
        addCano().executa();
    }

    private Acao addCano() {
        return new Acao() {
            public void executa() {
                canos.add(new Cano(getLargura() + 10, gerador.nextInt(getAltura() - 112 - Cano.HOLESIZE), -gvx));
            }
        };
    }

    public String getTitulo() {
        return "Flappy Bird";
    }

    public int getLargura() {
        return 384;
    }

    public int getAltura() {
        return 502;
    }

    public void tecla(String tecla) {
        if (tecla.equals(" ")) {
            passaro.flap();
        }
    }

    public void tique(java.util.Set<String> teclas, double dt) {
        if (!gameOver) {
            // Atualiza o offset do chão
            ground_offset += dt * gvx;
            ground_offset = ground_offset % 308;  // Mantém o offset do chão dentro de 308px
            
            timer_cano.tique(dt);
            
            // Atualiza o offset do fundo
            background_offset += dt * bvx;
            background_offset = background_offset % 288;  // Mantém o offset do fundo dentro de 288px
            
            passaro.atualiza(dt); // Faz o passaro cair
            
            // Checar colisão com chão ou teto
            if (passaro.y + 24 >= getAltura() - 112 || passaro.y <= 0) {
                gameOver = true;
            }

            // Verificar colisões e ultrapassagem dos canos
            ArrayList<Cano> canosRemover = new ArrayList<>();  // Lista temporária para canos que saem da tela
            for (Cano cano : canos) {
                cano.atualiza(dt);

                // Verificar colisão com canos
                if (passaro.box.intersecao(cano.boxcima) != 0 || passaro.box.intersecao(cano.boxbaixo) != 0) {
                    gameOver = true; // Game Over
                }
                
                // Verificar se o pássaro passou o cano (incrementar score)
                if (!cano.isPassed() && passaro.x > cano.x + cano.largura) {
                    score++;  // Incrementa 1 ponto
                    cano.setPassed(true);  // Marca que o cano foi ultrapassado
                }

                // Remover canos fora da tela
                if (cano.x < -60) {
                    canosRemover.add(cano);
                }
            }

            // Remove os canos que saíram da tela
            canos.removeAll(canosRemover);
        }
    }

    public void desenhar(Tela t) {
        // Fundo se movendo
        t.imagem("Flap.png", 0, 0, 288, 512, 0, -background_offset, 0);
        t.imagem("Flap.png", 0, 0, 288, 512, 0, 288 - background_offset, 0);
        t.imagem("Flap.png", 0, 0, 288, 512, 0, 288 * 2 - background_offset, 0);

        if (gameOver) {
            TelaGameOver gameOverScreen = new TelaGameOver(score, getLargura(), getAltura());
            gameOverScreen.drawGameOver(t.g);  // Passa o Graphics diretamente
        } else {
            // Desenha os elementos do jogo normalmente

            // Desenha os canos
            for (Cano cano : canos) {
                cano.desenha(t);
            }

            // Chão se movendo
            t.imagem("Flap.png", 292, 0, 308, 112, 0, -ground_offset, getAltura() - 112);
            t.imagem("Flap.png", 292, 0, 308, 112, 0, 308 - ground_offset, getAltura() - 112);
            t.imagem("Flap.png", 292, 0, 308, 112, 0, 308 * 2 - ground_offset, getAltura() - 112);

            // Passarinho
            passaro.desenhar(t);

            // **Desenha o score no canto superior direito**
            t.texto("Score: " + score, getLargura() - 100, 50, 20, Cor.BRANCO);  // Ajuste a posição e tamanho do texto conforme necessário
        }
    }


    public static void main(String[] args) {
        roda();
    }

    private static void roda() {
        new Motor(new FlappyBird());
    }
}
