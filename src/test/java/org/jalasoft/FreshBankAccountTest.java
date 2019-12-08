package org.jalasoft;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * BankAccountTest
 */
public class FreshBankAccountTest {

    int initialAmount = 2000;
    private BankAccount bankAccount;

    @BeforeEach
    public void beforeEach() {
        bankAccount = new BankAccount(0, AccountOrigin.FOREIGN);
        bankAccount.deposit(initialAmount);
    }

    @Test
    public void depositAmountToAccount() {
        
        // Act
        bankAccount.deposit(100);

        // Assert
        assertEquals(2100, bankAccount.getBalance());
    }

    @ParameterizedTest
    @ValueSource(ints = {200, 300, 400, 10000, 20000})
    public void multipleDepositActionsToAccount(final int amountToDeposit) {
       
        // Act
        bankAccount.deposit(amountToDeposit);

        // Assert
        assertEquals(initialAmount + amountToDeposit, bankAccount.getBalance());
    }

    @ParameterizedTest
    @ValueSource(ints = {-200, -300, -400, -10000, -20000})
    public void multipleInvalidDepositActionsToAccount(final int amountToDeposit) {
       
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> bankAccount.deposit(amountToDeposit));
    }

    @ParameterizedTest
    @ValueSource(ints = {200, 300, 400, 1000, 2000})
    public void multipleWithdrawActionsToAccount(int amountToDeposit) {
        // Act
        bankAccount.withdraw(amountToDeposit);
        // Assert
        assertEquals(initialAmount - amountToDeposit, bankAccount.getBalance());
    }

    @ParameterizedTest
    @ValueSource(ints = {-3000, -4000, -5000, -6000})
    public void multipleInvalidWithdrawActionsToAccount(int amountToDeposit) {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(amountToDeposit));
    }

    @ParameterizedTest
    @ValueSource(ints = {3000, 4000, 5000, 6000})
    public void multipleWithdrawActionsToAccountWithInsufficientBalance(int amountToDeposit) {
        // Act & Assert
        assertThrows(ArithmeticException.class, () -> bankAccount.withdraw(amountToDeposit));
    }


    @ParameterizedTest
    @ValueSource(ints = {2000, 4000, 1000, 100})
    public void hasEnoughCollateralIntoAccount(int loanAmount) {
        assertTrue(bankAccount.hasEnoughCollateral(loanAmount));
    }
    
    @ParameterizedTest
    @ValueSource(ints = {5000, 6000, 7000, 8000, -100, -5000})
    public void doesNotHaveEnoughCollateralIntoAccount(int loanAmount) {
        assertFalse(bankAccount.hasEnoughCollateral(loanAmount));
    }
}