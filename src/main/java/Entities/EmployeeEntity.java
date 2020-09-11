package Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "public.employees")
public class EmployeeEntity implements Serializable {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "telephone_no")
    private String telephoneNo;

    public EmployeeEntity() {
        // No-arg constructor
    }

    // ----Getters---- //

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTelephoneNo() {
        return telephoneNo;
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", telephoneNo='" + telephoneNo + '\'' +
                '}';
    }
}
