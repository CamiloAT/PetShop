package co.edu.uptc.PetShop.requests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import co.edu.uptc.PetShop.model.Pet;
import co.edu.uptc.persistence.Persistence;

public class ListRequest {

	private List<Pet> pets;
	private Persistence jsonConverter;
	private String category;
	private URL url;
	
	public ListRequest(String category) {
		this.category=category;
		jsonConverter = new Persistence();
		this.initPetition();
	}
	
	private void initPetition() {
		try {
			url = new URL("http://localhost:8080/pets/list?category="+this.category);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod ("GET");
			int responseCode = connection.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				StringBuilder response = new StringBuilder();
				String line;
				while ((line = reader.readLine()) != null) {
					response.append(line);
				}
				reader.close();
				String petString = response.toString();
				pets = jsonConverter.convertJsonToPetList(petString);
			} else {
				throw new Exception("Error en la peticion");
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Pet> getPets() {
		return pets;
	}
}

