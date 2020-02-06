package src.com.mitrais.view;

import src.com.mitrais.dal.AccountDao;
import src.com.mitrais.dal.AccountDaoImpl;

public abstract class BaseScreen {
    AccountDao accountDao;

    BaseScreen(){
        accountDao = AccountDaoImpl.getInstance();
    }
}
