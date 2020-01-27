package com.mitrais;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Screen {
    Validation validation = new Validation();
    Account account = new Account();

    public void showWelcomeScreen(){
        this.welcomeScreen();
    }

    private void welcomeScreen(){

        Scanner in = new Scanner(System.in);
        System.out.println("Enter Account Number: ");
        String accountNumber = in.next();
        System.out.println("Enter PIN: ");
        String pin = in.next();

        List<Error> errorList = validation.ValidateInput(accountNumber, pin);
        if(!errorList.isEmpty()){
            for (Error err: errorList) {
                System.out.println(err.getErrorMessage());
                this.welcomeScreen();
            }
        }
        else {
            account = Helper.getAccountByAccountNumberAndPIN(accountNumber, pin);
            this.transactionScreen();
        }
    }

    private void transactionScreen(){
        Scanner in = new Scanner(System.in);
        System.out.println("1. Withdraw");
        System.out.println("2. Fund Transfer");
        System.out.println("3. Exit");
        System.out.println("Please choose option[3]: ");

        String opt = in.nextLine();
        switch (opt){
            case "1":
                this.withdrawScreen();
                break;
            case "2":
                this.fundTransferScreen();
                break;
            case "3":
            case "":
                this.welcomeScreen();
                break;
            default:
                this.transactionScreen();
                break;
        }
    }

    private void fundTransferScreen(){
        Account destAccount = new Account();
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter destination account and press enter to continue or \n" +
                "press enter to go back to Transaction: ");

        String accountNumber = in.nextLine();
        if(accountNumber.equals("")){
            this.transactionScreen();
        }

        Error err = validation.validateDestinationAccount(accountNumber);
        if(err.getError()){
            System.out.println(err.getErrorMessage());
            this.fundTransferScreen();
        }

        destAccount = Helper.getAccountByAccountNumber(accountNumber);
        if(destAccount == null){
            System.out.println("Invalid Account");
            this.fundTransferScreen();
        }
    }

    private void withdrawScreen(){
        Scanner in = new Scanner(System.in);
        System.out.println("1. $10");
        System.out.println("2. $50");
        System.out.println("3. $100");
        System.out.println("4. Other");
        System.out.println("5. Back");
        System.out.println("Please choose option[5]:");

        Integer currBalance = account.getBalance();

        String opt = in.nextLine();
        switch (opt){
            case "1":
                this.withdraw(currBalance, 10);
                break;
            case "2":
                this.withdraw(currBalance, 50);
                break;
            case "3":
                this.withdraw(currBalance, 100);
                break;
            case "":
            default:
                this.transactionScreen();
                break;
        }
    }

    private void withdraw(int balance, int withdrawAmount){
        Error err = validation.ValidateRemainingBalance(balance, withdrawAmount);
        if(err.getError()){
            System.out.println(err.getErrorMessage());
            this.transactionScreen();
        }

        account.setBalance(balance - withdrawAmount);
        this.summaryScreen();
    }

    private void otherWithdrawScreen(){
        Integer currBalance = account.getBalance();
        Scanner in = new Scanner(System.in);
        System.out.println("Other withdraw");
        System.out.println("Enter amount to withdraw: ");

        String input = in.nextLine();
        if(!input.matches("\\d+")){
            System.out.println("Other withdraw");
            this.otherWithdrawScreen();
        }

        int i = Integer.parseInt(input);

        Error err = validation.validateWithdrawTenMultiply(i);
        if(err.getError()){
            System.out.println(err.getErrorMessage());
            this.otherWithdrawScreen();
        }

        err = validation.ValidateRemainingBalance(currBalance, i);
        if(err.getError()){
            System.out.println(err.getErrorMessage());
            this.transactionScreen();
        }
    }

    public void summaryScreen(){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm a");
        String dateTimeFormatted = localDateTime.format(dateTimeFormatter);

        System.out.println("Summary");
        System.out.printf("Date: %s%n",  dateTimeFormatted);
        System.out.printf("Balance: %d\n", account.getBalance());
        System.out.println();
        System.out.println("1. Transaction");
        System.out.println("2. Exit");
        System.out.print("Please choose option[2]: ");
        Scanner in = new Scanner(System.in);

        String opt = in.nextLine();
        switch (opt){
            case "1":
                this.transactionScreen();
                break;
            case "2":
            default:
                this.welcomeScreen();
                break;
        }
    }
}
