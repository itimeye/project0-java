package model;

public class Account {
    private int acctId;
    private int customerId;
    private String customerName;
    private double balance;
    private String status;

    public Account(){

    }

    public Account( int customerId, String customerName, double balance,String status) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.balance = balance;
        this.status = status;
    }

    public Account(int acctId, int customerId, String customerName, double balance, String status) {
        this.acctId = acctId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.balance = balance;
        this.status = status;
    }

    public int getAcctId() {
        return acctId;
    }

    public void setAcctId(int acctId) {
        this.acctId = acctId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
