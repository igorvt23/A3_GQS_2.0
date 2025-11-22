package com.example.email;

import org.springframework.stereotype.Service;

@Service
public class EmailValidator {
    public boolean isValidAddress(String address) {
        if (address == null) return false;
        return address.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }
}
