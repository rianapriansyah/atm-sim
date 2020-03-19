package src.com.mitrais;

import src.com.mitrais.dal.AccountDao;
import src.com.mitrais.dal.AccountDaoImpl;
import src.com.mitrais.view.WelcomeScreen;

public class Main {

    public static void main(String[] args) {

        WelcomeScreen welcomeScreen = new WelcomeScreen();
        do{
            welcomeScreen.show(null);
        }
        while (true);
    }
}
