package org.jalasoft;

/**
 * BankService
 */
public class BankService {

    private Bank bank;

    public BankService() {
        bank = new Bank();
    }
    
    /**
     * Asks a given to account to bank and then grabs the balance.
     * 
     * @param accountNumber account number to check balance.
     * @return balance of a given account.
     */
    public int getBalance(int accountNumber) {
        return bank.getBankAccount(accountNumber).getBalance();
    }

    /**
     * Creates a new account and assigns it an account number and sets the balance to 0.
     * 
     * @return The account number
     */
    public int newAccount() {
        return bank.newAccount();
    }

    /**
     * Creates a new account and assign it an account number and sets the balance to 0.
     * 
     * @param accountOrigin the account origin that will be assigned to the account.
     * @return The account number.
     */
    public int newAccount(String accountOrigin) {
        // 1.- if the accountOrigin is empty we will create a local
        if (accountOrigin.isEmpty()) {
            return bank.newAccount();
        }
        
        // 2.- if the accountOrigin does not exist we will throw an exception
        AccountOrigin accountOriginCalculated = AccountOrigin.valueOf(accountOrigin.toUpperCase());
        return bank.newAccount(accountOriginCalculated);
    }

    /**
     * Increases the amount of balance in a given account.
     * 
     * @param accountNumber the account where the amount will be deposited.
     * @param amount        the amount of money that will increase the balance.
     */
    public void deposit(final int accountNumber, final int amount) {
        bank.getBankAccount(accountNumber).deposit(amount);
    }

     /**
     * Verifies if the amount requested can be assigned to a given account based on its current balance.
     * 
     * @param accountNumber the account that we will verify on
     * @param loanAmount    the requested amount to be verified
     * @return whether the amount was approved or not
     */
    public boolean authorizeLoan(int accountNumber, int loanAmount) {
        return bank.getBankAccount(accountNumber).hasEnoughCollateral(loanAmount);
    }

    /**
     * Deposits a certain amount of money to all accounts based on an interest rate.
     */
    public void payInterest() { 
        bank.payInterest();
    }

    /**
     * Decreases the amount of balance in a given account.
     * 
     * @param accountNumber the account where the amount will be withdrawed.
     * @param amount        the amount of money that will decrease the balance.
     */
    public void withdraw(final int accountNumber, final int amount) { 
        bank.getBankAccount(accountNumber).withdraw(amount);
    }

    /**
     * Gets the bank information.
     * 
     * @return the bank information with using the bank own format
     */
    public String getBankInformation() {
        return bank.toString();
    }
}