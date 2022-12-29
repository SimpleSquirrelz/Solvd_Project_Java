package com.solvd.taxi.interfaces;

import com.solvd.taxi.exceptions.InsufficientBalanceException;
import com.solvd.taxi.people.Human;

public interface ISolvent {
    void pay(Human human, float amount) throws InsufficientBalanceException;
    void receiveMoney(float amount);
}
