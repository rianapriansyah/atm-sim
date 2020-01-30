package src.com.mitrais;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Screen {
    Validation validation = new Validation();
    Account account = new Account();
    Account destAccount = new Account();
    Integer withdrawAmount = 0;
    Integer fundTrxAmount = 0;
    String refNumber = "";

    public void showWelcomeScreen(){
        this.welcomeScreen();
    }

    private void welcomeScreen(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Account Number: ");
        String accountNumber = in.next();

        Error errAccount = validation.ValidateAccountNumberOrPin(accountNumber, true);
        if(errAccount.getError()){
            System.out.println(errAccount.getErrorMessage());
            this.welcomeScreen();
        }

        System.out.println("Enter PIN: ");
        String pin = in.next();

        Error errPin = validation.ValidateAccountNumberOrPin(pin, false);

        if(errPin.getError()){
            System.out.println(errPin.getErrorMessage());
            this.welcomeScreen();
        }

        this.account = Helper.getAccountByAccountNumberAndPIN(accountNumber, pin);
        if(this.account != null){
            this.transactionScreen();
        }
        else {
            System.out.println("Invalid Account Number/PIN");
            this.welcomeScreen();
        }
    }

    private void transactionScreen(){
        Scanner in = new Scanner(System.in);
        System.out.println("1. Withdraw");
        System.out.println("2. Fund Transfer");
        System.out.println("3. Exit");
        System.out.println("Please choose option[3]: ");

        String opt = in.nextLine();
        switch (opt){
            case "1":
                this.withdrawScreen();
                break;
            case "2":
                this.fundTransferScreen();
                break;
            case "3":
            case "":
                this.welcomeScreen();
                break;
            default:
                this.transactionScreen();
                break;
        }
    }

    private void fundTransferScreen(){
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter destination account and press enter to continue \nor press enter to go back to Transaction: ");

        String accountNumber = in.nextLine();
        if(accountNumber.equals("")){
            this.transactionScreen();
        }

        Error err = validation.validateDestinationAccount(accountNumber);
        if(err.getError()){
            System.out.println(err.getErrorMessage());
            this.fundTransferScreen();
        }

        this.destAccount = Helper.getAccountByAccountNumber(accountNumber);
        if(destAccount == null){
            System.out.println("Invalid Account");
            this.fundTransferScreen();
        }
        else if(this.account == this.destAccount){
            System.out.println("Invalid Account");
            this.fundTransferScreen();
        }
        else {
            this.fundTransferScreen2();
        }
    }

    private void fundTransferScreen2(){
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter transfer amount and press enter to continue \nor press enter to go back to Transaction: ");

        String amount = in.nextLine();

        if (amount.equals("")) {
            this.transactionScreen();
        }

        if(!amount.matches("\\d+")){
            System.out.println("Invalid amount");
            System.out.println();
            this.fundTransferScreen2();
        }

        this.fundTrxAmount = Integer.parseInt(amount);
        if (this.fundTrxAmount > 1000){
            System.out.println("Maximum amount to withdraw is $1000");
            this.fundTransferScreen2();
        }

        if(this.fundTrxAmount < 1){
            System.out.println("Minimum amount to withdraw is $1");
            this.fundTransferScreen2();
        }

        Error err = validation.ValidateRemainingBalance(this.account.getBalance(), this.fundTrxAmount);
        if(err.getError()){
            System.out.println(err.getErrorMessage());
            this.transactionScreen();
        }

        this.fundTransferScreen3();
    }

    private  void fundTransferScreen3(){
        String refNumber = Helper.generateReferenceNumber().toString();
        this.refNumber = refNumber;
        System.out.printf("Reference Number: %s%n", refNumber);
        System.out.println("press enter to continue");

        Scanner in = new Scanner(System.in);

        String input = in.nextLine();
        this.fundTransferScreen4();
    }

    private void fundTransferScreen4(){

        System.out.println("Transfer Confirmation");
        System.out.printf("Destination Account : %s%n", this.destAccount.getAccountNumber());
        System.out.printf("Transfer Amount     : $ %d%n", this.fundTrxAmount);
        System.out.printf("Reference Number : %s%n", this.refNumber);
        System.out.println();
        System.out.println("1. Confirm Trx");
        System.out.println("2. Cancel Trx");
        System.out.println("Choose option[2]:");

        Scanner in = new Scanner(System.in);

        String input = in.nextLine();
        switch (input){
            case "1":
                this.transferConfirmation();
                break;
            case "2":
            default:
                this.welcomeScreen();
                break;
        }
    }

    private void transferConfirmation(){
        int sourceBalance = this.account.getBalance();
        int destBalance = this.destAccount.getBalance();
        Error err = validation.ValidateRemainingBalance(sourceBalance, this.fundTrxAmount);
        if(err.getError()){
            System.out.println(err.getErrorMessage());
            this.transactionScreen();
        }
        else {
            this.account.setBalance(sourceBalance - this.fundTrxAmount);
            this.destAccount.setBalance(destBalance + this.fundTrxAmount);
            this.fundTrxSummaryScreen();
        }
    }

    private void fundTrxSummaryScreen(){
        System.out.println("Transfer Confirmation");
        System.out.printf("Destination Account  : %s%n", this.destAccount.getAccountNumber());
        System.out.printf("Transfer Amount      : $ %d%n", this.fundTrxAmount);
        System.out.printf("Reference Number     : %s%n", this.refNumber);
        System.out.printf("Balance              : $ %d%n", this.account.getBalance());
        System.out.println();
        System.out.println("1. Transaction");
        System.out.println("2. Exit");
        System.out.println("Choose option[2]:");

        Scanner in = new Scanner(System.in);

        String input = in.nextLine();
        switch (input) {
            case "1":
                this.transactionScreen();
                break;
            case "2":
            default:
                this.welcomeScreen();
                break;
        }
    }

    private void withdrawScreen(){
        Scanner in = new Scanner(System.in);
        System.out.println("1. $10");
        System.out.println("2. $50");
        System.out.println("3. $100");
        System.out.println("4. Other");
        System.out.println("5. Back");
        System.out.println("Please choose option[5]:");

        Integer currBalance = account.getBalance();

        String opt = in.nextLine();
        switch (opt){
            case "1":
                this.withdrawAmount = 10;
                this.withdraw(currBalance);
                break;
            case "2":
                this.withdrawAmount = 50;
                this.withdraw(currBalance);
                break;
            case "3":
                this.withdrawAmount = 100;
                this.withdraw(currBalance);
                break;
            case "4":
                this.otherWithdrawScreen();
                break;
            case "5":
            default:
                this.transactionScreen();
                break;
        }
    }

    private void withdraw(int balance){
        int w = this.withdrawAmount;
        Error err = validation.ValidateRemainingBalance(balance, w);
        if(err.getError()){
            System.out.println(err.getErrorMessage());
            this.transactionScreen();
        }

        this.account.setBalance(balance - w);
        this.summaryScreen();
    }

    private void otherWithdrawScreen(){
        Integer currBalance = account.getBalance();
        Scanner in = new Scanner(System.in);
        System.out.println("Other withdraw");
        System.out.println("Enter amount to withdraw: ");

        String input = in.nextLine();
        if(!input.matches("\\d+")){
            System.out.println("Invalid amount");
            System.out.println();
            this.otherWithdrawScreen();
        }
        int i = 0;
        try {
           i  = Integer.parseInt(input);
        }
        catch (NumberFormatException e){
            System.out.println("Invalid amount");
            this.otherWithdrawScreen();
        }

        if (i > 1000){
            System.out.println("Maximum amount to withdraw is $1000");
            this.otherWithdrawScreen();
        }

        Error err = validation.validateWithdrawTenMultiply(i);
        if(err.getError()){
            System.out.println(err.getErrorMessage());
            this.otherWithdrawScreen();
        }

        err = validation.ValidateRemainingBalance(currBalance, i);
        if(err.getError()){
            System.out.println(err.getErrorMessage());
            this.transactionScreen();
        }

        this.withdrawAmount = i;
        account.setBalance(currBalance - i);
        this.summaryScreen();
    }

    public void summaryScreen(){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm a");
        String dateTimeFormatted = localDateTime.format(dateTimeFormatter);

        System.out.println("Summary");
        System.out.printf("Date     : %s%n",  dateTimeFormatted);
        System.out.printf("Withdraw : $ %d\n", this.withdrawAmount);
        System.out.printf("Balance  : $ %d\n", this.account.getBalance());
        System.out.println();
        System.out.println("1. Transaction");
        System.out.println("2. Exit");
        System.out.print("Please choose option[2]: ");
        Scanner in = new Scanner(System.in);

        String opt = in.nextLine();
        switch (opt){
            case "1":
                this.transactionScreen();
                break;
            case "2":
            default:
                this.welcomeScreen();
                break;
        }
    }
}

