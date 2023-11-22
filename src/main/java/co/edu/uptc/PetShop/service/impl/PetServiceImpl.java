package co.edu.uptc.PetShop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uptc.PetShop.model.Pet;
import co.edu.uptc.PetShop.repository.PetRepository;
import co.edu.uptc.PetShop.service.PetService;
import jakarta.persistence.EntityNotFoundException;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepository petRepository;


    @Override
    public Pet save(Pet pet) {
        throw new UnsupportedOperationException("Unimplemented method 'savePet'");
    }

    @Override
    public Pet updatePet(Long id, Pet pet) {
        Pet petUpdate = petRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("No se encuentra la mascota"));
        petUpdate.setName(pet.getName());
        petUpdate.setCategory(pet.getCategory());
        return petRepository.save(petUpdate);
    }

	@Override
	public List<Pet> getPets(String category) {
		return petRepository.getByCategory(category);
	}

    @Override
    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }
	@Override
	public Pet savePet(Pet pet) {
		return petRepository.save(pet);
	}

    @Override
    public String showPetDetails(long id) {
        Pet showDetail = petRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("No se encuentra la mascota"));
        return showDetail.getId() + "\n" + showDetail.getName() + "\n" + showDetail.getCategory();
    }


}
