package com.example.todo.controllers;

import Entities.EmployeeEntity;
import Entities.LoginEntity;
import Entities.WorkOrderEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    WorkOrder workOrder = new WorkOrder();

    ArrayList<EmployeeEntity> employees = new ArrayList<>();
    ArrayList<WorkOrderEntity> workOrders = new ArrayList<>();

    public void start() {

        getEmployees();
        getWorkOrder();

        while (true) {
            System.out.println(printMenu());
            System.out.println("\nInput alternative:");
            String input = scanner.nextLine();

            switch (input) {
                case "0":
                    System.out.println(printMenu());
                    break;
                case "1":
                    addNewWorkOrder();
                    break;
                case "2":
                    getWorkOrder();
                    removeWorkOrder();
                    break;
                case "3":
                    viewWorkOrders();
                    break;
                case "4":
                    addNewEmployee();
                    break;
            }

            if (input.equals("5")) {
                break;
            }
        }
    }

    //method to print the main menu
    public String printMenu() {
        return
                "\nMain menu:" +
                        "\n 1. Add new work order." +
                        "\n 2. Remove work order." +
                        "\n 3. View work orders" +
                        "\n 4. Add a new employee" +
                        "\n 5. Sign out" +
                        "\n 0. Reprint menu.";

    }

    //method to add a new work order to database
    public void addNewWorkOrder() {
        WorkOrderEntity newWorkOrder = new WorkOrderEntity();

        System.out.println("\nAdding work order");
        System.out.println("Enter work order year:");
        int year = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter work order month:");
        int month = Integer.parseInt(scanner.nextLine());
        while (month > 12 || month < 1) {
            System.out.println("Invalid month!" + "\nPlease enter a valid month number(1-12)");
            month = Integer.parseInt(scanner.nextLine());
        }

        System.out.println("Enter work order day:");
        int day = Integer.parseInt(scanner.nextLine());

        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);

        Date date = cal.getTime();
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

        newWorkOrder.setStatus(WorkOrderStatus.UNASSIGNED);

        workOrder.addWorkOrder(newWorkOrder);
    }

    //method to remove work order from database
    public void removeWorkOrder() {
        if (workOrders.isEmpty()) {
            System.out.println("There are no registered work orders at this time.");
            System.out.println(" ");
            return;
        }

        for (WorkOrderEntity workOrderEntity : workOrders) {
            System.out.println(workOrders.indexOf(workOrderEntity) + 1 +
                    " " + workOrderEntity.getDate() +
                    " " + workOrderEntity.getWorkDescription() +
                    " Customer: " + workOrderEntity.getContactInfo());
        }

        System.out.println("Which work order would you like to remove?");
        int workOrdertoBeRemoved = Integer.parseInt(scanner.nextLine());
        while (workOrdertoBeRemoved > workOrders.size() || workOrdertoBeRemoved < 1) {
            System.out.println("The number you've entered doesn't seem to be in the list.");
            System.out.println("Please enter another number.");
            workOrdertoBeRemoved = Integer.parseInt(scanner.nextLine());
        }

        workOrder.removeWorkOrder(workOrders.get(workOrdertoBeRemoved - 1));
        workOrders.remove(workOrdertoBeRemoved - 1);
    }

    //method to create a list of all employees in database
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
            employees.addAll(tempEmployees);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
            session.close();
        }
    }

    //method to make a list of all work orders in database
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
            workOrders.addAll(tempWorkOrders);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
            session.close();
        }
    }

    //method to add a new employee to database
    public void addNewEmployee() {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        LoginEntity loginEntity = new LoginEntity();
        SignUp signup = new SignUp();

        System.out.println("Adding a new employee and account");
        System.out.println("Enter first name:");
        String firstName = scanner.nextLine();
        employeeEntity.setFirstName(firstName);

        System.out.println("Enter last name:");
        String lastName = scanner.nextLine();
        employeeEntity.setLastName(lastName);

        System.out.println("Enter telephone number:");
        String telephoneNo = scanner.nextLine();
        employeeEntity.setTelephoneNo(telephoneNo);

        signup.signUpEmployee(employeeEntity);
        getEmployees();

        System.out.println("Enter username:");
        String userName = scanner.nextLine();
        loginEntity.setUserName(userName);

        System.out.println("Enter password:");
        String password = scanner.nextLine();
        loginEntity.setPassword(password);
        loginEntity.setAdmin(false);

        loginEntity.setEmployeeId(employees.get(employees.size() - 1).getId());
        signup.signUpAccount(loginEntity);
    }

    public void viewWorkOrders() {
        for (WorkOrderEntity order : workOrders) {
            System.out.println("________________________" +
                    "\n Workorder Id: " + order.getId() +
                    "\n Date of order: " + order.getDate() +
                    "\n Adress: " + order.getAddress() +
                    "\n Work description: " + order.getWorkDescription() +
                    "\n Contact information: " + order.getContactInfo() +
                    "\n Comments: " + order.getComment());
        }
    }
}
