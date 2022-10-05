package Interface;

import model.Account;

import java.sql.SQLException;
import java.util.List;

public interface AccountDao {
    void addAccount(Account account) throws SQLException;
    void updateAccount(Account account) throws SQLException;
    void deleteAccount(int id) throws SQLException;
    List<Account> getAccount() throws SQLException;
    Account getAccountById(int id) throws SQLException;
}
