package co.edu.uptc.PetShop.service;

import java.util.List;
import java.util.Optional;

import co.edu.uptc.PetShop.model.Pet;

public interface PetService {
   
    Pet save(Pet pet);
    Pet updatePet(Long id, Pet pet);
}