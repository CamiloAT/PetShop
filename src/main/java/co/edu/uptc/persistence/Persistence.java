package co.edu.uptc.persistence;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

import co.edu.uptc.PetShop.model.Pet;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;


public class Persistence {

    public ArrayList<Pet> readMyFile(String file) throws FileNotFoundException {
        JsonReader reader = new Gson().newJsonReader(new FileReader(file));
        Type userListType = new TypeToken<ArrayList<Pet>>() {}.getType();
        ArrayList<Pet> pets = new Gson().fromJson(reader, userListType);
        return pets;
    }
}
