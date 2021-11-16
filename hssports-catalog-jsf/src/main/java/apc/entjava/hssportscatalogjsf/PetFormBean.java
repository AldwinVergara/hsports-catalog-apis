package apc.entjava.hssportscatalogjsf;

import apc.entjava.hssportscatalogejb.Pet;
import apc.entjava.hssportscatalogejb.PetEntity;
import apc.entjava.hssportscatalogejb.PetLocal;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@RequestScoped
@Named
public class PetFormBean implements Serializable {

	@Inject
	private PetLocal petBean;

	private PetEntity pet = new PetEntity();

	private List<PetEntity> pets = new ArrayList<>();

	private String searchText;

	private String sortText;

	private List<PetEntity> freePets = new ArrayList<>();

	public void searchByName() {
		this.pets = this.petBean.searchByName(this.searchText);
	}

	public void sortByType() { this.pets = this.petBean.sortByType(this.sortText); }

	public String addPet() {

		this.petBean.addPet(new PetEntity(this.pet.getTypeOfAnimal(), this.pet.getName(), this.pet.getBreed(),
				this.pet.getColor(), this.pet.getBehavior(), this.pet.getAvailableDate()));

		return "list?faces-redirect=true";
	}

	@PostConstruct
	public void init() {
		this.pets = this.petBean.getPets();
		this.freePets = this.petBean.getFreePets();
	}

	public PetLocal getPetBean() {
		return petBean;
	}

	public void setPetBean(PetLocal petBean) {
		this.petBean = petBean;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public String getSortText() {
		return sortText;
	}

	public void setSortText(String sortText) {
		this.sortText = sortText;
	}

	public PetEntity getPet() {
		return pet;
	}

	public void setPet(PetEntity pet) {
		this.pet = pet;
	}

	public List<PetEntity> getPets() {
		return pets;
	}

	public void setPets(List<PetEntity> pets) {
		this.pets = pets;
	}

	public List<PetEntity> getFreePets() {
		return freePets;
	}

	public void setFreePets(List<PetEntity> freePets) {
		this.freePets = freePets;
	}
}
