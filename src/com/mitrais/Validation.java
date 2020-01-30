package src.com.mitrais;
import java.util.ArrayList;
import java.util.List;

public class Validation {
    public List<Account> accountList = DataSource.setAccounts();

    public Error ValidateAccountNumberOrPin(String number, boolean isAccountNumber){
        Error err = new Error();
        String errMsg = "";
        String head;
        if(isAccountNumber){
            head = "Account Number";
        }
        else {
            head = "PIN";
        }

        if(!number.matches("\\d+")){
            errMsg = head + " should only contains numbers  \n";
            err.setError(true);
        }
        else if(number.length() != 6){
            errMsg += head + " should have 6 digits length";
            err.setError(true);
        }

        err.setErrorMessage(errMsg);

        return err;
    }

    public Error ValidateRemainingBalance(Integer balance, Integer withdraw){
        Error err = new Error();
        if(balance < withdraw){
            err.setError(true);
            err.setErrorMessage("Insufficient Balance $" + withdraw);
        }

        return err;
    }

    public Error validateWithdrawTenMultiply(int withdrawAmount){
        Error err = new Error();
        if(withdrawAmount%10 != 0){
            err.setError(true);
            err.setErrorMessage("Invalid Amount");
        }

        return  err;
    }

    public Error validateDestinationAccount(String dest){
        Error err = new Error();
        if(!dest.matches("\\d+")){
            err.setError(true);
            err.setErrorMessage("Invalid account");
        }

        return err;
    }
}
