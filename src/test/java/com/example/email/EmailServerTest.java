package com.example.email;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class EmailServerTest {
    @Test
    void sendEmailSuccess() {
        EmailValidator v = mock(EmailValidator.class);
        EmailRepository repo = new EmailRepository();
        when(v.isValidAddress(anyString())).thenReturn(true);
        EmailServer server = new EmailServer(v, repo);
        EmailMessage msg = new EmailMessage("a@a.com","b@b.com","ok","hello");
        assertTrue(server.sendEmail(msg));
        assertEquals(1, repo.count());
    }
    @Test
    void sendEmailFailsInvalidAddress() {
        EmailValidator v = new EmailValidator();
        EmailRepository repo = new EmailRepository();
        EmailServer server = new EmailServer(v, repo);
        EmailMessage msg = new EmailMessage("invalid","b@b.com","ok","hello");
        assertFalse(server.sendEmail(msg));
        assertEquals(0, repo.count());
    }
}
