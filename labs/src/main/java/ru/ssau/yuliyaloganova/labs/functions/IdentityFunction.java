package ru.ssau.yuliyaloganova.labs.functions;

import ru.ssau.yuliyaloganova.labs.ui.Functions;

@Functions(name = "Тождественная функция y=x", priority = 5)

public class IdentityFunction implements MathFunction, Cloneable {
    public double apply(double x) {
        return x;
    }

    @Override
    public String toString(){
        return "This is the IdentityFunction class";
    }

    @Override
    public boolean equals(Object o){
        return this.getClass() == o.getClass();
    }

    @Override
    public int hashCode() {
        return 31; // простейшая реализация хэш-функции
    }

    @Override
    public Object clone(){
        return new IdentityFunction();
    }
}