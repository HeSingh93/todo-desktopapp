package Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "public.expenses")
public class ExpensesEntity implements Serializable {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "amount")
    private double amount;

    @Column(name = "description")
    private String description;

    public ExpensesEntity() {

    }

    // ----Getters---- //

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    // ----Setters---- //

    public void setId(int id) {
        this.id = id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ExpensesEntity{" +
                "id=" + id +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}
