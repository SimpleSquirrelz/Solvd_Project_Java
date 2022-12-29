package com.solvd.taxi.interfaces;

import com.solvd.taxi.exceptions.CapacityOverflowException;
import com.solvd.taxi.exceptions.EmptyInputException;
import com.solvd.taxi.exceptions.UnsuitableDataTypeException;

import java.util.List;

public interface IStorable {
    void pickUp(List<Object> objects) throws CapacityOverflowException, UnsuitableDataTypeException, EmptyInputException;
    void dropOff(List<Object> object);
}
