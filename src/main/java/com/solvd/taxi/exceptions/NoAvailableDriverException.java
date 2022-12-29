package com.solvd.taxi.exceptions;

public class NoAvailableDriverException extends Exception {
    public NoAvailableDriverException () {
        super("No available driver for this moment. We are not apologizing, just try again later <3");
    }

    public NoAvailableDriverException (String errorMessage) {
        super(errorMessage);
    }

}
