package View;

import Implementation.AccountDaoFactory;
import Implementation.CustomersDaoFactory;
import Implementation.TransactionDaoFactory;
import Interface.AccountDao;
import Interface.CustomersDao;
import Interface.TransactionDao;
import com.sun.tools.javac.Main;
import model.Account;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Employ_menu {
    static TransactionDao tra_dao = TransactionDaoFactory.getCustomersDao();
    static CustomersDao dao = CustomersDaoFactory.getCustomersDao();
    static AccountDao daoAccount = AccountDaoFactory.getCustomersDao();
    static Scanner scanner=new Scanner(System.in);
    public static void menu()
    {
        System.out.println("press 1 to See pending account");
        System.out.println("press 2 to See all account");
        System.out.println("press 3 to see a particular account");
        System.out.println("Press 4 to quit ");
    }
    public static void show() throws SQLException {
        List<Account> acc=daoAccount.getAccount();
        menu();
        int choice = scanner.nextInt();
        boolean flag=true;
        while (flag)
        {
            switch (choice)
            {
                case 1:{
                    System.out.println("Select the Account number you want to change Status : ");
                    show_pending_one(acc);
                    int acc_num=scanner.nextInt();
                    change_status(acc,acc_num);
                break;
                }
                case 2:
                {
                    show_all(acc);
                    break;
                }
                case 3:{
                    System.out.println("Enter the customer id you want to see account");
                    int id=scanner.nextInt();
                    Account account=CustomerMenu.get_acc(acc,id);
                    if(account!=null)
                    {
                        System.out.println("Account Holder name : "+account.getCustomerName());
                        System.out.println("Account Holder Number : "+account.getAcctId());
                        System.out.println("Account Holder balance : "+account.getBalance());

                    }
                    break;
                }
                case 4: {
                    flag = false;
                    Main_menu.main_menu();
                    break;

                }
                default:{
                menu();
                 choice = scanner.nextInt();}
            }
            menu();
            choice = scanner.nextInt();
        }

    }

    private static void change_status(List<Account> acc, int acc_num) throws SQLException {
        scanner.nextLine();
        Account require = null;
        for (Account account:acc)
        {
            if(account.getAcctId()==acc_num){
             require=account;
            }
        }
        System.out.println("Enter the status you wan to update : ");
        String c=scanner.nextLine();
        if(c.equals("P")||c.equals("A")||c.equals("R")&&require!=null)
        {
            require.setStatus(c);
            daoAccount.updateAccount(require);
            System.out.println("done");
        }
        else {
            System.out.println("invalid choice ");
        }

    }

    private static void show_pending_one(List<Account> acc ) {
        for (Account account:acc)
        {
            if(account.getStatus().equals("P")){
            System.out.println("Account Holder name : "+account.getCustomerName());
            System.out.println("Account Holder Number : "+account.getAcctId());
            }
        }
    }
    private static void show_all(List<Account> acc ) {
        for (Account account:acc)
        {

            System.out.println("Account Holder name : "+account.getCustomerName());
            System.out.println("Account Holder Number : "+account.getAcctId());

        }
    }
}
