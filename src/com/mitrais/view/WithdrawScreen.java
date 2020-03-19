package src.com.mitrais.view;

import src.com.mitrais.dal.TransactionService;
import src.com.mitrais.dal.TransactionServiceImpl;
import src.com.mitrais.utils.Helper;
import src.com.mitrais.utils.Validation;

import java.util.Scanner;

import static src.com.mitrais.utils.Helper.activeAccount;

public class WithdrawScreen {
    private Scanner in = new Scanner(System.in);
    TransactionService service = new TransactionServiceImpl();
    OtherWithdrawScreen otherWithdrawScreen = new OtherWithdrawScreen();
    Validation validation = new Validation();
    boolean onCurrentScreen = true;
    public void show(){
        do{
            try{
                screen();
            }
            catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
        }
        while (onCurrentScreen);
    }

    private void screen(){
        Helper.showBase();
        System.out.println("1. $10");
        System.out.println("2. $50");
        System.out.println("3. $100");
        System.out.println("4. Other");
        System.out.println("5. Back");
        System.out.println("Please choose option[5]:");

        String opt = in.nextLine();
        switch (opt){
            case "1":
                service.setBalance(activeAccount, 10);
                break;
            case "2":
                service.setBalance(activeAccount, 50);
                break;
            case "3":
                service.setBalance(activeAccount, 100);
                break;
            case "4":
                onCurrentScreen = false;
                otherWithdrawScreen.show();
                break;
            case "5":
            default:
                onCurrentScreen = false;
                break;
        }
    }
}
