package com.example.todo.controllers;
import Entities.WorkOrderEntity;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class WorkOrder {


    public void addWorkOrder(WorkOrderEntity workOrderEntity) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(WorkOrderEntity.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            session.save(workOrderEntity);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
            session.close();
        }
    }

    public void updateWorkOrder() {
        //todo: add functionality
    }

    public void removeWorkOrder() {
    }

}
