package view;
import java.util.Scanner;

public class WelcomeScreen {
    public void show(){
        this.readInput();
    }

    private void readInput(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Account Number: ");
        String account = in.next();
        System.out.println("Enter PIN: ");
        String pin = in.next();

        System.out.println("Account number inputted: "+account);
        System.out.println("PIN inputted: "+pin);
    }
}
