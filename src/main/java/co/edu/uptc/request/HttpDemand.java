package co.edu.uptc.request;

import co.edu.uptc.PetShop.model.Pet;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpDemand {

	public HttpURLConnection connect() {
		URL url;
		HttpURLConnection connection = null;
		try {
			url = new URL("http://localhost:8080/pets/save");
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type", "application/json");
			return connection;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;

	}

	public String requestSave(Pet petToSend) throws Exception {
		// Convierte el objeto Pet a formato JSON
		ObjectMapper objectMapper = new ObjectMapper();
		String requestBody = objectMapper.writeValueAsString(petToSend);
		// Escribe los datos en el cuerpo de la solicitud
		try (OutputStream os = connect().getOutputStream()) {
			byte[] input = requestBody.getBytes(StandardCharsets.UTF_8);
			os.write(input, 0, input.length);
		}
		// Obtiene el código de respuesta
		int responseCode = connect().getResponseCode();
		System.out.println("Código de respuesta: " + responseCode);
		String line;
		// Lee la respuesta del servidor
		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(connect().getInputStream()));
			StringBuilder response = new StringBuilder();
			while ((line = reader.readLine()) != null) {
				response.append(line);
			}
			reader.close();
			System.out.println(response);
		} else {
			throw new Exception("Error en la petición");
		}
		return line;

	}

	public static void main(String[] args) {

	}
}