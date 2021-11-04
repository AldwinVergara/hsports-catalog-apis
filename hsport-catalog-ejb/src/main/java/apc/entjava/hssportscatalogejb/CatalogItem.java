package apc.entjava.hssportscatalogejb;

//import java.time.LocalDate;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="CATALOG_ITEM")
public class CatalogItem {
	@Id
	@Column(name="CATALOG_ITEM_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long itemId;

	@Column(name="TYPE_OF_ANIMAL")
	private String typeOfAnimal;

	@Column(name="NAME")
	private String name;

	//@Column(name="MANUFACTURER")
	//private String manufacturer;
	@Column(name="BREED")
	private String breed;

	@Column(name="COLOR")
	private String color;

	//@Column(name = "DESCRIPTION")
	//private String description;
	@Column(name = "BEHAVIOR")
	private String behavior;

	@Column(name = "AVAILABLE_DATE")
	private Date availableDate;

	@OneToOne(mappedBy = "catalogItem")
	private AdopterEntity adopterEntity;

	public CatalogItem() {
		
	}
	
	public CatalogItem(String typeOfAnimal, String name, String breed, String color, String behavior, Date availableDate) {
		super();
		this.typeOfAnimal = typeOfAnimal;
		this.name = name;
		this.breed = breed;
		this.color = color;
		this.behavior = behavior;
		//this.manufacturer = manufacturer;
		//this.description = description;
		this.availableDate = availableDate;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getTypeOfAnimal() {return typeOfAnimal;}

	public void setTypeOfAnimal(String typeOfAnimal) {this.typeOfAnimal = typeOfAnimal;}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {return breed;}

	public void setBreed(String breed) {this.breed = breed;}

	public String getColor() {return color;}

	public void setColor(String color) {this.color = color;}

	/*public String getManufacturer() {
            return manufacturer;
        }

        public void setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
        */

	public String getBehavior() {return behavior;}

	public void setBehavior(String behavior) {this.behavior = behavior;}

	public Date getAvailableDate() {return availableDate;}

	public void setAvailableDate(Date availableDate) {this.availableDate = availableDate;}

	public AdopterEntity getAdopterEntity() {
		return adopterEntity;
	}

	public void setAdopterEntity(AdopterEntity adopterEntity) {
		this.adopterEntity = adopterEntity;
	}

	@Override
	public String toString() {
		return "CatalogItem [itemId=" + itemId + ", typeOfAnimal=" + typeOfAnimal + ", name=" + name + ", breed=" + breed + ", color=" + color + ", behavior="
				+ behavior + ", availableDate=" + availableDate + "]";
	}

}
