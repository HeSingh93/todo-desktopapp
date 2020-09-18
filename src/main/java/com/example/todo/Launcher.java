package com.example.todo;

import com.example.todo.controllers.Login;
import com.example.todo.controllers.UserInterface;

import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login signin = new Login();
        UserInterface ui = new UserInterface();
        boolean isLoggedIn = false;

        while (!isLoggedIn) {
            System.out.println("Welcome, enter your username: ");
            String username = scanner.nextLine();
            System.out.println("Input password: ");
            String password = scanner.nextLine();
            if (signin.login(username, password)) {
                isLoggedIn = true;
            }
            //signin.login(username, password);
            //isLoggedIn = signin.login(username, password);
        }

        ui.start();
    }
}
