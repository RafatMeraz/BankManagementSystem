package loginsignup;

public class User {
    private int accountNumber;
    private String name;
    private String password;
    private String dob;
    private int balance;
    private int contact;
    private String email;

    public User(int accountNumber, String name, String password, String dob, int balance, int contact, String email) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.password = password;
        this.dob = dob;
        this.balance = balance;
        this.contact = contact;
        this.email = email;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
