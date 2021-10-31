package apc.entjava.hssportscatalogejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class Catalog
 */
@Singleton
@LocalBean
public class Catalog implements CatalogLocal {

	/* private List<CatalogItem> items = new ArrayList<>();*/
	@PersistenceContext
	private EntityManager entityManager;

	/**
     * Default constructor. 
     */
    public Catalog() {
    }

	@Override
	public List<CatalogItem> getItems() {
		return this.entityManager.createQuery("select c from CatalogItem c", CatalogItem.class).getResultList();
	}

	@Override
	public void addItem(CatalogItem item) {
		this.entityManager.persist(item);
	}

	@Override
	public void deleteItem(CatalogItem item) {
		/*this.entityManager.createQuery("delete from CatalogItem p where p.itemId=:id")
				.setParameter("id", item.getItemId())
				.executeUpdate();
*/
		this.entityManager.remove(this.entityManager.contains(item) ? item:this.entityManager.merge(item));
	}

	@Override
	public void updateItem(CatalogItem item) {
		this.entityManager.createQuery("update CatalogItem c set c.typeOfAnimal=:itemTypeOfAnimal, c.name=:itemName, c.breed=:itemBreed, c.color=:itemColor, c.availableDate=:itemDate, c.behavior=:itemBehavior where c.itemId=:id")
				.setParameter("id", item.getItemId())
				.setParameter("itemTypeOfAnimal", item.getTypeOfAnimal())
				.setParameter("itemName", item.getName())
				.setParameter("itemBreed", item.getBreed())
				.setParameter("itemColor", item.getColor())
				.setParameter("itemDate",item.getAvailableDate())
				.setParameter("itemBehavior",item.getBehavior())
				.executeUpdate();
	}


	@Override
	public CatalogItem findItem(Long itemId) {
		return this.entityManager.find(CatalogItem.class, itemId);
	}

	@Override
	public List<CatalogItem> searchByName(String name) {
		return this.entityManager.createQuery("select c from CatalogItem c " +
				" where c.name like :name", CatalogItem.class).setParameter("name", "%" + name + "%").getResultList();
	}




}
