package com.example.todo.controllers;

import Entities.LoginEntity;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class Login {

    // Öppnar en anslutning mot databasen, kopplat till Login entityn.

    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(LoginEntity.class)
            .buildSessionFactory();

    Session session = factory.getCurrentSession();

    // TODO: Verifiera användaruppgifter som användaren matar in mot databasen

}
