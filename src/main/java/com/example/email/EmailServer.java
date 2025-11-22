package com.example.email;

import org.springframework.stereotype.Service;

@Service
public class EmailServer {
    private EmailValidator validator;
    private EmailRepository repository;
    public EmailServer(EmailValidator validator, EmailRepository repository) {
        this.validator = validator;
        this.repository = repository;
    }
    public boolean sendEmail(EmailMessage message) {
        if (!validator.isValidAddress(message.getFrom())) return false;
        if (!validator.isValidAddress(message.getTo())) return false;
        if (message.getBody() == null || message.getBody().isBlank()) return false;
        repository.save(message);
        return true;
    }
}
