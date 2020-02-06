package src.com.mitrais.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static src.com.mitrais.utils.Helper.*;

public class SummaryScreen {
    boolean onCurrentScreen = true;
    private Scanner in = new Scanner(System.in);
    public void show(boolean isFundTransfer, int refNumber){
        do{
            screen(isFundTransfer, refNumber);
        }
        while (onCurrentScreen);
    }

    public void screen(boolean isFundTransfer, int refNumber){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm a");
        String dateTimeFormatted = localDateTime.format(dateTimeFormatter);

        if (isFundTransfer) {
            System.out.println("Transfer Confirmation");
            System.out.printf("Destination Account  : %s%n", destinationAccount.getAccountNumber());
            System.out.printf("Transfer Amount      : $ %d%n", transactionAmount);
            System.out.printf("Reference Number     : %s%n", refNumber);
            System.out.printf("Balance              : $ %d%n", activeAccount.getBalance());
            System.out.println();
            System.out.println("1. Transaction");
            System.out.println("2. Exit");
            System.out.println("Choose option[2]:");
        }
        else {
            System.out.println("Summary");
            System.out.printf("Date     : %s%n",  dateTimeFormatted);
            System.out.printf("Withdraw : $ %d\n", transactionAmount);
            System.out.printf("Balance  : $ %d\n", activeAccount.getBalance());
            System.out.println();
            System.out.println("1. Transaction");
            System.out.println("2. Exit");
            System.out.print("Please choose option[2]: ");
        }

        String input = in.nextLine();
        switch (input) {
            case "1":
                onCurrentScreen = false;
                TransactionScreen transactionScreen = new TransactionScreen();
                transactionScreen.show();
                break;
            case "2":
            default:
                onCurrentScreen = false;
                WelcomeScreen welcomeScreen = new WelcomeScreen();
                welcomeScreen.show();
                break;
        }
    }
}
