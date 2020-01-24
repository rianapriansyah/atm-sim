package com.mitrais;

import java.util.List;
import java.util.Scanner;

public class Screen {
    LoginValidation validation = new LoginValidation();


    public void showWelcomeScreen(){
        this.readInputWelcomeScreen();
    }

    private void readInputWelcomeScreen(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Account Number: ");
        String account = in.next();
        System.out.println("Enter PIN: ");
        String pin = in.next();

        List<Error> errorList = validation.ValidateInput(account, pin);
        if(!errorList.isEmpty()){
            for (Error err: errorList) {
                System.out.println(err.getErrorMessage());
                this.readInputWelcomeScreen();
            }
        }
        else {
            this.readInputTransactionOptions();
        }
    }

    private void readInputTransactionOptions(){
        Scanner in = new Scanner(System.in);
        System.out.println("1. Withdraw");
        System.out.println("2. Fund Transfer");
        System.out.println("3. Exit");
        System.out.println("Please choose option[3]: ");

        String opt = in.nextLine();
        switch (opt){
            case "1":
                this.readInputWithdrawOption();
            case "2":
                System.out.println("Option 2 selected");
                this.readInputTransactionOptions();
            case "3":
                System.out.println("Option 3 selected");
                this.readInputTransactionOptions();
            case "":
                System.out.println("No option selected");
                this.readInputTransactionOptions();
            default:
                this.readInputWithdrawOption();
        }
    }

    private void readInputWithdrawOption(){
        Scanner in = new Scanner(System.in);
        System.out.println("1. $10");
        System.out.println("2. $50");
        System.out.println("3. $100");
        System.out.println("4. Other");
        System.out.println("5. Back");
        System.out.println("Please choose option[5]:");

        String opt = in.nextLine();
    }
}
