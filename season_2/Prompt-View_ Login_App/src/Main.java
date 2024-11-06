package io.codeforall.fanstatics;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.PasswordInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

public class Main {
    public static void main(String[] args) {
        Prompt prompt = new Prompt(System.in, System.out);

        System.out.println("Welcome to your first prompt-view Experience!");

        System.out.println("Insert your login credentials below:");

        StringInputScanner question1 = new StringInputScanner();
        question1.setMessage("Username: ");

        StringInputScanner question2 = new PasswordInputScanner();
        question2.setMessage("Password: ");

        String username = prompt.getUserInput(question1);
        String password = prompt.getUserInput(question2);

        if(username.equals("Jose") && password.equals("coisas")){
            System.out.println("\nLogin Successful!\nWelcome home, " + username + "!");
        } else {
            System.out.println("\nWrong Credentials! Exiting...");
        }
    }
}

