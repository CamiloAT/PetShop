package co.edu.uptc.PetShop.service;

import java.util.List;

import co.edu.uptc.PetShop.model.Pet;

public interface PetService {
    List<Pet> getPetsByCategory(String category);

    Pet getPetById(Long id);

    Pet createPet(Pet pet);

    Pet updatePet(Long id, Pet pet);

    void deletePet(Long id);

    
}