package apc.entjava.hssportscatalogejb;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Singleton
@LocalBean
public class Adopter implements AdopterLocal {

    @PersistenceContext
    private EntityManager entityManager;
    
    public Adopter() {

    }

    @Override
    public List<AdopterEntity> getAdopters() {
        return this.entityManager.createQuery("select p from AdopterEntity p", AdopterEntity.class).getResultList();
    }

    @Override
    public void addAdopter(AdopterEntity adopter) {
        this.entityManager.persist(adopter);
    }

    @Override
    public void removeAdopter(AdopterEntity adopter) {
        this.entityManager.remove(this.entityManager.contains(adopter) ? adopter : this.entityManager.merge(adopter));
    }

    @Override
    public AdopterEntity findAdopter(Long adopterId) {
        return this.entityManager.find(AdopterEntity.class, adopterId);
    }

    @Override
    public List<AdopterEntity> searchByFirstName(String firstName) {
        TypedQuery<AdopterEntity> query = this.entityManager.createQuery("select p from AdopterEntity p" +
                " where p.firstName like :firstName", AdopterEntity.class);

        return query.setParameter("firstName", "%" + firstName + "%").getResultList();
    }

    @Override
    public List<AdopterEntity> searchByLastName(String lastName) {
        TypedQuery<AdopterEntity> query = this.entityManager.createQuery("select p from AdopterEntity p" +
                " where p.firstName like :lastName", AdopterEntity.class);

        return query.setParameter("lastName", "%" + lastName + "%").getResultList();
    }

    @Override
    public void saveAdopter(AdopterEntity adopter) {
        this.entityManager.merge(adopter);
    }
}
