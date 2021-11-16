package apc.entjava.hssportscatalogejb;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Singleton
@LocalBean
public class Pet implements PetLocal {
	@PersistenceContext
	private EntityManager entityManager;

    public Pet() {
    }

	@Override
	public List<PetEntity> getPets() {
		return this.entityManager.createQuery("select c from PetEntity c", PetEntity.class).getResultList();
	}

	@Override
	public void addPet(PetEntity pet) {
		this.entityManager.persist(pet);
	}

	@Override
	public void deletePet(PetEntity pet) {
		this.entityManager.remove(this.entityManager.contains(pet) ? pet:this.entityManager.merge(pet));
	}

	@Override
	public void updatePet(PetEntity pet) {
		this.entityManager.createQuery("update PetEntity c set c.typeOfAnimal=:petTypeOfAnimal, c.name=:petName, c.breed=:petBreed, c.color=:petColor, c.availableDate=:petDate, c.behavior=:petBehavior where c.petId=:id")
				.setParameter("id", pet.getPetId())
				.setParameter("petTypeOfAnimal", pet.getTypeOfAnimal())
				.setParameter("petName", pet.getName())
				.setParameter("petBreed", pet.getBreed())
				.setParameter("petColor", pet.getColor())
				.setParameter("petDate",pet.getAvailableDate())
				.setParameter("petBehavior",pet.getBehavior())
				.executeUpdate();
	}


	@Override
	public PetEntity findPet(Long petId) {
		return this.entityManager.find(PetEntity.class, petId);
	}

	@Override
	public List<PetEntity> searchByName(String name) {
		return this.entityManager.createQuery("select c from PetEntity c " +
				" where c.name like :name", PetEntity.class).setParameter("name", "%" + name + "%").getResultList();
	}

	@Override
	public List<PetEntity> sortByType(String name) {
		return this.entityManager.createQuery("select c from PetEntity c" +
				" where c.typeOfAnimal like :typeOfAnimal", PetEntity.class).setParameter("typeOfAnimal",name).getResultList();
	}
}
