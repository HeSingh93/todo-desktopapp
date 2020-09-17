package Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "expenses")
public class ExpensesEntity implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "amount")
    private double amount;

    @Column(name = "description")
    private String description;

    @Column(name = "work_order_id")
    private int workOrderId;

    public ExpensesEntity() {

    }

    // ----Getters---- //

    public Integer getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public int getWorkOrderId() {
        return workOrderId;
    }

    // ----Setters---- //

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWorkOrderId(int workOrderId) {
        this.workOrderId = workOrderId;
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
