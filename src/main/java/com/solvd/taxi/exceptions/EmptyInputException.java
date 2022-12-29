package com.solvd.taxi.exceptions;

public class EmptyInputException extends Exception {
    public EmptyInputException () {
        super("Input collection is empty.");
    }

    public EmptyInputException (String errorMessage) {
        super(errorMessage);
    }
}
