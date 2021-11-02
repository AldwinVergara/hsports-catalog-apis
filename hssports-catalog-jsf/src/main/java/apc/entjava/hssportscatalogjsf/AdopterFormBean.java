package apc.entjava.hssportscatalogjsf;

import apc.entjava.hssportscatalogejb.AdopterEntity;
import apc.entjava.hssportscatalogejb.AdopterLocal;

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

}
