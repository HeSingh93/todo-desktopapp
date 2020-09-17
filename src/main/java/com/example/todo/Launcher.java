package com.example.todo;

import com.example.todo.controllers.Login;

import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login signin = new Login();

        System.out.println("Welcome, enter your username: ");
        String username = scanner.nextLine();
        System.out.println("Input password: ");
        String password = scanner.nextLine();
        signin.login(username, password);
        //Main.main(args);
    }
}
