package com.mitrais;

public class Account {
    private String Name;
    private String PIN;
    private Integer Balance;
    private String AccountNumber;

    public  String getName(){
        return  Name;
    }

    public void setName(String name){
        this.Name = name;
    }

    public String getPIN(){
        return PIN;
    }

    public void setPIN(String pin){
        this.PIN = pin;
    }

    public Integer getBalance(){
        return Balance;
    }

    public void setBalance(Integer balance){
        this.Balance = balance;
    }

    public String getAccountNumber(){
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber){
        this.AccountNumber = accountNumber;
    }
}
