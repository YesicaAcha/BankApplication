package org.jalasoft;

/**
 * Bank
 */
public class Bank {

    
    /**
     * Create a new account and assign it an account number and sets the balance to 0
     * 
     * @return the account number
     */
    public int newAccount() {
        /*
        current = nextAccount++;
        accounts.put(current, 0);
        System.out.println("Your new account number is " + current);
        */
        return 1;
    }

    /**
     * Return the current balance of a given account
     * @param accountNumber the account where the balance will be checked
     * @return the balance of the given account
     */
    public int getBalance(int accountNumber) {
        return 0;
    }

    /**
     * This increases the amount of balance in a given account
     * 
     * @param accountNumber the account where the amount will be deposited
     * @param amount the amount of money that will increase the balance
     * 
     * @return if the transaction was executed successfully
     */
    public boolean deposit(int accountNumber, int amount) {
        /*
        System.out.print("Enter deposit amount: ");
        int amount = scanner.nextInt();
        int balance = accounts.get(current);
        accounts.put(current, balance + amount);
        */

        return true;
    }

    /**
     * Verify if the amount requested can be assigned to a given account based on its current balance
     * 
     * @param accountNumber the account that we will verify on
     * @param loanAmount the requested amount to be verified
     * @return whether the amount was approved or not
     */
    public boolean authorizeLoan(int accountNumber, int loanAmount) {
        /*
        System.out.print("Enter loan amount: ");
        
        int loanAmmount = scanner.nextInt();
        int balance = accounts.get(current);

        if (balance >= loanAmmount / 2)
            System.out.println("Your loan is approved");
        else
            System.out.println("Your loan is denied");
        */
        return true;
    }

    /**
     * This method deposit a certain amount of money to all accounts based on a interest rate
     * @return whether the interest payment process was successful or not
     */
    public boolean payInterest() {
        /*
        Set<Integer> accountIndetifiers = accounts.keySet();
        for (int indetifier : accountIndetifiers) {
            int balance = accounts.get(indetifier);
            int newbalance = (int) (balance * (1 + interestRate));
            accounts.put(indetifier, newbalance);
        }
        */
        return false;
    }

    @Override
    public String toString() {
        /*
        Set<Integer> accountIndetifiers = accounts.keySet();
        System.out.println("The bank has " + accountIndetifiers.size() + " accounts.");
        for (int indentifier : accountIndetifiers)
            System.out.println("\tAccount " + indentifier + ": balance=" + accounts.get(indentifier));
            
        */
        return "";
    }
}