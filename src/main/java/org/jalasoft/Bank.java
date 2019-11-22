package org.jalasoft;

import java.util.HashMap;

/**
 * Bank
 */
public class Bank {

    /**
     * Map that contains the information of teh accounts.
     * Key: Account Number.
     * Value: Account Balance.
     */
    private HashMap<Integer, Integer> accounts;
    private int nextAccount;
    private double interestRate;

    public Bank() {
        accounts = new HashMap<>();
        nextAccount = 0;
        interestRate = 0.01;
    }
    
    /**
     * Creates a new account and assign it an account number and sets the balance to 0.
     * 
     * @return the account number.
     */
    public int newAccount() {
        int currentAccount = nextAccount++;
        accounts.put(currentAccount, 0);
        return currentAccount;
    }

    /**
     * Gets the current balance of a given account.
     * 
     * @param accountNumber the account where the balance will be checked.
     * @return the balance of the given account.
     */
    public int getBalance(int accountNumber) {
        return accounts.get(accountNumber);
    }

    /**
     * Increases the amount of balance in a given account.
     * 
     * @param accountNumber the account where the amount will be deposited.
     * @param amount the amount of money that will increase the balance.
     * 
     * @return true if the transaction was executed successfully, false otherwise.
     */
    public boolean deposit(int accountNumber, int amount) {
        int balance = getBalance(accountNumber);
        accounts.put(accountNumber, balance + amount);
        return true;
    }

    /**
     * Verifies if the loan amount requested can be assigned to a given account based on its current balance.
     * 
     * @param accountNumber the account that we will verify on.
     * @param loanAmount the requested amount to be verified.
     * @return true if the loan was approved, false otherwise.
     */
    public boolean authorizeLoan(int accountNumber, int loanAmount) {
        int balance = getBalance(accountNumber);
        return balance >= loanAmount / 2;
    }

    /**
     * Deposits a certain amount of money to all accounts based on a interest rate.
     * 
     * @return true if the interest payment process was successful, false otherwise.
     */
    public boolean payInterest() {
        accounts.forEach((accountNumber, accountBalance) -> {
            accounts.put(accountNumber, (int) (accountBalance * (1 + interestRate)));
        });
        return true;
    }

    @Override
    public String toString() {
        StringBuilder bankString = new StringBuilder("The bank has ").append(accounts.size()).append(" accounts.");
        accounts.forEach((accountNumber, accountBalance) -> {
            bankString.append(System.lineSeparator()).append("\tAccount ").append(accountNumber)
            .append(": balance = ").append(accountBalance);
        });
        return bankString.toString();
    }
}