package com.solvd.taxi.exceptions;

public class UnsuitableDataTypeException extends Exception {
    public UnsuitableDataTypeException() {
        super("This data type cannot be processed");
    }

    public UnsuitableDataTypeException(String errorMessage) {
        super(errorMessage);
    }
}
