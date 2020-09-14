package com.example.todo.controllers;

import Entities.LoginEntity;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Login {

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

            for (LoginEntity tempUser : theUser) {
                if (tempUser.getUserName().equals(userName) && tempUser.getPassword().equals(password) && tempUser.isAdmin()) {
                    session.save(tempUser);
                    System.out.println("INSIDE IF");
                    System.out.println("Welcome " + tempUser.getUserName() + "!");
                    System.out.println(tempUser);
                    System.out.println("INSIDE THE LOGIN CLASS METHOD");
                    UserInterface ui = new UserInterface();
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
// TODO: Verify account and password


