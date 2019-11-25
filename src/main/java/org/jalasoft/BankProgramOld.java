package org.jalasoft;

import java.util.*;

public class BankProgramOld {
    private HashMap<Integer, Integer> accounts = new HashMap<>();
    private double interestRate = 0.01;

    private int nextAccount = 0;
    private int current = 0;

    private Scanner scanner;

    private boolean done = false;

    public static void main(String[] args) {
        BankProgramOld program = new BankProgramOld();
        program.run();
    }

    private void run() {
        scanner = new Scanner(System.in);
        while (!done) {
            System.out.print("Enter command (0=quit, 1=new, 2=select, 3=deposit, 4=loan, 5=show, 6=interest): ");
            int cnum = scanner.nextInt();
            processCommand(cnum);
        }
        scanner.close();
    }

    private void processCommand(int cnum) {
        if (cnum == 0)
            quit();
        else if (cnum == 1)
            newAccount();
        else if (cnum == 2)
            select();
        else if (cnum == 3)
            deposit();
        else if (cnum == 4)
            authorizeLoan();
        else if (cnum == 5)
            showAll();
        else if (cnum == 6)
            addInterest();
        else
            System.out.println("illegal command");
    }

    private void quit() {
        done = true;
        System.out.println("Goodbye!");
    }

    public int newAccount() {
        current = nextAccount++;
        accounts.put(current, 0);
        System.out.println("Your new account number is " + current);
        return current;
    }

    private void select() {
        System.out.print("Enter account#: ");
        current = scanner.nextInt();
        int balance = accounts.get(current);
        System.out.println("The balance of account " + current + " is " + balance);
    }

    public void deposit() {
        System.out.print("Enter deposit amount: ");
        int amount = scanner.nextInt();
        int balance = accounts.get(current);
        accounts.put(current, balance + amount);
    }

    private void authorizeLoan() {
        System.out.print("Enter loan amount: ");
        
        int loanAmmount = scanner.nextInt();
        int balance = accounts.get(current);

        if (balance >= loanAmmount / 2)
            System.out.println("Your loan is approved");
        else
            System.out.println("Your loan is denied");
    }

    private void showAll() {
        Set<Integer> accountIndetifiers = accounts.keySet();
        System.out.println("The bank has " + accountIndetifiers.size() + " accounts.");
        for (int indentifier : accountIndetifiers)
            System.out.println("\tAccount " + indentifier + ": balance=" + accounts.get(indentifier));
    }

    private void addInterest() {
        Set<Integer> accountIndetifiers = accounts.keySet();
        for (int indetifier : accountIndetifiers) {
            int balance = accounts.get(indetifier);
            int newbalance = (int) (balance * (1 + interestRate));
            accounts.put(indetifier, newbalance);
        }
    }
}