package ru.ssau.yuliyaloganova.labs.exceptions;

public class DifferentLengthOfArraysException extends RuntimeException{
    public DifferentLengthOfArraysException(){};
    public DifferentLengthOfArraysException(String parlMess){
        super(parlMess);
    }
}
