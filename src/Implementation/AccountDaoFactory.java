package Implementation;

import Interface.AccountDao;
import Interface.CustomersDao;

public class AccountDaoFactory {
    private static AccountDao accountDao;

    private AccountDaoFactory(){

    }

    public static AccountDao getCustomersDao(){
        if(accountDao == null){
            accountDao = new AccountDaoImpl();
        }
        return accountDao;
    }

}
