package Implementation;

import model.Account;
import Interface.AccountDao;

import java.sql.*;
import java.util.ArrayList;
import Connection.ConnectionFactory;
import java.util.List;

public class AccountDaoImpl implements AccountDao {

    Connection connection;

    public AccountDaoImpl(){
        connection = ConnectionFactory.getConnection();
    }

    @Override
    public void addAccount(Account account) throws SQLException {
        String sql = "insert into account (customerID, customerName, balance , status) values (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, account.getCustomerId());
        preparedStatement.setString(2, account.getCustomerName());
        preparedStatement.setDouble(3, account.getBalance());
        preparedStatement.setString(4, account.getStatus());
        int count = 0;
        try {
            count = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (count > 0) {
            System.out.println("Account Created");
        } else {
            System.out.println("Something went wrong. Please Try again.");
        }
    }

    @Override
    public void updateAccount(Account account) throws SQLException {
        String sql = "Update account set customerId = ?, customerName = ?, balance = ?, status = ? where acctId = "+account.getAcctId();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, account.getCustomerId());
        preparedStatement.setString(2, account.getCustomerName());
        preparedStatement.setDouble(3, account.getBalance());
        preparedStatement.setString(4, account.getStatus());
        int count = 0;
        try {
            count = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (count > 0) {
            System.out.println("employee updated");
        } else {
            System.out.println("OOps!, something went wrong");
        }
    }

    @Override
    public void deleteAccount(int id) throws SQLException {
        String sql = "delete from account where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("Account Deleted");
        } else {
            System.out.println("Something went wrong. Please Try again");
        }
    }

    @Override
    public List<Account> getAccount() throws SQLException {
        List<Account> accounts = new ArrayList<>();
        String sql = "select * from account";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            int customerId = resultSet.getInt(2);
            String customerName = resultSet.getString(3);
            double balance = resultSet.getDouble(4);
            String status =resultSet.getString(5);
            Account account = new Account(id,customerId, customerName, balance,status);
           accounts.add(account);
        }
        return accounts;
    }

    @Override
    public Account getAccountById(int acctId) throws SQLException {
        Account account = new Account();
        String sql = "select * from account where acctID = " + acctId;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        if (resultSet != null) {
            int id = resultSet.getInt(1);
            int customerId = resultSet.getInt(2);
            String customerName = resultSet.getString(3);
            double balance = resultSet.getDouble(4);
            String status = resultSet.getString(5);
            account = new Account(id, customerId, customerName, balance, status);
        }else{
            System.out.println("No Account Found.");
        }
        return account;
    }
}
