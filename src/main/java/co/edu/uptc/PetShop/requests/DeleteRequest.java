package co.edu.uptc.PetShop.requests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DeleteRequest {
    private URL url;
    private String message; 

    public DeleteRequest() {
        message = "Ocurrio un error";
    }

    public String requestDelete(String idPet){
        try {
            url = new URL ("http://localhost:8080/pets/" + idPet);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("DELETE");
            int reponseCode = connection.getResponseCode();

            if (reponseCode == HttpURLConnection.HTTP_OK){
                message = "Exitoso";
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return message;
    } 

    public void setMessage(){
        message = "Ocurrio un error";
    }
}
