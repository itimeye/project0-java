package View;

import Implementation.AccountDaoFactory;
import Implementation.CustomersDaoFactory;
import Implementation.TransactionDaoFactory;
import Interface.AccountDao;
import Interface.CustomersDao;
import Interface.TransactionDao;
import model.Account;
import model.Customers;
import model.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerMenu {
   static TransactionDao tra_dao = TransactionDaoFactory.getCustomersDao();
    static CustomersDao dao = CustomersDaoFactory.getCustomersDao();
    static AccountDao daoAccount = AccountDaoFactory.getCustomersDao();
    public static void newCustomer() throws SQLException {


//        //customers dao
//        CustomersDao dao = CustomersDaoFactory.getCustomersDao();
//
//        Customers customers = new Customers(1,"John", "Stewart", "Smith", "Mr.", "", 1234567890, 998875);
//        dao.addCustomer(customers);
        //menu creation

        Scanner scanner = new Scanner(System.in);



        boolean flag = true;
        while (flag) {
            System.out.println("++++++++++++++++++++++++++++++");
            System.out.println("Select an Option Bellow");
            System.out.println("++++++++++++++++++++++++++++++");
            System.out.println("1. New Customer");
            System.out.println("2. Returning Customer"); //GET CUSTOMER BY ID
            System.out.println("3. Home"); //return to main menu

            int input = scanner.nextInt();
            switch (input) {
                case 1: {//new customer
                    System.out.println("Enter First Name: ");
                    String firstName = scanner.next();
                    System.out.println("Enter Middle Name: ");
                    String middleName = scanner.next();
                    System.out.println("Enter Last Name: ");
                    String lastName = scanner.next();
                    System.out.println("Enter Prefix: ");
                    String prefix = scanner.next();
                    System.out.println("Enter Sufix: ");
                    String sufix = scanner.next();
                    System.out.println("Enter Social Security Number: ");
                    int ssNum = scanner.nextInt();
                    System.out.println(" Enter Driver License Number: ");
                    int dlNum = scanner.nextInt();
                    System.out.println(" Enter 4-6 digit pin: ");
                    int pin = scanner.nextInt();
                    System.out.println("Your New Account number is: ");
                    System.out.println("");
                    Customers customers = new Customers();
                    customers.setFirstName(firstName);
                    customers.setMiddleName(middleName);
                    customers.setLastName(lastName);
                    customers.setPrefix(prefix);
                    customers.setSufix(sufix);
                    customers.setSsNum(ssNum);
                    customers.setDlNum(dlNum);
                    customers.setPin(pin);
//                    Customers customer = dao.showCustomersID();
                    dao.addCustomer(customers);
                    System.out.println("Your Customer Id is: ");

                    Customers customer = dao.showCustomersID();
                    System.out.println(customer.getId());

                    break;
                }
                case 2: {//Returning customer
                    System.out.println("Enter your Customer ID: ");
                    int id = scanner.nextInt();
                    System.out.println("Enter your Pin: ");
                    int pin = scanner.nextInt();
                    Customers customer = dao.getCustomersByID(id, pin);
                    System.out.println(customer);
                    user_menu();
                    int choice = scanner.nextInt();
                    List<Account> acc = daoAccount.getAccount();
                    boolean run = true;
                    while (run) {
                        if (choice == 1) {
                            System.out.println("Enter the Amount you wanna add into your system : ");
                            double amount = scanner.nextInt();
                            daoAccount.addAccount(new Account(customer.getId(), customer.getFirstName() + customer.getLastName() + customer.getLastName(), amount, "P"));
                        }
                        if (choice == 2) {
                            Account account = get_acc(acc, id);
                            System.out.println("Enter the balance you want to add : ");
                            int balance = scanner.nextInt();
                            tra_dao.addTransaction(new Transaction(account.getCustomerId(),
                                    account.getAcctId(), account.getBalance(),
                                    account.getBalance() + balance));
                            account.setBalance(account.getBalance() + balance);
                            daoAccount.updateAccount(account);
                        }

                        if (choice == 3) {
                            Account account = get_acc(acc, id);
                            System.out.println("Enter the balance you want to Withdraw : ");
                            int balance = scanner.nextInt();
                            tra_dao.addTransaction(new Transaction(account.getCustomerId(),
                                    account.getAcctId(), account.getBalance(),
                                    account.getBalance() - balance));
                            account.setBalance(account.getBalance() - balance);
                            daoAccount.updateAccount(account);
                        }
                        if (choice == 4) {
                            Account account = get_acc(acc, id);

                            System.out.println("Your balnce is : " + account.getBalance());

                        }
                        if (choice==6)
                        {
                            break;
                        }
                        if (choice==5)
                        {
                            Account account=get_acc(acc,id);
                            System.out.println("Enter the customer id of the Reciver Account : ");
                           int rec_id= scanner.nextInt();
                            System.out.println("Enter the amount you wanna add");
                            int amn=scanner.nextInt();
                            assert account != null;
                            tranfer(acc,account.getAcctId(),rec_id,amn);
                        }
                        user_menu();
                        choice = scanner.nextInt();
                    }
                    break;
                }


            case 3: { //home
                //need to call main menu
                System.out.println("Returning to Home Screen");
                Main_menu.main_menu();
                break;
            }
            default:
                System.out.println("Choose Between 1-3");
        }
    }

}

    public static  Account get_acc(List<Account> acc, int id) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> ids = new ArrayList<>();
        for (Account account : acc) {
            if (account.getCustomerId() == id) {
                ids.add(account.getAcctId());
            }
        }
            System.out.println("Please select the account you want to perform transation : ");
            for (int id_ : ids) {
                System.out.println("Account Number = " + id_);
            }
            int acc_id = scanner.nextInt();
            for (Account accounts : acc) {
                if (accounts.getAcctId() == acc_id) {
                    return accounts;
                }
            }

        return null;
    }
    public static void tranfer(List<Account> acc,int Sender,int Reciver,int amount) throws SQLException {
        Account Reciver_Acc = null;
        Account Sender_Acc = null;
        for(Account account:acc)
        {
            if(account.getAcctId()==Reciver)
            {
                Reciver_Acc=account;
            }
            if (account.getAcctId()==Sender)
            {
                Sender_Acc=account;
            }
        }
        if(Reciver_Acc!=null&&Sender_Acc!=null&&Sender_Acc.getBalance()>amount&&Reciver_Acc.getStatus()!="P"&&Sender_Acc.getStatus()!="P")
        {
        tra_dao.addTransaction(new Transaction(Reciver_Acc.getCustomerId(),Reciver_Acc.
                getAcctId(),Reciver_Acc.getBalance(),Reciver_Acc.getBalance()+amount));
        tra_dao.addTransaction(new Transaction(Sender_Acc.getCustomerId(),Sender_Acc.
                getAcctId(),Sender_Acc.getBalance(),Sender_Acc.getBalance()-amount));

        Sender_Acc.setBalance(Sender_Acc.getBalance()-amount);
        Reciver_Acc.setBalance(Sender_Acc.getBalance()+amount);
        daoAccount.updateAccount(Sender_Acc);
        daoAccount.updateAccount(Reciver_Acc);
            System.out.println("Transferd");
        }
        else
            System.out.println("Transaction erron");
    }
    public static void trans_menu()
    {
        System.out.println("Press 2 for Add balance in your Account :  ");
        System.out.println("Press 3 to withdraw the amount : ");
        System.out.println("Press 4 to View your balance");
        System.out.println("Press 5 to transfer to an account");
        System.out.println("Press 6 to quit");
    }
    public static void user_menu()
    {
        System.out.println("Press 1 to create Account : ");
        trans_menu();
    }
}
