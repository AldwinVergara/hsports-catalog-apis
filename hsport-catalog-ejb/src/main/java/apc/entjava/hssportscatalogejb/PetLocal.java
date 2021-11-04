package apc.entjava.hssportscatalogejb;

import javax.ejb.Local;
import java.util.List;

@Local
public interface PetLocal {

	public List<PetEntity> getPets();
	
	public void addPet(PetEntity pet);

	public void deletePet(PetEntity pet);

	public void updatePet(PetEntity pet);

	PetEntity findPet(Long petId);

	public List<PetEntity> searchByName(String name);

	public List<PetEntity> sortByType(String name);
}
