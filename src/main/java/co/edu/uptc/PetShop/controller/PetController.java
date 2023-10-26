package co.edu.uptc.PetShop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
=======
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
>>>>>>> bb364983931f49fa9d9b6e1628a4e1639f5d5f5d
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uptc.PetShop.model.Pet;
import co.edu.uptc.PetShop.repository.PetRepository;
import co.edu.uptc.PetShop.service.PetService;
<<<<<<< HEAD
import jakarta.persistence.Entity;
import jakarta.persistence.EntityNotFoundException;
=======
import co.edu.uptc.PetShop.service.impl.PetServiceImpl;
import jakarta.validation.Valid;
>>>>>>> bb364983931f49fa9d9b6e1628a4e1639f5d5f5d

@RequestMapping("/pets")
@RestController
@Validated
public class PetController {
    @Autowired
    private PetService petService;
<<<<<<< HEAD
    private PetRepository petRepository;
=======
    
    @PostMapping("save")
    public ResponseEntity<Pet> savePet(@Valid @RequestBody Pet pet) {
		Pet newPet = this.petService.savePet(pet);
		return ResponseEntity.ok(newPet);
	}
>>>>>>> bb364983931f49fa9d9b6e1628a4e1639f5d5f5d

   
    @PutMapping("update/{id}")
    public Pet updatePet(@PathVariable Long id, @RequestBody Pet pet) {
       return petService.updatePet(id, pet);
    }
}

