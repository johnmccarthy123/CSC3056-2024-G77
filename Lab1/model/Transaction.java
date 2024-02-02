package model;

import java.util.Date;

public class Transaction {
    private String account_number;
    private double transaction_amount;
    private Date transaction_date;

    // Getter for account_number
    public String getAccountNumber() {
        return account_number;
    }

    // Setter for account_number
    public void setAccountNumber(String account_number) {
        this.account_number = account_number;
    }

    // Getter for transaction_amount
    public double getTransactionAmount() {
        return transaction_amount;
    }

    // Setter for transaction_amount
    public void setTransactionAmount(double transaction_amount) {
        this.transaction_amount = transaction_amount;
    }

    // Getter for transaction_date
    public Date getTransactionDate() {
        return transaction_date;
    }

    // Setter for transaction_date
    public void setTransactionDate(Date transaction_date) {
        this.transaction_date = transaction_date;
    }
	public String toString() {
		return account_number + ", " + transaction_amount + ", " + transaction_date;
	}
    
}
