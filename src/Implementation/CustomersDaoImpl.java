package Implementation;

import Interface.CustomersDao;
import model.Customers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Connection.ConnectionFactory;

public class CustomersDaoImpl implements CustomersDao {

    Connection connection;

    public CustomersDaoImpl(){
        connection = ConnectionFactory.getConnection();
    }

    @Override
    public void addCustomer(Customers customer) throws SQLException {
        String sql = "insert into customers (first_name, middle_name, last_name, prfix, sufix, SS_num, DL_num, pin) values (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, customer.getFirstName());
        preparedStatement.setString(2, customer.getMiddleName());
        preparedStatement.setString(3, customer.getLastName());
        preparedStatement.setString(4, customer.getPrefix());
        preparedStatement.setString(5, customer.getSufix());
        preparedStatement.setInt(6, customer.getSsNum());
        preparedStatement.setInt(7, customer.getDlNum());
        preparedStatement.setInt(8, customer.getPin());
        int count = preparedStatement.executeUpdate();
        if(count > 0){
            System.out.println("employee saved");
        }else{
            System.out.println("Something went wrong. Please Try agian.");
        }
    }

    @Override
    public void updateCustomer(Customers customer) throws SQLException {
        String sql = "Update customers set first_name = ?, middle_name = ?, last_name = ? prefix = ? sufix = ? SS_num = ?, DL_num = ?, pin = ? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, customer.getFirstName());
        preparedStatement.setString(2, customer.getMiddleName());
        preparedStatement.setString(3, customer.getLastName());
        preparedStatement.setString(4, customer.getPrefix());
        preparedStatement.setString(5, customer.getSufix());
        preparedStatement.setInt(6, customer.getSsNum());
        preparedStatement.setInt(7, customer.getDlNum());
        preparedStatement.setInt(8, customer.getId());
        int count = preparedStatement.executeUpdate();
        if(count > 0){
            System.out.println("customer updated");
        }else{
            System.out.println("Something went wrong. Please Try agian.");
        }
    }

    @Override
    public void deleteCustomer(int id) throws SQLException {
        String sql = "delete from customers where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        int count = preparedStatement.executeUpdate();
        if(count > 0){
            System.out.println("customer deleted");
        }else{
            System.out.println("Something went wrong. Please Try agian.");
        }
    }

    @Override
    public List<Customers> getCustomers() throws SQLException {
        List<Customers> customers = new ArrayList<>();
        String sql = "select * from customers";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            int id = resultSet.getInt(1);
            String fristName = resultSet.getString(2);
            String middleName = resultSet.getString(3);
            String lastName = resultSet.getString(4);
            String prefix = resultSet.getString(5);
            String sufix = resultSet.getString(6);
            int ssNum = resultSet.getInt(7);
            int dlNum = resultSet.getInt(8);
            int pin = resultSet.getInt(9);
            Customers customer = new Customers(id, fristName, middleName, lastName, prefix, sufix, ssNum, dlNum, pin);
            customers.add(customer);
        }
        return customers;
    }

    @Override
    public Customers getCustomersByID(int custId,int pin) throws SQLException {
        Customers customers = new Customers();
        String sql = "select * from customers where customer_id = " + custId + " And pin = "+pin;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        if(resultSet != null){
            int id = resultSet.getInt(1);
            String fristName = resultSet.getString(2);
            String middleName = resultSet.getString(3);
            String lastName = resultSet.getString(4);
            String prefix = resultSet.getString(5);
            String sufix = resultSet.getString(6);
            int ssNum = resultSet.getInt(7);
            int dlNum = resultSet.getInt(8);
            int pin1 = resultSet.getInt(9);
            customers = new Customers(id, fristName, middleName, lastName, prefix, sufix, ssNum, dlNum, pin1);
        }else {
            System.out.println("No record Found.");
        }
        return customers;


    }

    @Override
    public Customers showCustomersID() throws SQLException {
      //  Customers customers = new Customers();
        String sql = "select customer_id, first_name, middle_name, last_name, pin from customers order by customer_id desc limit 1";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        if(resultSet != null) {
            int id = resultSet.getInt(1);
            String fristName = resultSet.getString(2);
            String middleName = resultSet.getString(3);
            String lastName = resultSet.getString(4);
            int pin = resultSet.getInt(5);
            return new Customers(id, fristName, middleName, lastName, pin);
        }
        else{
            System.out.println("No record Found.");
            return null ;
        }

        }
    }

