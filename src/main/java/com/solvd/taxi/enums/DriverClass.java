package com.solvd.taxi.enums;


public enum DriverClass {

    M_POOR(CarClass.POOR, Gender.MALE),
    M_CASUAL(CarClass.CASUAL,Gender.MALE),
    M_LUX(CarClass.LUX, Gender.MALE),
    W_CASUAL(CarClass.LUX, Gender.FEMALE),
    S_LUX(CarClass.POOR, Gender.SHEMALE);

    private final CarClass carClass;
    private final Gender gender;

    DriverClass(CarClass carClass, Gender gender) {
        this.carClass = carClass;
        this.gender = gender;
    }

    public CarClass getCarClass() {
        return carClass;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "DriverClass{" +
                "carClass='" + carClass + '\'' +
                ", gender=" + gender +
                '}';
    }
}
