package co.edu.uptc.PetShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uptc.PetShop.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> getByCategory(String category);
    
}
