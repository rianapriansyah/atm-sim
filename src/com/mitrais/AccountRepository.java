package src.com.mitrais;

import java.util.ArrayList;
import java.util.List;

public class AccountRepository {

    public static List<Account> setAccounts() {
        List<Account> accounts = new ArrayList<>();
        Account account = new Account();
        account.setName("John Doe");
        account.setPin("012108");
        account.setBalance(100);
        account.setAccountNumber("112233");

        Account account1 = new Account();
        account1.setName("Jane Doe");
        account1.setPin("932012");
        account1.setBalance(30);
        account1.setAccountNumber("112244");
        accounts.add(account);
        accounts.add(account1);
        return  accounts;
    }
}

