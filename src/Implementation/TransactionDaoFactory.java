package Implementation;

import Interface.AccountDao;
import Interface.CustomersDao;
import Interface.TransactionDao;

public class TransactionDaoFactory {
    private static TransactionDao transactionDao;

    private TransactionDaoFactory(){

    }

    public static TransactionDao getCustomersDao(){
        if(transactionDao == null){
            transactionDao = new TransactionDaoImpl();
        }
        return transactionDao;
    }

}
