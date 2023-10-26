package co.edu.uptc.PetShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import co.edu.uptc.PetShop.service.PetService;
import co.edu.uptc.PetShop.service.impl.PetServiceImpl;

@RequestMapping("/pets")
@RestController
@Validated
public class PetController {
    @Autowired
    private PetService petService;

   @GetMapping("/list")
   public List<Pet> getPets(@RequestParam("category") String category){
	   return petService.getPets(category);
   }
    @PostMapping("save")
    public ResponseEntity<Pet> savePet(@RequestBody Pet pet) {
        Pet newPet = this.petService.savePet(pet);
        return ResponseEntity.ok(newPet);
    }

    @DeleteMapping("delete/{id}")
    public void deletePet(@PathVariable Long id) {
        petService.deletePet(id);
    }
}
