package javaCurso2024;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ConsultarCEP {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite o CEP: ");
            String cep = scanner.nextLine().trim();

            if (!cep.matches("\\d{8}")) {
                System.out.println("CEP inválido. Deve conter 8 dígitos numéricos.");
                return;
            }

            String jsonResponse = buscarCep(cep);
            if (jsonResponse != null && !jsonResponse.isEmpty()) {
                formatarResposta(jsonResponse);
            } else {
                System.out.println("Nenhuma resposta recebida. Verifique se o CEP está correto.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao executar o programa: " + e.getMessage());
        }
    }

    public static String buscarCep(String cep) {
        String urlString = "https://viacep.com.br/ws/" + cep + "/json/";
        try {
            @SuppressWarnings("deprecation")
			URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000); // Timeout de conexão
            connection.setReadTimeout(5000);    // Timeout de leitura

            int status = connection.getResponseCode();
            if (status != 200) {
                System.out.println("Erro na consulta. Código HTTP: " + status);
                return null;
            }

            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                return response.toString();
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar o CEP: " + e.getMessage());
            return null;
        }
    }

    public static void formatarResposta(String jsonResponse) {
        // Exibe o JSON bruto (para entender o que está retornando)
        System.out.println("JSON bruto recebido: " + jsonResponse);

        if (jsonResponse.contains("\"erro\": true")) {
            System.out.println("CEP não encontrado.");
            return;
        }

        // Removendo a ideia de "extrair valor", vamos buscar diretamente no JSON usando substring.
        String cep = pegarCampoDoJson(jsonResponse, "cep");
        String logradouro = pegarCampoDoJson(jsonResponse, "logradouro");
        String bairro = pegarCampoDoJson(jsonResponse, "bairro");
        String localidade = pegarCampoDoJson(jsonResponse, "localidade");
        String uf = pegarCampoDoJson(jsonResponse, "uf");

        // Imprimir informações formatadas
        System.out.println("Informações do Endereço:");
        System.out.println("CEP: " + (cep.isEmpty() ? "Não disponível" : cep));
        System.out.println("Logradouro: " + (logradouro.isEmpty() ? "Não disponível" : logradouro));
        System.out.println("Bairro: " + (bairro.isEmpty() ? "Não disponível" : bairro));
        System.out.println("Cidade: " + (localidade.isEmpty() ? "Não disponível" : localidade));
        System.out.println("Estado: " + (uf.isEmpty() ? "Não disponível" : uf));
    }

    // Método que busca o valor de um campo no JSON
    public static String pegarCampoDoJson(String jsonResponse, String campo) {
        try {
            String busca = "\"" + campo + "\":\"";
            int inicio = jsonResponse.indexOf(busca);
            if (inicio == -1) return ""; // Se não encontrar o campo
            inicio += busca.length();
            int fim = jsonResponse.indexOf("\"", inicio);
            return jsonResponse.substring(inicio, fim);
        } catch (Exception e) {
            return ""; // Em caso de erro, retorna string vazia
        }
    }
}
