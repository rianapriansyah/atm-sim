package src.com.mitrais.dal;

import src.com.mitrais.model.Account;

import java.util.List;

public interface AccountDao {
    List<Account> getAccounts();
    Account getLoginAccount(String accNumber, String pin);
    Account getAccountByAccNumber(String accNumber);
    void save(Account account);
}
