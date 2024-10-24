package javaCurso2024;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Encurtador extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField inputUrlField;
	private JTextField outputUrlField;
	private JButton shortenButton;

	public Encurtador() {
		// Configurações da Janela
		setTitle("Encurtador de URL - TinyURL");
		setSize(400, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		// Campo de entrada da URL
		JLabel inputLabel = new JLabel("URL Original");
		inputLabel.setBounds(10, 10, 100, 25);
		add(inputLabel);

		inputUrlField = new JTextField();
		inputUrlField.setBounds(120, 10, 250, 25);
		add(inputLabel);

		inputUrlField = new JTextField();
		inputUrlField.setBounds(120, 10, 250, 25);
		add(inputUrlField);

		// Campo de saída da URL encurtada
		JLabel outputLabel = new JLabel("URL Encurtada");
		outputLabel.setBounds(10, 50, 100, 25);
		add(outputLabel);

		outputUrlField = new JTextField();
		outputUrlField.setBounds(120, 50, 250, 25);
		outputUrlField.setEditable(false);
		add(outputUrlField);

		// Botão de encurtar
		shortenButton = new JButton("Encurtar URL");
		shortenButton.setBounds(120, 90, 150, 25);
		add(shortenButton);

		// Ação do botão
		shortenButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String originalUrl = inputUrlField.getText();
				if (!originalUrl.isEmpty()) {
					try {
						String shortUrl = shortenUrl(originalUrl);
						outputUrlField.setText(shortUrl);
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Erri ai encurtar a URL:" + ex.getMessage());
					}
				} else {
					JOptionPane.showMessageDialog(null, "Por favor, insira uma URL válida.");
				}
			}
		});
	}

	// Método para encurtar a URL usando a API do TinyURL sem token
	private String shortenUrl(String longUrl) throws Exception {
		String shortUrl = "";
		try {
			// URL da API TinyURL para encurtar a URL
			String apiUrl = "https://tinyurl.com/api-create.php?url=" + longUrl;
			URL url = new URL(apiUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.connect();

			// Verifica a resposta
			int responseCode = connection.getResponseCode();
			if (responseCode == 200) {
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				shortUrl = in.readLine(); // O TinyURL retorna a URL encurtada na primeira linha
				in.close();
			} else {
				shortUrl = "Erro ao encurtar a URL! Código de resposta: " + responseCode;
			}
		} catch (Exception e) {
			shortUrl = "Erro" + e.getMessage();
		}
		return shortUrl;
	}

	// Método principal para executar a aplicação
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				Encurtador app = new Encurtador();
				app.setVisible(true);
			}
		});
	}
}
