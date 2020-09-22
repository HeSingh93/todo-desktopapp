package Entities;

import com.sun.istack.Nullable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "work_orders")
public class WorkOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "date")
    private String date;

    @Column(name = "address")
    private String address;

    @Column(name = "work_description")
    private String workDescription;

    @Column(name = "contact_info")
    private String contactInfo;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "status")
    private Integer status;

    @Column(name = "work_started")
    private String workStarted;

    @Column(name = "work_finished")
    private String workFinished;

    @Column(name = "travel_hours")
    private double travelHours;

    @Column(name = "comment")
    private String comment;

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorkDescription() {
        return workDescription;
    }

    public void setWorkDescription(String workDescription) {
        this.workDescription = workDescription;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getWorkStarted() {
        return workStarted;
    }

    public void setWorkStarted(String workStarted) {
        this.workStarted = workStarted;
    }

    public String getWorkFinished() {
        return workFinished;
    }

    public void setWorkFinished(String workFinished) {
        this.workFinished = workFinished;
    }

    public double getTravelHours() {
        return travelHours;
    }

    public void setTravelHours(double travelHours) {
        this.travelHours = travelHours;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "WorkOrderEntity{" +
                "id=" + id +
                ", date=" + date +
                ", address='" + address + '\'' +
                ", workDescription='" + workDescription + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", customerId=" + customerId +
                ", employeeId=" + employeeId +
                ", status=" + status +
                ", workStarted=" + workStarted +
                ", workFinished=" + workFinished +
                ", travelHours=" + travelHours +
                ", comment='" + comment + '\'' +
                '}';
    }
}
