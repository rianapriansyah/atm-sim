package src.com.mitrais;

import java.util.List;
import java.util.Random;

public class Helper {
    public static List<Account> accountList = AccountRepository.setAccounts();

    public static Account getAccountByAccountNumberAndPIN(String accNumber, String pin){
        return accountList.stream().filter(account -> accNumber.equals(account.getAccountNumber()) && pin.equals(account.getPin())).findAny().orElse(null);
    }

    public static Account getAccountByAccountNumber(String accNumber){
        return accountList.stream().filter(account -> accNumber.equals(account.getAccountNumber())).findAny().orElse(null);
    }

    public static Integer generateReferenceNumber(){
        Random rand = new Random();
        return rand.nextInt(999999);
    }
}
