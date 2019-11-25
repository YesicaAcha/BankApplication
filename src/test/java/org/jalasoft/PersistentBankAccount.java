package org.jalasoft;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * PersistentBankAccount
 */
public class PersistentBankAccount {

    private static BankAccount bankAccount;
    
    @BeforeAll
    public static void beforeAll() {
        bankAccount = new BankAccount(0, AccountOrigin.FOREIGN);
    }

    @ParameterizedTest
    @CsvSource({
        "100, 100",
        "40, 140",
        "10, 150",
        "200, 350"
    })
    public void multipleDepositActionsToAccount(final int amountToDeposit, final int expectedBalanceAfterDeposit) {
       
        // Act
        bankAccount.deposit(amountToDeposit);

        // Assert
        assertEquals(expectedBalanceAfterDeposit, bankAccount.getBalance());
    }
}