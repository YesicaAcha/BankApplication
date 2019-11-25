package org.jalasoft;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * BankAccountTest
 */
public class BankAccountTest {

    @Test
    public void depositAmountToAccount() {
        //Arrange
        BankAccount bankAccount = new BankAccount(0, AccountOrigin.FOREIGN);

        // Act
        bankAccount.deposit(100);

        // Assert
        assertEquals(100, bankAccount.getBalance());
    }
}