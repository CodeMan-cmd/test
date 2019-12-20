package dao;

import java.util.List;

import entity.Pet;
import entity.PetOwner;

public interface PetDao {

	List<Pet> selectAllPet();

	List<PetOwner> selectAllPetOwner();

	List<entity.PetStore> selectAllPetStore();

}
