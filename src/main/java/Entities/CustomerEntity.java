package Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customers")
public class CustomerEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "address")
    private String address;

    @Column(name = "contact_person")
    private String contactPerson;

    @Column(name = "telephone_no")
    private String telephoneNo;

    public CustomerEntity() {
        // No-arg constructor
    }

    // ----Getters---- //

    public Integer getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAddress() {
        return address;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public String getTelephoneNo() {
        return telephoneNo;
    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", telephoneNo='" + telephoneNo + '\'' +
                '}';
    }
}
