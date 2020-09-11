package Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "public.work_orders")
public class WorkOrderEntity {

    @Id
    @Column(name = "id")
    private int id;

    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;

    @Column(name = "address")
    private String address;

    @Column(name = "work_description")
    private String workDescription;

    @Column(name = "contact_info")
    private String contactInfo;

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "status")
    private int status;

    @Temporal(TemporalType.DATE)
    @Column(name = "work_started")
    private Date workStarted;

    @Temporal(TemporalType.DATE)
    @Column(name = "work_finished")
    private Date workFinished;

    @Column(name = "travel_hours")
    private double travelHours;

    @Column(name = "comment")
    private String comment;


}
