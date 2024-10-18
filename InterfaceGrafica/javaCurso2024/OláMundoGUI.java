package javaCurso2024;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class OláMundoGUI extends JFrame {

	public OláMundoGUI() {
		// Configurando a tela:
		setTitle("Olá Mundo em JAVA"); // Titulo da janela
		setSize(300, 200); // Definindo tamanho da tela.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Criando um botão com estilo HTML
		JButton botao = new JButton("<html><body style='text-align: center; border: solid; padding: 10px; font-size: 16px;'>Clique em Mim</body></html>");

		// Adicionar um Action Listener ao botão
		botao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Exibir um popup com a mensagem "Olá Mundo":
				JOptionPane.showMessageDialog(null, "Olá Mundo!");
			}
		});
		
		// Estilizando o botão (descomente para aplicar)
		// botao.setFont(new Font("Arial", Font.BOLD, 16));
		// botao.setForeground(Color.WHITE);
		// botao.setBackground(Color.BLUE);
		// botao.setFocusPainted(false);
		
		// Adiciona o botão na janela:
		add(botao);
		// Torna a janela visível:
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// Executar a interface gráfica:
		new OláMundoGUI();
	}
}
