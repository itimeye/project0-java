package model;

public class Customers {
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String prefix;
    private String sufix;
    private int ssNum;
    private int dlNum;
    private int pin;

    public Customers(){}

    public Customers(int id, String firstName, String middleName, String lastName, String prefix, String sufix, int ssNum, int dlNum, int pin) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.prefix = prefix;
        this.sufix = sufix;
        this.ssNum = ssNum;
        this.dlNum = dlNum;
        this.pin = pin;
    }

    public Customers(int id, String fristName, String middleName, String lastName, int pin) {
        this.id=id;
        this.firstName=fristName;
        this.lastName=lastName;
        this.middleName=middleName;
        this.lastName=lastName;
        this.pin=pin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSufix() {
        return sufix;
    }

    public void setSufix(String sufix) {
        this.sufix = sufix;
    }

    public int getSsNum() {
        return ssNum;
    }

    public void setSsNum(int ssNum) {
        this.ssNum = ssNum;
    }

    public int getDlNum() {
        return dlNum;
    }

    public void setDlNum(int dlNum) {
        this.dlNum = dlNum;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", prefix='" + prefix + '\'' +
                ", sufix='" + sufix + '\'' +
                ", ssNum=" + ssNum +
                ", dlNum=" + dlNum +
                ", pin=" + pin +
                '}';
    }
}
