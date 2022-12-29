package com.solvd.taxi.exceptions;

public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException () {
        super("You have no money!!!!");
    }

    public InsufficientBalanceException (String errorMessage) {
        super(errorMessage);
    }
}
