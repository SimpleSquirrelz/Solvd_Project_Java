package com.solvd.taxi.enums;

public enum CarClass {
    POOR(100),
    CASUAL(250),
    LUX(1000);

    private final int value;
    private CarClass(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
