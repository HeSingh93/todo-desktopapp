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

    @Column(name = "time")
    private String time;

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

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getAddress() {
        return address;
    }

    public String getWorkDescription() {
        return workDescription;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public Integer getStatus() {
        return status;
    }

    public String getWorkStarted() {
        return workStarted;
    }

    public String getWorkFinished() {
        return workFinished;
    }

    public double getTravelHours() {
        return travelHours;
    }

    public String getComment() {
        return comment;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setWorkDescription(String workDescription) {
        this.workDescription = workDescription;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setWorkStarted(String workStarted) {
        this.workStarted = workStarted;
    }

    public void setWorkFinished(String workFinished) {
        this.workFinished = workFinished;
    }

    public void setTravelHours(double travelHours) {
        this.travelHours = travelHours;
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
