package com.solvd.taxi.exceptions;

public class CapacityOverflowException extends Exception {
    public CapacityOverflowException () {
        super("Car is overflowed");
    }

    public CapacityOverflowException (String errorMessage) {
        super(errorMessage);
    }
}
