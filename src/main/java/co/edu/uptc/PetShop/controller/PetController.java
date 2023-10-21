package co.edu.uptc.PetShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/pets")
public class PetController {
    @Autowired
    private PetService petService;

    //Para obtener por categoría
    @GetMapping("/by-category")
    public List<Pet> getPetsByCategory(@RequestParam String category) {
        return this.petService.getPetsByCategory(category);
    }

    //Para crear
    @PostMapping("/")
    public Pet createPet(@RequestBody Pet pet) {
        return this.petService.createPet(pet);
    }

    //Para actualizar por ID
    @PutMapping("/{id}")
    public Pet updatePet(@PathVariable Long id, @RequestBody Pet pet) {
        return this.petService.updatePet(id, pet);
    }

    //Para listar por Categoría
    @GetMapping("/category/{category}")
    public List<Pet> listPetsByCategory(@PathVariable String category) {
        return null;
    }

    //Borrar alguna mascota que necesitemos
    @DeleteMapping("/{id}")
    public void deletePet(@PathVariable Long id) {
        
    }
}
