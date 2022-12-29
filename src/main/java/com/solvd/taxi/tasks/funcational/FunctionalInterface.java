package com.solvd.taxi.tasks.funcational;

import com.solvd.taxi.interfaces.ITaxCalculator;

import java.util.List;

public class FunctionalInterface {
    public static void main(String[] args) {
        var elements = List.of(
                new Values(10.3, 7.5),
                new Values(0, 7.5),
                new Values(10.3, 0),
                new Values(-1, 10),
                new Values(5, -3),
                new Values(-7, -3.5)
        );
        ITaxCalculator calculator = Double::sum;
        elements.stream()
                .map(el -> calculator.calculateTax(el.getVal1(), el.getVal2()))
                .forEach(System.out::println);
    }

    static class Values {
        private double val1;
        private double val2;

        public Values(double val1, double val2) {
            this.val1 = val1;
            this.val2 = val2;
        }

        public double getVal1() {
            return val1;
        }

        public double getVal2() {
            return val2;
        }
    }
}
