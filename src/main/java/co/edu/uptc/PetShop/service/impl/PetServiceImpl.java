package co.edu.uptc.PetShop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uptc.PetShop.model.Pet;
import co.edu.uptc.PetShop.repository.PetRepository;
import co.edu.uptc.PetShop.service.PetService;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepository petRepository;

    @Override
    public List<Pet> getPetsByCategory(String category) {
        return petRepository.getByCategory(category);
    }

    @Override
    public Pet getPetById(Long id) {
        Optional<Pet> pet = petRepository.findById(id);
        return pet.orElse(null);
    }

    @Override
    public Pet createPet(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public Pet updatePet(Long id, Pet pet) {
        if (petRepository.existsById(id)) {
            pet.setId(id);
            return petRepository.save(pet);
        }
        return null; // Manejar el caso en el que la mascota no exista
    }

    @Override
    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }

}
