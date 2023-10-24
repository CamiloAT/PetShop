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

   @GetMapping("/list")
   public List<Pet> getPets(@RequestParam("category") String category){
	   return petService.getPets(category);
   }
}
