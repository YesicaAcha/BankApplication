package org.jalasoft;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * PersistentBankAccount
 */
public class PersistentBankAccount {

    private static int initialAmount = 2000;
    private static BankAccount bankAccount;
    
    @BeforeAll
    static void beforeAll() {
        bankAccount = new BankAccount(0, AccountOrigin.FOREIGN);
        bankAccount.deposit(initialAmount);
    }

    @ParameterizedTest
    @CsvSource({
        "100, 2100",
        "40, 2140",
        "10, 2150",
        "200, 2350"
    })
    public void multipleDepositActionsToAccount(final int amountToDeposit, final int expectedBalanceAfterDeposit) {
       
        // Act
        bankAccount.deposit(amountToDeposit);

        // Assert
        assertEquals(expectedBalanceAfterDeposit, bankAccount.getBalance());
    }

    @ParameterizedTest
    @CsvSource({
        "100, 1900",
        " 40, 1860",
        " 10, 1850",
        "200, 1650"
    })
    public void multipleWithdrawActionsToAccount(int amountToDeposit, int expectedBalanceAfterDeposit) {
        bankAccount.withdraw(amountToDeposit);
        assertEquals(expectedBalanceAfterDeposit, bankAccount.getBalance());
    }
}