package com.example.todo.controllers;

import Entities.LoginEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    WorkOrder workOrder = new WorkOrder();

    public void start() {
        //login();
        System.out.println(printMenu());

        while (true) {
            System.out.println("\nInput alternative::");
            String input = scanner.nextLine();

            switch (input) {
                case "0":
                    System.out.println(printMenu());
                    break;
                case "1":
                    //workOrder.addWorkOrder(EmployeeEntity, WorkOrderEntity)
                    break;
                case "2":
                    //workOrder.removeWorkOrder(EmployeeEntity, WorkOrderEntity)
                    break;
                case "3":
                    //workOrder.updateWorkOrder(EmployeeEntity, WorkOrderEntity)
                    break;
                case "4":
                    //Login.logOut()
            }

            if (input.equals("4")) {
                break;
            }
        }
    }

    public String printMenu() {
        return
                "Main menu:" +
                        "\n 1. Add work order to list." +
                        "\n 2. Remove work order to list." +
                        "\n 3. Change an existing work order." +
                        "\n 4. Log out." +
                        "\n 0. Reprint menu.";

    }

    public void login() {

        System.out.println("Input username: ");
        String userName = scanner.nextLine();

        System.out.println("Input password: ");
        String password = scanner.nextLine();

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(LoginEntity.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            List<LoginEntity> theUser = session.createQuery("from LoginEntity where username = '" + userName + "'").getResultList();

            for (LoginEntity tempUser : theUser) {
                if (tempUser.getUserName().equals(userName) && tempUser.getPassword().equals(password) && tempUser.isAdmin()) {
                    session.save(tempUser);
                    System.out.println("INSIDE IF");
                    System.out.println("Welcome " + tempUser.getUserName() + "!");
                    System.out.println(tempUser);
                }
            }
            session.getTransaction().commit();
            System.out.println("OUTSIDE");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
            session.close();
        }
    }
}
