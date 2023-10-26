package co.edu.uptc.PetShop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uptc.PetShop.model.Pet;
import co.edu.uptc.PetShop.repository.PetRepository;
import co.edu.uptc.PetShop.service.PetService;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/pets")
public class PetController {
    @Autowired
    private PetService petService;
    private PetRepository petRepository;

   
    @PutMapping("update/{id}")
    public Pet updatePet(@PathVariable Long id, @RequestBody Pet pet) {
       return petService.updatePet(id, pet);
    }
}

