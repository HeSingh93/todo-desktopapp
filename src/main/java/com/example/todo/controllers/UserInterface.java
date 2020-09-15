package com.example.todo.controllers;

import Entities.WorkOrderEntity;
import java.util.*;

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
                    addNewWorkOrder();
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

    public void addNewWorkOrder() {
        WorkOrderEntity newWorkOrder = new WorkOrderEntity();

        System.out.println("\nAdding work order");
        System.out.println("Enter work order year:");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter work order month:");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter work order day:");
        int day = Integer.parseInt(scanner.nextLine());
        Date date = new Date(year, month, day);

        newWorkOrder.setDate(date);

        System.out.println("Enter work order address:");
        String address = scanner.nextLine();

        newWorkOrder.setAddress(address);

        System.out.println("Enter description:");
        String description = scanner.nextLine();

        newWorkOrder.setWorkDescription(description);

        System.out.println("Enter contact info:");
        String contactInfo = scanner.nextLine();

        newWorkOrder.setContactInfo(contactInfo);

        System.out.println("Enter customer id:");
        int customerId = Integer.parseInt(scanner.nextLine());

        newWorkOrder.setCustomerId(customerId);

        newWorkOrder.setStatus(WorkOrderStatus.UNASSIGNED);

        workOrder.addWorkOrder(newWorkOrder);
    }

}
