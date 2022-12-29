package com.solvd.taxi.exceptions;

public class OutOfObjectsException extends Exception{
    public OutOfObjectsException() {
        super("There is noting to drop off");
    }

    public OutOfObjectsException(String errorMessage) {
        super(errorMessage);
    }
}
