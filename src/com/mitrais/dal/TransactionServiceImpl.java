package src.com.mitrais.dal;

import src.com.mitrais.model.Account;
import src.com.mitrais.view.SummaryScreen;

import static src.com.mitrais.utils.Helper.activeAccount;
import static src.com.mitrais.utils.Helper.destinationAccount;
import static src.com.mitrais.utils.Helper.transactionAmount;
import static src.com.mitrais.utils.Helper.generateReferenceNumber;

public class TransactionServiceImpl implements TransactionService {
    SummaryScreen summaryScreen = new SummaryScreen();
    @Override
    public void calculateWithdrawalBalance(Account actAccount, int withdrawAmount) {
        int balance = actAccount.getBalance() - withdrawAmount;
        if (withdrawAmount > 1000){
            System.out.println(">> Maximum amount to withdraw is $1000");
        }
        else if(balance < 0){
            System.out.println(">> Insufficient Balance $" + withdrawAmount);
        }
        else {
            transactionAmount = withdrawAmount;
            activeAccount.setBalance(balance);
            summaryScreen.show(false, 0);
        }
    }

    @Override
    public void calculateFundTransferBalance(Account actAccount, Account destAccount, int transferAmount) {
        int refNumber = generateReferenceNumber();
        if(transferAmount%10 != 0){
            System.out.println(">> Invalid Amount");
        }
        else {

            transactionAmount = transferAmount;
            activeAccount.setBalance(activeAccount.getBalance() - transferAmount);
            destinationAccount.setBalance(destinationAccount.getBalance() + transferAmount);
            summaryScreen.show(true, refNumber);
        }
    }
}
