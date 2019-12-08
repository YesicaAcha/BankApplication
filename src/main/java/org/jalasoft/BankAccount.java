package org.jalasoft;

/**
 * BankAccount
 */
public class BankAccount {
    
    private int accountNumber;
    private AccountOrigin accountOrigin;
    private int balance;

 
    /**
     * Constructor of BankAccount.
     * 
     * @param accountNumber the unique identifier for a bank account.
     * @param AccountOrigin represent where the account was created.
     */
    public BankAccount(final int accountNumber, final AccountOrigin accountOrigin) {
        this.accountNumber = accountNumber;
        this.accountOrigin = accountOrigin;
        balance = 0;
    }

    /**
     * Gets the account number.
     * 
     * @return the unique identifier of the account.
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * Gets the current balance of a given account.
     * 
     * @return the balance of the given account.
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Gets the origin of the accout.
     * 
     * @return the origin where the account was created.
     */
    public AccountOrigin getAccountOrigin() {
        return accountOrigin;
    }

    /**
     * Increases the amount of the balance applying the following restrictions:
     * 
     * @param amount the amount that will be increased.
     * @return true if the deposit was successful, false otherwise.
     */
    public boolean deposit(final int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("The deposit amount must be grater than 0.");
        }
        balance += amount; 
        return true;
    }

    /**
     * Checks if the amount can be supported by the current balance.
     * - The balance cannot be less than half of the ammount.
     * <<explain how the check will be performed>>
     * 
     * @param amount the amount to check.
     * @return true if the amount is supported, false otherwise.
     */
    public boolean hasEnoughCollateral(final int amount) {
        return balance >= amount / 2;
    }

    /**
     * Decreases the amount of the balance applying the following restrictions:
     * - The amount cannot be greater than the current balance.
     * 
     * @param amount the amount that will be decrease.
     */
    public boolean withdraw(final int amount) {
        boolean isWithdrawAllowed = amount <= balance;
        if (isWithdrawAllowed) {
            balance -=amount;
        }
         return isWithdrawAllowed;
    }

    /**
     * Changes the account origin applying the following actions:
     * - change the limit for withdraw
     * - change the restriction for loan
     * - etc
     * 
     * @param accountOrigin the new account origin to change, it will decide how the restriction or facilities will change
     * @return
     * 
     * DO NOT IMPLEMENT IT: STILL IN DESIGN
     */
    public boolean changeAccount(final AccountOrigin accountOrigin) {
        return false;
    }
}