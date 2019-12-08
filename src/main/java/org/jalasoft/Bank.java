package org.jalasoft;

import java.util.HashMap;
import java.util.Objects;

/**
 * Bank
 */
public class Bank {

    /**
     * Key: Represents the account number.
     * Value: Represents the account.
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
     */
    public int newAccount() {
        return newAccount(AccountOrigin.LOCAL);
    }

    /**
     * Creates a new account and assigns it an acocunt number and sets the balance to 0.
     * 
     * @param accountOrigin - Represents where the account was created.
     * @return The account number.
     */
    public int newAccount(final AccountOrigin accountOrigin) {
        BankAccount bankAccount = new BankAccount(nextAccount++, accountOrigin);
        accounts.put(bankAccount.getAccountNumber(), bankAccount);    
        return bankAccount.getAccountNumber();
    }

    /**
     * Given an account number it will search for the BankAccount instance
     *  - If the accountNumber does not exist it wil return 'null' 
     * 
     * TO DO: Analyse NullObjectPattern to avoid nulls
     * 
     * @param accountNumber the account number to find the BankAccountInstance.
     * @throw IllegalStateException 
     * @return a instance of BankAccount
     */
    public BankAccount getBankAccount(final int accountNumber) throws IllegalStateException {
        BankAccount account = accounts.get(accountNumber);
        if (Objects.isNull(account)) {
            throw new IllegalStateException("The account number is not registered.");
        } 
        return account;
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
            int interestToPay = (int) (account.getBalance() * interestRate);
            if (interestToPay > 0) {
                account.deposit(interestToPay);
            }
        });
        return true;
    }

    /**
     * Gets the interestRate to pay the interest.
     * 
     * @return the interestRate which will help to calculate the interest to pay.
     */
    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public String toString() {
        StringBuilder bankString = new StringBuilder("The bank has ")
        .append(accounts.size()).append(" accounts.");
        accounts.forEach((accountNumber, account) -> {
            bankString.append(System.lineSeparator())
            .append("\tAccount ").append(accountNumber)
            .append(": balance = ").append(account.getBalance());
        });
        return bankString.toString();
    }  
}