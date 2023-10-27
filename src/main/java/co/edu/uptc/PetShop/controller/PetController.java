package co.edu.uptc.PetShop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

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
import co.edu.uptc.PetShop.service.impl.PetServiceImpl;

@RequestMapping("/pets")
@RestController
@Validated
public class PetController {
    @Autowired
    private PetService petService;

    private PetRepository petRepository;

    @PostMapping("save")
    public ResponseEntity<Pet> savePet(@RequestBody Pet pet) {
		Pet newPet = this.petService.savePet(pet);
		return ResponseEntity.ok(newPet);
	}

    @PutMapping("update/{id}")
    public void updatePet(@PathVariable Long id, @RequestBody Pet pet) {
        petService.updatePet(id, pet);
    }
   @GetMapping("/list")
   public List<Pet> getPets(@RequestParam("category") String category){
	   return petService.getPets(category);
   }

    @DeleteMapping("delete/{id}")
    public void deletePet(@PathVariable Long id) {
        petService.deletePet(id);
    }
    @GetMapping("show/{id}")
    public String showPetDetails(@PathVariable Long id) {
        String petDetails = petService.showPetDetails(id);
        return petDetails;
    }
}

