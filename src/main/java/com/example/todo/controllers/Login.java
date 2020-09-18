package com.example.todo.controllers;

import Entities.EmployeeEntity;
import Entities.LoginEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Login {

    // Opens a connection to the database via the Login Entity
    public boolean login(String userName, String password) {
        boolean validLogin = false;
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(LoginEntity.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            LoginEntity theUser = session.createQuery("from LoginEntity where username = '" + userName + "'", LoginEntity.class).getSingleResult();

            if (theUser.getUserName().equals(userName) && theUser.getPassword().equals(password) && theUser.isAdmin()) {
                System.out.println("Welcome " + theUser.getUserName() + "!");
                validLogin = true;
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
            session.close();
        }

        return validLogin;
    }

    public void makeAdmin(LoginEntity loginEntity) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(LoginEntity.class)
                .addAnnotatedClass(EmployeeEntity.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            loginEntity.setAdmin(true);
            session.saveOrUpdate(loginEntity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}


