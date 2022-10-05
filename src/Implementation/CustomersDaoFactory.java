package Implementation;

import Interface.CustomersDao;

public class CustomersDaoFactory {

    private static CustomersDao customersDao;

    private CustomersDaoFactory(){

    }

    public static CustomersDao getCustomersDao(){
        if(customersDao == null){
            customersDao = new CustomersDaoImpl();
        }
        return customersDao;
    }

}
