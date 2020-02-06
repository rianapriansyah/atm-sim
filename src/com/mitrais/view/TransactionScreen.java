package src.com.mitrais.view;

import src.com.mitrais.utils.Helper;

import java.util.Scanner;

public class TransactionScreen {
    private Scanner in = new Scanner(System.in);
    private WithdrawScreen withdrawScreen = new WithdrawScreen();
    private FundTransferScreen fundTransferScreen = new FundTransferScreen();
    boolean onCurrentScreen = true;

    public void show(){
        do{
            screen();
        }
        while (onCurrentScreen);

    }

    public void screen(){

        Helper.showBase();

        System.out.println("1. Withdraw");
        System.out.println("2. Fund Transfer");
        System.out.println("3. Exit");
        System.out.println("Please choose option[3]: ");

        String opt = in.nextLine();
        switch (opt){
            case "1":
                withdrawScreen.show();
                break;
            case "2":
                fundTransferScreen.show();
                break;
            case "3":
                onCurrentScreen = false;
                break;
            default:
                if (opt.isEmpty()){
                    onCurrentScreen = false;
                }else {
                    this.show();
                }
                break;

        }
    }
}
