import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

// class to test password validation
public class PasswordValidatorTest {

    PasswordValidator validator = new PasswordValidator();

    @Test
    void testValidPassword() {
        assertTrue(validator.isValid("Password1"));
    }

    @Test
    void testTooShortPassword() {
        assertFalse(validator.isValid("Pass1"));
    }

    @Test
    void testNoUppercase() {
        assertFalse(validator.isValid("password1"));
    }

    @Test
    void testNoDigit() {
        assertFalse(validator.isValid("Password"));
    }
}
