package com.example.todo.controllers;

import Entities.EmployeeEntity;
import Entities.LoginEntity;
import Entities.WorkOrderEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    WorkOrder workOrder = new WorkOrder();

    public void start() {
        System.out.println(printMenu());

        while (true) {
            System.out.println("\nInput alternative::");
            String input = scanner.nextLine();

            switch (input) {
                case "0":
                    System.out.println(printMenu());
                    break;
                case "1":
                    EmployeeEntity newEmployee = new EmployeeEntity();
                    System.out.println("Enter the employees firstname: ");
                    String firstName = scanner.nextLine();
                    newEmployee.setFirstName(firstName);

                    System.out.println("Enter the employees lastname:");
                    String lastName = scanner.nextLine();
                    newEmployee.setLastName(lastName);

                    System.out.println("Enter the employees telephonenumber: ");
                    String phoneNo = scanner.nextLine();
                    newEmployee.setTelephoneNo(phoneNo);

                    WorkOrderEntity workOrder = new WorkOrderEntity();

                   // workOrder.addWorkOrder(newEmployee, workOrder);

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


}
