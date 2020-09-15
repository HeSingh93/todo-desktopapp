package Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "login")
public class LoginEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "is_admin")
    private boolean isAdmin;

    public LoginEntity() {
    }

    public LoginEntity(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    // ----Getters---- //

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    // ----Setters---- //

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public String toString() {
        return "LoginEntity{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", employeeId=" + employeeId +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
