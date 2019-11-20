package org.jalasoft;

/**
 * Executes our bank client and manage the flow of the system
 */
public class BankProgram {

    /**
     * This method executes our bank client and manage the flow of the system
     * @param args
     */
    public static void main(String[] args) {
        BankClient bankClient = new BankClient();

        //Extra stuff

        bankClient.run();
    }
}