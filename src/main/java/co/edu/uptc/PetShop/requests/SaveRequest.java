package co.edu.uptc.PetShop.requests;

import co.edu.uptc.PetShop.model.Pet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SaveRequest {
	private HttpURLConnection connection;
	private URL url;
	private String message;

	public void connect() {
		try {
			url = new URL("http://localhost:8080/pets/save");
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type", "application/json");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void requestSave(String name, String category) {
		connect();
		try (OutputStream os = connection.getOutputStream()) {
			ObjectMapper objectMapper = new ObjectMapper();
			Pet petToSend = new Pet();
			petToSend.setName(name);
			petToSend.setCategory(category);
			String requestBody = objectMapper.writeValueAsString(petToSend);
			byte[] input = requestBody.getBytes(StandardCharsets.UTF_8);
			os.write(input, 0, input.length);
			String line;
			if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				StringBuilder response = new StringBuilder();
				while ((line = reader.readLine()) != null) {
					response.append(line);
				}
				message = "Mascota guardada exitosamente";
				reader.close();
			} else {
				message = "Algo fallo!";
				throw new Exception("Error en la petición");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getMessage() {
		return message;
	}
}