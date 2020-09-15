package com.example.todo.controllers;

import Entities.EmployeeEntity;
import Entities.LoginEntity;
import Entities.WorkOrderEntity;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Login {
    ArrayList<EmployeeEntity> employees = new ArrayList<>();
    ArrayList<WorkOrderEntity> workOrders = new ArrayList<>();

    // Opens a connection to the database via the Login Entity

    public void login(String userName, String password) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(LoginEntity.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            List<LoginEntity> theUser = session.createQuery("from LoginEntity where username = '" + userName + "'").getResultList();

            System.out.println(theUser);

            for (LoginEntity tempUser : theUser) {
                if (tempUser.getUserName().equals(userName) && tempUser.getPassword().equals(password) && tempUser.isAdmin()) {
                    session.save(tempUser);
                    System.out.println("Welcome " + tempUser.getUserName() + "!");
                    System.out.println(tempUser);
                    System.out.println("INSIDE THE LOGIN CLASS METHOD");
                    UserInterface ui = new UserInterface();
                    getEmployees();
                    getWorkOrder();
                    ui.start();
                }
            }
            session.getTransaction().commit();
            System.out.println("Wrong username or password, try again!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
            session.close();
        }
    }

    public void getEmployees() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(LoginEntity.class)
                .addAnnotatedClass(EmployeeEntity.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            List<EmployeeEntity> tempEmployees = session.createQuery("from EmployeeEntity").getResultList();
            for (EmployeeEntity employeeEntity : tempEmployees) {
                System.out.println(employeeEntity);
                employees.add(employeeEntity);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
            session.close();
        }
    }

    public void getWorkOrder() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(LoginEntity.class)
                .addAnnotatedClass(WorkOrderEntity.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            List<WorkOrderEntity> tempWorkOrders = session.createQuery("from WorkOrderEntity").getResultList();
            for (WorkOrderEntity workOrderEntity : tempWorkOrders) {
                System.out.println(workOrderEntity);
                workOrders.add(workOrderEntity);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
            session.close();
        }
    }
}


