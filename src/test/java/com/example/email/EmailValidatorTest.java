package com.example.email;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class EmailValidatorTest {
    @Test
    void validEmail() {
        EmailValidator v = new EmailValidator();
        assertTrue(v.isValidAddress("user@example.com"));
    }
    @Test
    void invalidEmail() {
        EmailValidator v = new EmailValidator();
        assertFalse(v.isValidAddress("invalid-email"));
    }
}
