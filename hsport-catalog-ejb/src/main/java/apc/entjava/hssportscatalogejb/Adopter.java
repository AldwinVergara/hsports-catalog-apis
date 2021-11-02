package apc.entjava.hssportscatalogejb;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Singleton
@LocalBean
public class Adopter implements AdopterLocal {

    @PersistenceContext
    private EntityManager entityManager;

    public Adopter() {

    }

    @Override
    public List<AdopterEntity> getAdopter() {
        return null;
    }

    @Override
    public void addAdopter(AdopterEntity adopter) {

    }

    @Override
    public void removeAdopter(AdopterEntity adopter) {

    }

    @Override
    public List<AdopterEntity> searchByFirstName(String firstName) {
        return null;
    }

    @Override
    public List<AdopterEntity> searchByLastName(String lastName) {
        return null;
    }
}
