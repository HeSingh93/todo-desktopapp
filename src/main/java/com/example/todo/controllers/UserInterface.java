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
    Login login = new Login();

    ArrayList<EmployeeEntity> employees = new ArrayList<>();
    ArrayList<WorkOrderEntity> workOrders = new ArrayList<>();
    ArrayList<LoginEntity> accounts = new ArrayList<>();

    public void start() {

        getAccounts();
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
                    changeWorkOrder();
                    break;
                case "3":
                    removeWorkOrder();
                    break;
                case "4":
                    viewWorkOrders();
                    break;
                case "5":
                    addNewEmployee();
                    break;
                case "6":
                    viewEmployees();
                    break;
                case "7":
                    updateAccount();
                    break;
            }

            if (input.equals("8")) {
                break;
            }
        }
    }

    //method to print the main menu
    public String printMenu() {
        return
                "\nMain menu:" +
                        "\n 1. Add new work order." +
                        "\n 2. Change work order." +
                        "\n 3. Remove work order." +
                        "\n 4. View work orders" +
                        "\n 5. Add a new employee" +
                        "\n 6. View employees" +
                        "\n 7. Make user an admin" +
                        "\n 8. Sign out" +
                        "\n 0. Reprint menu.";

    }

    //method to add a new work order to database
    public void addNewWorkOrder() {
        WorkOrderEntity newWorkOrder = new WorkOrderEntity();

        System.out.println("\nAdding work order");
        newWorkOrder.setDate(createDate());

        newWorkOrder.setTime(createTime());

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

        workOrder.addOrUpdateWorkOrder(newWorkOrder);
        workOrders.add(newWorkOrder);
    }

    //method to make changes to a specific workorder in the database
    public void changeWorkOrder() {
        if (workOrders.isEmpty()) {
            System.out.println("There are no registered work orders at this time.");
            System.out.println(" ");
            return;
        }
        viewAllWorkOrders();

        System.out.println("\nWhich work order would you like to change?");
        int workOrderToChange = Integer.parseInt(scanner.nextLine());
        while (workOrderToChange > workOrders.size() || workOrderToChange < 1) {
            System.out.println("The number you've entered doesn't seem to be in the list.");
            System.out.println("Please enter another number.");
            workOrderToChange = Integer.parseInt(scanner.nextLine());
        }

        System.out.println(
                "\nChange menu:" +
                        "\n1. Change date and time" +
                        "\n2. Change work address" +
                        "\n3. Change work description" +
                        "\n4. Change contact info");
        System.out.println("What would you like to change?");
        int fieldToChange = Integer.parseInt(scanner.nextLine());

        switch (fieldToChange) {
            case 1:
                workOrders.get(workOrderToChange - 1).setDate(createDate());
                workOrders.get(workOrderToChange - 1).setTime(createTime());
                workOrder.addOrUpdateWorkOrder(workOrders.get(workOrderToChange - 1));
                break;
            case 2:
                System.out.println("Enter updated address:");
                String updatedAddress = scanner.nextLine();
                workOrders.get(workOrderToChange - 1).setAddress(updatedAddress);
                workOrder.addOrUpdateWorkOrder(workOrders.get(workOrderToChange - 1));
                break;
            case 3:
                System.out.println("Enter updated work description:");
                String updatedWorkDescription = scanner.nextLine();
                workOrders.get(workOrderToChange - 1).setWorkDescription(updatedWorkDescription);
                workOrder.addOrUpdateWorkOrder(workOrders.get(workOrderToChange - 1));
                break;
            case 4:
                System.out.println("Enter updated contact information:");
                String updatedContactInfo = scanner.nextLine();
                workOrders.get(workOrderToChange - 1).setContactInfo(updatedContactInfo);
                workOrder.addOrUpdateWorkOrder(workOrders.get(workOrderToChange - 1));
                break;
        }
    }

    //method to remove work order from database
    public void removeWorkOrder() {
        if (workOrders.isEmpty()) {
            System.out.println("There are no registered work orders at this time.");
            System.out.println(" ");
            return;
        }
        viewWorkOrders();

        System.out.println("\nWhich work order would you like to remove?");
        int workOrdertoBeRemoved = Integer.parseInt(scanner.nextLine());
        while (workOrdertoBeRemoved > workOrders.size() || workOrdertoBeRemoved < 1) {
            System.out.println("The number you've entered doesn't seem to be in the list.");
            System.out.println("Please enter another number.");
            workOrdertoBeRemoved = Integer.parseInt(scanner.nextLine());
        }

        workOrder.removeWorkOrder(workOrders.get(workOrdertoBeRemoved - 1));
        workOrders.remove(workOrdertoBeRemoved - 1);
    }

    //method to make changes to an existing account
    public void updateAccount() {
        if (accounts.isEmpty()) {
            System.out.println("There are no registered accounts");
            System.out.println(" ");
            return;
        }

        for (LoginEntity loginEntity : accounts) {
            System.out.println(accounts.indexOf(loginEntity) + 1 +
                    " " + loginEntity.getUserName());
        }

        System.out.println("\nWhich account would you like to change permissions for?");
        int accountToMakeAdmin = Integer.parseInt(scanner.nextLine());
        while (accountToMakeAdmin > accounts.size() || accountToMakeAdmin < 1) {
            System.out.println("The id you've entered doesn't seem to be in the list.");
            System.out.println("Please enter another id.");
            accountToMakeAdmin = Integer.parseInt(scanner.nextLine());
        }
        login.makeAdmin(accounts.get(accountToMakeAdmin - 1));
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

    //method to populate an ArrayList with account objects from the database
    public void getAccounts() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(LoginEntity.class)
                .addAnnotatedClass(EmployeeEntity.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            List<LoginEntity> tempAccounts = session.createQuery("from LoginEntity").getResultList();
            accounts.addAll(tempAccounts);
            System.out.println(tempAccounts);
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

        loginEntity.setUserName(firstName + lastName);
        loginEntity.setPassword("password");
        loginEntity.setAdmin(false);
        loginEntity.setEmployeeId(employees.get(employees.size() - 1).getId());

        signup.signUpAccount(loginEntity);
    }

    //method to make a Date object which can be used when creating a new workorder object
    //or when making changes to a workorder object
    public String createDate() {
        System.out.println("Enter work order year:");
        String year = scanner.nextLine();

        System.out.println("Enter work order month:");
        String month = scanner.nextLine();

        System.out.println("Enter work order day:");
        String day = scanner.nextLine();

        return year + "/" + month + "/" + day;
    }

    //method to save and return a workorders starting time
    public String createTime() {
        System.out.println("Enter work order start hour:");
        String hour = scanner.nextLine();

        System.out.println("Enter work order start minutes:");
        String minutes = scanner.nextLine();

        return hour + ":" + minutes;
    }

    // method to view all employees
    public void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("There are no employees in the database");
            return;
        }

        for (EmployeeEntity employeeEntity : employees) {
            System.out.println("_____________________" +
                    "\n First name: " + employeeEntity.getFirstName() +
                    "\n Last name: " + employeeEntity.getLastName() +
                    "\n Telephone number: " + employeeEntity.getTelephoneNo());
        }
    }

    //method to view all workorders
    public void viewAllWorkOrders() {
        if (workOrders.isEmpty()) {
            System.out.println("There are no workorders in the database");
        }

        for (WorkOrderEntity workOrderEntity : workOrders) {
            System.out.println("________________________" +
                    "\n" + (workOrders.indexOf(workOrderEntity) + 1) +
                    "\nDate of order: " + workOrderEntity.getDate() +
                    "\nTime of order: " + workOrderEntity.getTime() +
                    "\nAddress: " + workOrderEntity.getAddress() +
                    "\nWork description: " + workOrderEntity.getWorkDescription() +
                    "\nContact information: " + workOrderEntity.getContactInfo());
        }
    }

    //method to view workorders with a certain status
    public void viewWorkOrders() {
        if (workOrders.isEmpty()) {
            System.out.println("There are no active work orders at this time.");
            return;
        }
        System.out.println("Select the workorder status you would like to view.");
        System.out.println("1. Unassigned");
        System.out.println("2. Assigned");
        System.out.println("3. Accepted");
        System.out.println("4. Done");
        System.out.println("Input choice:");
        int input = Integer.parseInt(scanner.nextLine());

        findWorkOrderByStatus(input);
    }

    //method to find workorders by status with the users input
    public void findWorkOrderByStatus(int status) {
        if (workOrders.isEmpty()) {
            System.out.println("There are no finished workorders.");
        }
        for (WorkOrderEntity workOrderEntity : workOrders) {
            if (workOrderEntity.getStatus() == status) {
                System.out.println("________________________" +
                        "\nStatus: " + WorkOrderStatus.getStatus(status) +
                        "\n" + (workOrders.indexOf(workOrderEntity) + 1) +
                        "\nDate of order: " + workOrderEntity.getDate() +
                        "\nTime of order: " + workOrderEntity.getTime() +
                        "\nAddress: " + workOrderEntity.getAddress() +
                        "\nWork description: " + workOrderEntity.getWorkDescription() +
                        "\nContact information: " + workOrderEntity.getContactInfo());
            }
        }
    }
}