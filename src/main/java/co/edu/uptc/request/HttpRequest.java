package co.edu.uptc.request;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class HttpRequest {

    public static void main(String[] args) {
        URL url;

        try {
            url = new URL("http://localhost:8080/pets/list?category=gato");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod ("GET");
            int responseCode = connection.getResponseCode();
            System.out.println("codigo de respuesta " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                System.out.println(response);
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
}