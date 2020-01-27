package com.mitrais;

import java.util.List;
import java.util.Random;

public class Helper {
    public static List<Account> accountList = DataSource.setAccounts();

    public static Account getAccountByAccountNumberAndPIN(String accNumber, String pin){
        Account acc = accountList.stream().filter(account -> accNumber.equals(account.getAccountNumber()) && pin.equals(account.getPIN())).findAny().orElse(null);
        return  acc;
    }

    public static Account getAccountByAccountNumber(String accNumber){
        Account acc = accountList.stream().filter(account -> accNumber.equals(account.getAccountNumber())).findAny().orElse(null);
        return  acc;
    }

    public static Integer generateReferenceNumber(){
        Random rand = new Random();
        int ref = rand.nextInt(999999);
        return  ref;
    }
}
