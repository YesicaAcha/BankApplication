package org.jalasoft;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * BankAccountTest
 */
public class FreshBankAccountTest {
    private BankAccount bankAccount;

    @BeforeEach
    public void beforeEach() {
        bankAccount = new BankAccount(0, AccountOrigin.FOREIGN);
    }

    @Test
    public void depositAmountToAccount() {
        
        // Act
        bankAccount.deposit(100);

        // Assert
        assertEquals(100, bankAccount.getBalance());
    }

    @ParameterizedTest
    @ValueSource(ints = {200, 300, 400, 10000, 20000})
    public void multipleDepositActionsToAccount(final int amountToDeposit) {
       
        // Act
        bankAccount.deposit(amountToDeposit);

        // Assert
        assertEquals(amountToDeposit, bankAccount.getBalance());
    }
}