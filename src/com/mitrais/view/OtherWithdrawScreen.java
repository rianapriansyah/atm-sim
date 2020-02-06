package src.com.mitrais.view;

import src.com.mitrais.dal.TransactionService;
import src.com.mitrais.dal.TransactionServiceImpl;
import src.com.mitrais.utils.Helper;
import src.com.mitrais.utils.Validation;

import java.util.Scanner;

import static src.com.mitrais.utils.Helper.activeAccount;

public class OtherWithdrawScreen {
    private Scanner in = new Scanner(System.in);
    TransactionService service = new TransactionServiceImpl();
    Validation validation = new Validation();
    boolean onCurrentScreen = true;
    public void show(){
        do{
            screen();
        }
        while (onCurrentScreen);
    }

    private void screen(){
        Helper.showBase();
        System.out.println("Other withdraw");
        System.out.println("Enter amount to withdraw: ");

        String input = in.nextLine();
        if(!input.matches("\\d+")){
            System.out.println(">> Invalid amount");
            System.out.println();
            this.show();
        }
        int i = 0;
        try {
            i  = Integer.valueOf(input);
        }
        catch (NumberFormatException e){
            System.out.println(">> Invalid amount");
            this.show();
        }

        service.calculateWithdrawalBalance(activeAccount, i);
        onCurrentScreen = false;
    }
}
