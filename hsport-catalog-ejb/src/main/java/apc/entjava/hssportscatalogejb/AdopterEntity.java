package apc.entjava.hssportscatalogejb;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;


@Entity
@Table(name="ADOPTER")
public class AdopterEntity {

    @Id
    @Column(name="ADOPTER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long adopterId;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name="CONTACT_NO")
    private long contactNumber;

    @Column(name="EMAIL")
    private String email;

    @Column(name="ADDRESS")
    private String address;

    @Column(name="AYWAN_DATE")
    private Date aywanDate;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ADOPTER_ID")
    private PetEntity petEntity;

    public AdopterEntity() {

    }

    public AdopterEntity(long adopterId, String firstName, String lastName, long contactNumber, String email, String address, Date aywanDate) {
        super();
        this.adopterId = adopterId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
        this.email = email;
        this.address = address;
        this.aywanDate = aywanDate;
    }

    public long getAdopterId() {
        return adopterId;
    }

    public void setAdopterId(long adopterId) {
        this.adopterId = adopterId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getAywanDate() {
        return aywanDate;
    }

    public void setAywanDate(Date aywanDate) {
        this.aywanDate = aywanDate;
    }

    public PetEntity getPetEntity() {
        return petEntity;
    }

    public void setPetEntity(PetEntity petEntity) {
        this.petEntity = petEntity;
    }

    @Override
    public String toString() {
        return "Adopter{" +
                "adopterId=" + adopterId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contactNumber=" + contactNumber +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", aywanDate=" + aywanDate +
                '}';
    }
}
