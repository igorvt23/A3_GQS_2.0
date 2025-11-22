package com.example.email;

public class EmailValidator {
    public boolean isValidAddress(String address) {
        if (address == null) return false;
        return address.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }
}
