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
	public Pet savePet(Pet pet) {
		return petRepository.save(pet);
	}

   
}
