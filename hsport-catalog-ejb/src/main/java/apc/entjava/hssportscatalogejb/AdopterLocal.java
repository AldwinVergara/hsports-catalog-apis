package apc.entjava.hssportscatalogejb;

import javax.ejb.Local;
import java.util.List;

@Local
public interface AdopterLocal {
    public List<AdopterEntity> getAdopter();
    public void addAdopter(AdopterEntity adopter);
    public void removeAdopter(AdopterEntity adopter);
    // public void updateAdopter(AdopterEntity adopter);
    public List<AdopterEntity> searchByFirstName(String firstName);
    public List<AdopterEntity> searchByLastName(String lastName);
}
