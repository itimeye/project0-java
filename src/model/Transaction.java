package model;

public class Transaction {
    private int transId;
    private int customerId;
    private int acctId;
    private double balanceBefore;
    private double balanceAfter;

    public int getTransId() {
        return transId;
    }

    public void setTransId(int transId) {
        this.transId = transId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getAcctId() {
        return acctId;
    }

    public void setAcctId(int acctId) {
        this.acctId = acctId;
    }

    public double getBalanceBefore() {
        return balanceBefore;
    }

    public void setBalanceBefore(double balanceBefore) {
        this.balanceBefore = balanceBefore;
    }

    public double getBalanceAfter() {
        return balanceAfter;
    }

    public void setBalanceAfter(double balanceAfter) {
        this.balanceAfter = balanceAfter;
    }

    public Transaction(int transId, int customerId, int acctId, double balanceBefore, double balanceAfter) {
        this.transId = transId;
        this.customerId = customerId;
        this.acctId = acctId;
        this.balanceBefore = balanceBefore;
        this.balanceAfter = balanceAfter;
    }

    public Transaction(int customerId, int acctId, double balanceBefore, double balanceAfter) {
        this.customerId = customerId;
        this.acctId = acctId;
        this.balanceBefore = balanceBefore;
        this.balanceAfter = balanceAfter;
    }
}
