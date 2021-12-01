package com.acolyte.managerapp.calculator;

public interface Calculator<T extends Number> {
    abstract double calculatrFees(T clubID);
}
