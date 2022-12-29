package com.solvd.taxi.exceptions;

public class NoAvailableOperatorException extends Exception{
    public NoAvailableOperatorException () {
        super("No available operator for this moment.");
    }

    public NoAvailableOperatorException (String errorMessage) {
        super(errorMessage);
    }
}
