package src.com.mitrais.dal;

import src.com.mitrais.model.Account;

public interface TransactionService {
    void setBalance(Account activeAccount, int withdrawAmount);

    void calculateFundTransferBalance(Account activeAccount, Account destAccount, int transferAmount);
}
