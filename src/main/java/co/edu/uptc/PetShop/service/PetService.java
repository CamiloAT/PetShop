package co.edu.uptc.PetShop.service;

import java.util.List;

import co.edu.uptc.PetShop.model.Pet;

public interface PetService {

   List<Pet> getPets(String category);

    void deletePet(Long id);

   
	Pet savePet(Pet pet);
}