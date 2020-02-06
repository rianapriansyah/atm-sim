package src.com.mitrais.utils;

import src.com.mitrais.model.Account;
import java.util.Random;

public class Helper {

    public static Account activeAccount = new Account();
    public static Account destinationAccount = new Account();
    public static int transactionAmount = 0;

    public static Integer generateReferenceNumber(){
        Random rand = new Random();
        return rand.nextInt(999999);
    }

    public static void resetActiveAccount() {
        activeAccount.setBalance(0);
        activeAccount.setAccountNumber(null);
        activeAccount.setName(null);
        activeAccount.setPin(null);
    }

    public static void logAccountIn(Account account){
        activeAccount.setBalance(account.getBalance());
        activeAccount.setAccountNumber(account.getAccountNumber());
        activeAccount.setName(account.getName());
        activeAccount.setPin(account.getPin());
    }

    public static void setDestinationAccount(Account account){
        destinationAccount.setBalance(account.getBalance());
        destinationAccount.setAccountNumber(account.getAccountNumber());
        destinationAccount.setName(account.getName());
        destinationAccount.setPin(account.getPin());
    }

    public static void showBase(){
        System.out.println();
        System.out.println("==============================================");
        System.out.println("Welcome, " + activeAccount.getName());
        System.out.println("Your current balance is " + activeAccount.getBalance());
        System.out.println("==============================================");
        System.out.println();
    }
}
