package com.example.todo;

import Entities.LoginEntity;
import com.example.todo.controllers.UserInterface;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {
        //creates object and runs start method of object
        UserInterface ui = new UserInterface();

        login();
       // ui.start();

        //Main.main(args);
    }

     static void login() {
        UserInterface ui = new UserInterface();

        Scanner scanner = new Scanner(System.in);

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
}
