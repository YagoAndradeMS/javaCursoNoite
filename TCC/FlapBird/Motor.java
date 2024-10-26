package FlapBird;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.util.TreeSet;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Motor extends JPanel {
    private Jogo jogo;
    private BufferStrategy strategy;
    private TreeSet<String> keySet = new TreeSet<>();
    private Canvas canvas;

    public Motor(Jogo j) {
        this.jogo = j;

        // Configurando o Canvas
        this.setLayout(new BorderLayout());
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(jogo.getLargura(), jogo.getAltura()));
        this.add(canvas, BorderLayout.CENTER);

        // Configurando KeyListener para o Canvas
        canvas.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent evt) {
                keySet.add(keyString(evt));
            }

            @Override
            public void keyReleased(KeyEvent evt) {
                keySet.remove(keyString(evt));
            }

            @Override
            public void keyTyped(KeyEvent evt) {
                jogo.tecla(keyString(evt));
            }
        });

        // Inicializando o loop principal após o Canvas estar visível
        canvas.addHierarchyListener(new HierarchyListener() {
            @Override
            public void hierarchyChanged(HierarchyEvent e) {
                if ((e.getChangeFlags() & HierarchyEvent.DISPLAYABILITY_CHANGED) != 0 && canvas.isDisplayable()) {
                    canvas.createBufferStrategy(2);
                    strategy = canvas.getBufferStrategy();
                    canvas.requestFocus();
                    mainLoop();
                }
            }
        });
    }

    private void mainLoop() {
        Timer t = new Timer(5, new ActionListener() {
            public long t0;

            @Override
            public void actionPerformed(ActionEvent evt) {
                long t1 = System.currentTimeMillis();
                if (t0 == 0)
                    t0 = t1;
                if (t1 > t0) {
                    double dt = (t1 - t0) / 1000.0;
                    t0 = t1;
                    jogo.tique(keySet, dt);

                    Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
                    g.setColor(Color.black);
                    g.fillRect(0, 0, jogo.getLargura(), jogo.getAltura());
                    jogo.desenhar(new Tela(g));
                    strategy.show();
                }
            }
        });
        t.start();
    }

    private static String keyString(KeyEvent evt) {
        if (evt.getKeyChar() != KeyEvent.CHAR_UNDEFINED) {
            return String.valueOf(evt.getKeyChar()).toLowerCase();
        } else {
            switch (evt.getKeyCode()) {
                case KeyEvent.VK_ALT: return "alt";
                case KeyEvent.VK_CONTROL: return "control";
                case KeyEvent.VK_SHIFT: return "shift";
                case KeyEvent.VK_LEFT: return "left";
                case KeyEvent.VK_RIGHT: return "right";
                case KeyEvent.VK_UP: return "up";
                case KeyEvent.VK_DOWN: return "down";
                case KeyEvent.VK_ENTER: return "enter";
                case KeyEvent.VK_DELETE: return "delete";
                case KeyEvent.VK_TAB: return "tab";
                case KeyEvent.VK_WINDOWS: return "windows";
                case KeyEvent.VK_BACK_SPACE: return "backspace";
                case KeyEvent.VK_ALT_GRAPH: return "altgr";
                case KeyEvent.VK_F1: return "F1";
                case KeyEvent.VK_F2: return "F2";
                case KeyEvent.VK_F3: return "F3";
                case KeyEvent.VK_F4: return "F4";
                case KeyEvent.VK_F5: return "F5";
                case KeyEvent.VK_F6: return "F6";
                case KeyEvent.VK_F7: return "F7";
                case KeyEvent.VK_F8: return "F8";
                case KeyEvent.VK_F9: return "F9";
                case KeyEvent.VK_F10: return "F10";
                case KeyEvent.VK_F11: return "F11";
                case KeyEvent.VK_F12: return "F12";
                default: return "";
            }
        }
    }
}
