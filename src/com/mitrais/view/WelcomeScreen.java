package src.com.mitrais.view;

import src.com.mitrais.model.Account;
import src.com.mitrais.utils.Helper;
import src.com.mitrais.utils.Validation;

import java.util.List;
import java.util.Scanner;

public class WelcomeScreen extends BaseScreen {
    private Scanner in = new Scanner(System.in);
    private TransactionScreen transactionScreen = new TransactionScreen();
    Validation validation = new Validation();

    public void show(Account account){
        System.out.println("======================= ATM Simulation =======================");
        System.out.println("Enter Account Number: ");

        String accountNumber = in.nextLine();

        List<String> errAccount = validation.validateAccountNumberOrPin(accountNumber, true);
        if(!errAccount.isEmpty()){
            for (String error : errAccount) {
                System.out.println(">> " + error);
                return;
            }
        }

        System.out.println("Enter PIN: ");
        String pin = in.nextLine();

        errAccount = validation.validateAccountNumberOrPin(pin, false);
        if(!errAccount.isEmpty()){
            for (String error : errAccount) {
                System.out.println(">> " + error);
                return;
            }
        }

        if(account == null){
            try{
                account = accountDao.getLoginAccount(accountNumber, pin);
                Helper.logAccountIn(account);
                transactionScreen.show();
            }
            catch (RuntimeException ex){
                System.out.println(ex.getMessage());
            }
        }
        else{
            Helper.logAccountIn(account);
            transactionScreen.show();
        }
    }
}
