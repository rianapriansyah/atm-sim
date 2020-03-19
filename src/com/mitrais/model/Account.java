package src.com.mitrais.model;

public class Account {
    private String name;
    private String pin;
    private Integer balance;
    private String accountNumber;

    public Account(){ }

    public Account(String name, String pin, int balance, String accountNumber){
        this.name = name;
        this.pin = pin;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public String getName(){
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
        return this.balance;
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
}
