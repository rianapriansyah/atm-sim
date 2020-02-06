package src.com.mitrais.view;

import src.com.mitrais.dal.TransactionService;
import src.com.mitrais.dal.TransactionServiceImpl;
import src.com.mitrais.model.Account;
import src.com.mitrais.utils.Helper;
import src.com.mitrais.utils.Validation;


import java.util.Scanner;

import static src.com.mitrais.utils.Helper.activeAccount;
import static src.com.mitrais.utils.Helper.destinationAccount;

public class FundTransferScreen extends BaseScreen {
    private Scanner in = new Scanner(System.in);
    private FundTransferSummaryScreen fundTransferSummaryScreen = new FundTransferSummaryScreen();
    TransactionService service = new TransactionServiceImpl();
    Validation validation = new Validation();
    private WelcomeScreen welcomeScreen = new WelcomeScreen();
    boolean onCurrentScreen = true;

    public void show(){
        do{
            screen();
        }
        while (onCurrentScreen);

    }

    private void screen(){
        Helper.showBase();
        System.out.println("Please enter destination account and press enter to continue \nor press enter to go back to Transaction: ");

        String accountNumber = in.nextLine();
        if(accountNumber.isEmpty()){
            System.out.println(">> Invalid account");
            return;
        }

        Account destAccount = accountDao.getAccountByAccNumber(accountNumber);
        if(destAccount == null){
            System.out.println(">> Invalid account");
            return;
        }
        else {
            Helper.setDestinationAccount(destAccount);
        }

        System.out.println("Please enter transfer amount and press enter to continue \nor press enter to go back to Transaction: ");
        String amount = in.nextLine();

        boolean isValid = validation.validateFundTrxAmount(amount);
        if (!isValid){
            return;
        }

        String refNumber = Helper.generateReferenceNumber().toString();

        showRefNumberScreen(refNumber);
        showConfirmationScreen(Integer.valueOf(amount), refNumber);
    }

    private void showRefNumberScreen(String refNumber){

        System.out.printf("Reference Number: %s%n", refNumber);
        System.out.println("press enter to continue");
        in.nextLine();
    }

    private void showConfirmationScreen(Integer trxAmount, String refNumber){
        System.out.println("Transfer Confirmation");
        System.out.printf("Destination Account : %s%n", destinationAccount.getAccountNumber());
        System.out.printf("Transfer Amount     : $ %d%n", trxAmount);
        System.out.printf("Reference Number : %s%n", refNumber);
        System.out.println();
        System.out.println("1. Confirm Trx");
        System.out.println("2. Cancel Trx");
        System.out.println("Choose option[2]:");
        service.calculateFundTransferBalance(activeAccount, destinationAccount, trxAmount);

        String input = in.nextLine();
        switch (input){
            case "1":
                onCurrentScreen = false;
                fundTransferSummaryScreen.show();
                break;
            case "2":
            default:
                onCurrentScreen = false;
                welcomeScreen.show();
                break;
        }
    }
}