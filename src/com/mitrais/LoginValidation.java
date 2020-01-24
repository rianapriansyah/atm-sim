package com.mitrais;
import java.util.ArrayList;
import java.util.List;

public class LoginValidation {
    public List<Account> accountList = DataSource.setAccounts();

    public List<Error> ValidateInput(String accNumber, String pin){
        List<Error> errorMessages = new ArrayList<Error>();
        Error err;
        Account account = DataSource.getAccountByAccountNumberAndPIN(accNumber, pin);

        if(accNumber.length() != 6){
            err = new Error(true, "Account Number should have 6 digits length");
            errorMessages.add(err);
        }
        else if(!accNumber.matches("\\d+")){
            err = new Error(true, "Account Number should only contains numbers");
            errorMessages.add(err);
        }
        else if(pin.length() != 6){
            err = new Error(true, "\"PIN should have 6 digits length\"");
            errorMessages.add(err);
        }
        else if(!pin.matches("\\d+")){
            err = new Error(true, "PIN should only contains numbers");
            errorMessages.add(err);
        }
        else if(account == null){
            err = new Error(true, "Invalid Account Number/PIN");
            errorMessages.add(err);
        }

        return errorMessages;
    }
}
