package model;

public class Account {
    public String Name;
    public String PIN;
    public Double Balance;
    public String AccountNumber;

   public Account(String name, String pin, Double balance, String accountNumber){
        this.Name = name;
        this.PIN = pin;
        this.Balance = balance;
        this.AccountNumber = accountNumber;
   }
}
