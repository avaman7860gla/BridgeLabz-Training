import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

// class for testing
public class BankAccountTest {

    @Test
    void testDeposit() {
        BankAccount account = new BankAccount(1000);
        account.deposit(500);
        assertEquals(1500, account.getBalance());
    }

    @Test
    void testWithdrawSuccess() {
        BankAccount account = new BankAccount(1000);
        boolean result = account.withdraw(300);
        assertTrue(result);
        assertEquals(700, account.getBalance());
    }

    @Test
    void testWithdrawFailure() {
        BankAccount account = new BankAccount(500);
        boolean result = account.withdraw(800);
        assertFalse(result);
        assertEquals(500, account.getBalance());
    }
}
