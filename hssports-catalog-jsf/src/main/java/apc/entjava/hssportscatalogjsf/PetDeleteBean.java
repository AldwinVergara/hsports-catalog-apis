package apc.entjava.hssportscatalogjsf;

import apc.entjava.hssportscatalogejb.CatalogLocal;
import apc.entjava.hssportscatalogejb.PetEntity;
import apc.entjava.hssportscatalogejb.PetLocal;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Named
@ConversationScoped
public class PetDeleteBean implements Serializable{

	private long petId;

	private PetEntity pet;

	@Inject
	private PetFormBean petFormBean;

	@Inject
	private PetLocal petBean;

	@Inject
	private Conversation conversation;

	public void fetchPet() {
		conversation.begin();
		this.pet=petBean.findPet(this.petId);
	}

	public String removePet() {
		this.petBean.deletePet(this.pet);
		conversation.end();
		return "list?faces-redirect=true";
	}

	public String updatePet(){
		this.petBean.updatePet(this.pet);
		conversation.end();
		return "list?faces-redirect=true";
	}

	public long getPetId() {
		return petId;
	}

	public void setPetId(long petId) {
		this.petId = petId;
	}

	public PetEntity getPet() {
		return pet;
	}

	public void setPet(PetEntity pet) {
		this.pet = pet;
	}

	public PetFormBean getPetFormBean() {
		return petFormBean;
	}

	public void setPetFormBean(PetFormBean petFormBean) {
		this.petFormBean = petFormBean;
	}


}
