package org.jalasoft;

import java.util.HashMap;

/**
 * Bank
 */
public class Bank {

    /**
     * Key: Represents the account number.
     * Value: Represents the balance.
     */
    private HashMap<Integer, BankAccount> accounts;


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
     * @return The account number.
     * TO DO: Add support for foreign accounts.
     */
    public int newAccount() {
        int currentAccount = nextAccount++;
        BankAccount bankAccount = new BankAccount(currentAccount, AccountOrigin.LOCAL);
        accounts.put(currentAccount, bankAccount);    
        return currentAccount;
    }

    /**
     * Given an account number it will search for the BankAccount instance
     *  - If the accountNumber does not exist it wil return 'null' 
     * 
     * TO DO: Analyse NullObjectPattern to avoid nulls
     * 
     * @param accountNumber the account number to find the BankAccountInstance
     * @return a instance of BankAccount
     */
    public BankAccount getBankAccount(final int accountNumber) {
        return accounts.get(accountNumber);
    }

    /**
     * This method deposit a certain amount of money to all accounts based on a
     * interest rate
     * 
     * @return whether the interest payment process was successful or not
     * 
     * TO DO: Implementation is very unefficient
     */
    public boolean payInterest() {
        accounts.values().forEach(account -> {
            account.deposit((int) (account.getBalance() * interestRate));
        });
        return true;
    }

    @Override
    public String toString() {
        StringBuilder bankString = new StringBuilder("The bank has ")
        .append(accounts.size()).append(" accounts.");
        accounts.forEach((accountNumber, accountBalance) -> {
            bankString.append(System.lineSeparator())
            .append("\tAccount ").append(accountNumber)
            .append(": balance = ").append(accountBalance);
        });
        return bankString.toString();
    }  
}