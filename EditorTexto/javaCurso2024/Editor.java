package javaCurso2024;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Editor extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8821864588141049696L;
	// Componentes principais
	JTextArea textArea;
	JFrame frame;

	// Construindo o editor
	public Editor() {
		// Construindo o layout
		frame = new JFrame("Bloco de Notas - Java");

		// Configurar a área de texto
		textArea = new JTextArea();
		textArea.setFont(new Font("Arial", Font.PLAIN, 16));
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		// Menu superior
		JMenuBar menuBar = new JMenuBar();

		// Menu "Arquivo" com opções Abrir, Salvar e sair
		JMenu fileMenu = new JMenu("Arquivo");
		JMenuItem openItem = new JMenuItem("Abrir");
		JMenuItem saveItem = new JMenuItem("Salvar");
		JMenuItem exitItem = new JMenuItem("Sair");

		openItem.addActionListener(this);
		saveItem.addActionListener(this);
		;
		exitItem.addActionListener(this);

		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.addSeparator(); // Separador
		fileMenu.add(exitItem);

		// Menu "Edita" com opções Copiar, Colar e Cortar
		JMenu editMenu = new JMenu("Editar");
		JMenuItem cutItem = new JMenuItem("Cortar");
		JMenuItem copyItem = new JMenuItem("Copiar");
		JMenuItem pasteItem = new JMenuItem("Colar");

		cutItem.addActionListener(this);
		copyItem.addActionListener(this);
		pasteItem.addActionListener(this);

		editMenu.add(cutItem);
		editMenu.add(copyItem);
		editMenu.add(pasteItem);

		// Adicionar menus á barra de menu
		menuBar.add(fileMenu);
		menuBar.add(editMenu);

		// Adicionar a barra de menu ao frame
		frame.setJMenuBar(menuBar);
		frame.add(scrollPane);

		// Configurações finais da janela
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		switch (command) {
		case "Abrir":
			openFile();
			break;
		case "Salvar":
			saveFile();
			break;
		case "Sair":
			System.exit(0);
			break;
		case "Cortar":
			textArea.copy();
			break;
		case "Copiar":
			textArea.copy();
			break;
		case "Colar":
			textArea.paste();
			break;

		}
	}
	
	// Método para abrir arquivo
	private void openFile() {
		JFileChooser fileChooser = new JFileChooser();
		int option = fileChooser.showOpenDialog(this);
		if (option == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			try (BufferedReader br = new BufferedReader(new FileReader(file))) {
				textArea.read(br,  null);
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(this, "Erro ao abrir o arquivo", "Erro" , JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	// Método para salvar o arquivo
	private void saveFile() {
		JFileChooser fileChooser = new JFileChooser();
		int option = fileChooser.showSaveDialog(this);
		if (option == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
				textArea.write(bw);
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(this, "Erro ao salvar o arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	// Método principal para iniciar o programa
	public static void main(String[] args) {
		SwingUtilities.invokeLater(Editor::new);
	}
}
