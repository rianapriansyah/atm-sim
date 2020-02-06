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

    public void show(){
        System.out.println("======================= ATM Simulation =======================");
        System.out.println("Account Number: 112233");
        System.out.println("PIN: 012108");
        System.out.println("Enter Account Number: ");

        String accountNumber = in.nextLine();

        List<String> errAccount = validation.ValidateAccountNumberOrPin(accountNumber, true);
        if(!errAccount.isEmpty()){
            for (String error : errAccount) {
                System.out.println(">> " + error);
                return;
            }
        }

        System.out.println("Enter PIN: ");
        String pin = in.nextLine();

        errAccount = validation.ValidateAccountNumberOrPin(pin, false);
        if(!errAccount.isEmpty()){
            for (String error : errAccount) {
                System.out.println(">> " + error);
                return;
            }
        }
        Account account = accountDao.getLoginAccount(accountNumber, pin);
        if(account == null){
            Helper.resetActiveAccount();
            System.out.println(">> Invalid Account Number/PIN");
            return;
        } else {
            Helper.logAccountIn(account);
            transactionScreen.show();
        }
    }
}
