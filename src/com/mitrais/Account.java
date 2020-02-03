package src.com.mitrais;

public class Account {
    private String name;
    private String pin;
    private Integer balance;
    private String accountNumber;
    private String refNumber;

    public  String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPin(){
        return pin;
    }

    public void setPin(String pin){
        this.pin = pin;
    }

    public Integer getBalance(){
        return balance;
    }

    public void setBalance(Integer balance){
        this.balance = balance;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }

    public String getRefNumber(){
        return refNumber;
    }

    public void setRefNumber(String refNumber){
        this.refNumber = refNumber;
    }
}
