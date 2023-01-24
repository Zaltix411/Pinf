package com.example.calculator;

public class CalculatorModel {

    private double operator1;
    private double operator2;
    private double result;

    public CalculatorModel(double operator1, double operator2){
        this.operator1 = operator1;
        this.operator2 = operator2;
    }
    public double addition(double operator1, double operator2) {
        return result = operator1 + operator2;
    }

    public double substraction(double operator1, double operator2){
        return result = operator1 - operator2;
    }

    public double devition(double operator1, double operator2) {
        return result = operator1 / operator2;
    }

    public double multiplication(double operator1, double operator2){
        return result = operator1 * operator2;
    }
}
