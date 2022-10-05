package Interface;

import model.Customers;

import java.sql.SQLException;
import java.util.List;

public interface CustomersDao {
    void addCustomer(Customers customer) throws SQLException;
    void updateCustomer(Customers customer) throws SQLException;
    void deleteCustomer(int id) throws SQLException;
    List<Customers> getCustomers() throws SQLException;
    Customers getCustomersByID( int id,int pin) throws SQLException;

    Customers showCustomersID() throws SQLException;
}
