package com.example.email;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class EmailRepository {
    private List<EmailMessage> inbox = new ArrayList<>();
    public void save(EmailMessage message) { inbox.add(message); }
    public List<EmailMessage> getAll() { return inbox; }
    public int count() { return inbox.size(); }
}
