package com.example.todo.controllers;

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
}
