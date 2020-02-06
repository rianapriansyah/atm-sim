package src.com.mitrais.dal;

import src.com.mitrais.model.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountDaoImpl implements AccountDao {
    List<Account> accountList = new ArrayList<Account>();
    private static AccountDaoImpl accountDaoInstance;

    public static AccountDaoImpl getInstance(){
        if(accountDaoInstance == null){
            accountDaoInstance = new AccountDaoImpl();
        }
        return  accountDaoInstance;
    }

    //012108
    public AccountDaoImpl(){
        accountList.add(new Account("John Doe", "112233", 100, "112233"));
        accountList.add(new Account("Jane Doe", "932012", 30, "112244"));
    }

    @Override
    public List<Account> getAccounts() {
        return accountList;
    }

    @Override
    public Account getLoginAccount(String accNumber, String pin) {
        return accountList.stream().filter(account -> accNumber.equals(account.getAccountNumber()) && pin.equals(account.getPin())).findAny().orElse(null);
    }

    @Override
    public Account getAccountByAccNumber(String accNumber) {
        return accountList.stream().filter(account -> accNumber.equals(account.getAccountNumber())).findAny().orElse(null);
    }

    @Override
    public void save(Account account) {
        accountList.add(account);
    }
}
