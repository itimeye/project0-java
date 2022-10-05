package Interface;

import model.Transaction;

import java.sql.SQLException;
import java.util.List;

public interface TransactionDao {
    void addTransaction(Transaction transaction) throws SQLException;
    void updateTransaction(Transaction transaction);
    void deleteTransaction(int id);
    List<Transaction> getTransactions() throws SQLException;
    Transaction getTransactionById(int id);
}
