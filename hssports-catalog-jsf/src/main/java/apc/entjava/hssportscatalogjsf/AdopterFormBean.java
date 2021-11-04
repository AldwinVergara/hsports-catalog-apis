package apc.entjava.hssportscatalogjsf;

import apc.entjava.hssportscatalogejb.AdopterEntity;
import apc.entjava.hssportscatalogejb.AdopterLocal;
import apc.entjava.hssportscatalogejb.CatalogLocal;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
@Named
public class AdopterFormBean {
    @Inject
    private AdopterLocal adopterBean;

    @Inject
    private CatalogLocal catalogBean;

    private long animalId;

    private AdopterEntity adopter = new AdopterEntity();
    private List<AdopterEntity> adopters = new ArrayList<>();


    public void init() {
       this.adopters = adopterBean.getAdopters();
    }

    public String addAdopter() {
       this.adopterBean.addAdopter(new AdopterEntity(this.adopter.getAdopterId(), this.adopter.getFirstName(),
               this.adopter.getLastName(), this.adopter.getContactNumber(), this.adopter.getEmail(),
               this.adopter.getAddress(), this.adopter.getAywanDate()
               )
       );

       this.adopter.setCatalogItem(catalogBean.findItem(animalId));

       this.adopterBean.saveAdopter(adopter);

       return "adoptersList?faces-redirect=true";
    }

    public AdopterLocal getAdopterBean() {
        return adopterBean;
    }

    public void setAdopterBean(AdopterLocal adopterBean) {
        this.adopterBean = adopterBean;
    }

    public AdopterEntity getAdopter() {
        return adopter;
    }

    public void setAdopter(AdopterEntity adopter) {
        this.adopter = adopter;
    }

    public List<AdopterEntity> getAdopters() {
        return adopters;
    }

    public void setAdopters(List<AdopterEntity> adopters) {
        this.adopters = adopters;
    }

    public CatalogLocal getCatalogBean() {
        return catalogBean;
    }

    public void setCatalogBean(CatalogLocal catalogBean) {
        this.catalogBean = catalogBean;
    }

    public long getAnimalId() {
        return animalId;
    }

    public void setAnimalId(long animalId) {
        this.animalId = animalId;
    }
}
