package src.com.mitrais.utils;

import java.util.ArrayList;
import java.util.List;

public class Validation {

    public List<String> ValidateAccountNumberOrPin(String number, boolean isAccountNumber){
        List<String> errors = new ArrayList<>();
        String head;
        if(isAccountNumber){
            head = "Account Number";
        }
        else {
            head = "PIN";
        }

        if(!number.matches("\\d+")){
            errors.add(head + " should only contains numbers  \n");
        }
        else if(number.length() != 6){
            errors.add(head + " should have 6 digits length");
        }

        return errors;
    }

    public void validateWithdrawTenMultiply(int withdrawAmount){
        if(withdrawAmount%10 != 0){
            System.out.println(">> Invalid amount");
            return;
        }
    }

    public boolean validateFundTrxAmount(String amount){
        if (amount.isEmpty()) {
            return false;
        }

        if(!amount.matches("\\d+")){
            System.out.println(">> Invalid amount");
            return false;
        }

        int fundTrxAmount = Integer.valueOf(amount);
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
