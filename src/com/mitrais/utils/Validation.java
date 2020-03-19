package src.com.mitrais.utils;

import java.util.ArrayList;
import java.util.List;

import static src.com.mitrais.utils.Helper.activeAccount;
import static src.com.mitrais.utils.Helper.transactionAmount;

public class Validation {

    public String validateAccountNumberOrPin(String number, boolean isAccountNumber){
        String head;
        if(isAccountNumber){
            head = "Account Number";
        }
        else {
            head = "PIN";
        }

        String errors = "";
        if(!number.matches("\\d+")){
            errors = head + " should only contains numbers  \n";
        }
        else if(number.length() != 6){
            errors = head + " should have 6 digits length \n";
        }

        return errors;
    }


    public boolean validateFundTrxAmount(String amount){
        if (amount.isEmpty()) {
            return false;
        }

        if(!amount.matches("\\d+")){
            System.out.println(">> Invalid amount");
            return false;
        }

        int fundTrxAmount = Integer.parseInt(amount);
        if (fundTrxAmount > 1000){
            System.out.println(">> Maximum amount to withdraw is $1000");
            return false;
        }

        if(fundTrxAmount < 1){
            System.out.println(">> Minimum amount to withdraw is $1");
            return false;
        }

        return true;
    }
}
