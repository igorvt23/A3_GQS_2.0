package com.example.email;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class EmailRepositoryTest {
    @Test
    void saveAndCount() {
        EmailRepository repo = new EmailRepository();
        repo.save(new EmailMessage("a@a.com","b@b.com","ok","hello"));
        assertEquals(1, repo.count());
    }
}
