import org.junit.jupiter.api.Test;

import junit.UserRegistration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

/** Tests for the validateUsername method of class UserRegistration.
 *  Note that the tests below do not cover all the edge cases that need to be tested.
 *  This example is meant to show you how to write simple JUnit 5 tests.
 */
public class UserRegistrationTest {

    @Test
    void validateUsernameEmptyString() {
        assertFalse(UserRegistration.validateUsername(""));
    }

    @Test
    void validateUsernameTooLong() {
        assertFalse(UserRegistration.validateUsername("iChose9_TheLongestUsernameICouldThinkOf"));
    }

    @Test
    void validateUsernameTooShort() {
        assertFalse(UserRegistration.validateUsername("ssh"));
    }

    @Test
    void validateUsernameNoUnderscore() {
        assertFalse(UserRegistration.validateUsername("tiTani6c"));
    }

    @Test
    void validateUsernameNoDigit() {
        assertFalse(UserRegistration.validateUsername("user_Name"));
    }

    @Test
    void validateUsernameFirstCharNotLowerCase() {
        assertFalse(UserRegistration.validateUsername("User_Name7"));
    }

    @Test
    void validateUsernameValidName() {
        assertTrue(UserRegistration.validateUsername("user_01"));
    }

    @Test
    void validateUsernameNull() {
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.validateUsername(null));
    }

}
