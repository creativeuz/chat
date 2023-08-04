package com.payway.demochat.exception;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(UUID id) {
        super("User with ID " + id + " not found");
    }

    public UserNotFoundException(String id) {
        super("User with ID " + id + " not found");
    }
}