package Implementation;
import Connection.ConnectionFactory;
import Interface.TransactionDao;
import model.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDaoImpl implements TransactionDao {

    Connection connection;

    public TransactionDaoImpl(){
        connection = ConnectionFactory.getConnection();
    }

    @Override
    public void addTransaction(Transaction transaction) throws SQLException {
        String sql = "INSERT INTO transactoin( customerId, acctId, " +
                "status, balanceBefore, balanceAfter) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
       preparedStatement.setInt(1,transaction.getCustomerId());
       preparedStatement.setInt(2,transaction.getAcctId());
       preparedStatement.setString(3,"P");
       preparedStatement.setDouble(4,transaction.getBalanceBefore());
       preparedStatement.setDouble(5,transaction.getBalanceAfter());
        int count = preparedStatement.executeUpdate();
        if(count > 0){
            System.out.println("employee saved");
        }else{
            System.out.println("Something went wrong. Please Try agian.");
        }

    }


    @Override
    public void updateTransaction(Transaction transaction) {

    }

    @Override
    public void deleteTransaction(int id) {

    }

    @Override
    public List<Transaction> getTransactions() throws SQLException {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "select * from transaction where customerId = ?";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int transId = resultSet.getInt(1);
            int customerId = resultSet.getInt(2);
            int acctId = resultSet.getInt(3);
            double balanceBefore = resultSet.getDouble(4);
            double balanceAfter = resultSet.getDouble(5);
            Transaction transaction = new Transaction(transId, customerId, acctId, balanceBefore, balanceAfter);
            transactions.add(transaction);
        }
        return transactions;
    }

    @Override
    public Transaction getTransactionById(int id) {

        return null;
    }
}
