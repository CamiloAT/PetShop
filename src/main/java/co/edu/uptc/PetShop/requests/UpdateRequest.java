package co.edu.uptc.PetShop.requests;

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

public class UpdateRequest {
    private HttpURLConnection connection;
    private URL url;
    private String message;

    public void connect(Long petId) {
        try {
            url = new URL("http://localhost:8080/pets/update/" + petId.toString());
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");
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

    public void requestUpdate(Long petId, String updatedName, String updatedCategory) {
        connect(petId);

        try (OutputStream os = connection.getOutputStream()) {
            ObjectMapper objectMapper = new ObjectMapper();
            Pet petToUpdate = new Pet();
            petToUpdate.setName(updatedName);
            petToUpdate.setCategory(updatedCategory);

            String requestBody = objectMapper.writeValueAsString(petToUpdate);
            byte[] input = requestBody.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);

            String line;
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                message = "Mascota actualizada exitosamente";
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
