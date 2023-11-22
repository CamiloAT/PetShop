package co.edu.uptc.PetShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.uptc.PetShop.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {

	List<Pet> getByCategory(String category);

}
