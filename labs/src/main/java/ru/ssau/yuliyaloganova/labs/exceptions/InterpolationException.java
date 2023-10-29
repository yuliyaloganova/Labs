package ru.ssau.yuliyaloganova.labs.exceptions;

public class InterpolationException extends RuntimeException{
    public InterpolationException(){};
    public InterpolationException(String parlMess){
        super(parlMess);
    }
}
