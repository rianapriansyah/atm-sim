package com.mitrais;

import java.util.List;
import java.util.Scanner;

public class WelcomeScreen {
    LoginValidation validation = new LoginValidation();

    public void show(){
        this.readInput();
    }

    private void readInput(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Account Number: ");
        String account = in.next();
        System.out.println("Enter PIN: ");
        String pin = in.next();

        List<Error> errorList = validation.ValidateInput(account, pin);
        if(!errorList.isEmpty()){
            for (Error err: errorList) {
                System.out.println(err.getErrorMessage());
            }
        }
        else {
            System.out.println("Welcome!!!");
        }
    }
}
