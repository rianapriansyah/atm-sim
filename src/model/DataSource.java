package model;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public List<Account> getAccounts() {
        List<Account> accounts = new ArrayList<>();
        Account account = new Account("John Doe", "012108", 100.0, "112233");
        Account account1 = new Account("Jane Doe", "932012", 30.0, "112244");
        accounts.add(account);
        accounts.add(account1);

        return  accounts;
    }
}

