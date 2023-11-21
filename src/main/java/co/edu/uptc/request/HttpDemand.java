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
	HttpURLConnection connection;
	URL url;

	public void connect() {
		try {
			url = new URL("http://localhost:8080/pets/save");
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type", "application/json");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String requestSave(Pet petToSend) throws Exception {
		connect();
		// Convierte el objeto Pet a formato JSON
		ObjectMapper objectMapper = new ObjectMapper();
		petToSend.setId((long) 1);
		petToSend.setName("Darla");
		petToSend.setCategory("perro");
		String requestBody = objectMapper.writeValueAsString(petToSend);
		// Escribe los datos en el cuerpo de la solicitud
		try (OutputStream os = connection.getOutputStream(); ) {
			byte[] input = requestBody.getBytes(StandardCharsets.UTF_8);
			os.write(input, 0, input.length);
		}
		// Obtiene el código de respuesta
		int responseCode = connection.getResponseCode();
		System.out.println("Código de respuesta: " + responseCode);
		String line;
		// Lee la respuesta del servidor
		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
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

	public static void main(String[] args) throws Exception {
		HttpDemand htt= new  HttpDemand();
		htt.requestSave(new Pet());
	}
}