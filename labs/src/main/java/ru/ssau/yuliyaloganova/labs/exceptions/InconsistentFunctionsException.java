package ru.ssau.yuliyaloganova.labs.exceptions;

public class InconsistentFunctionsException extends RuntimeException {
    public InconsistentFunctionsException(){};
    public InconsistentFunctionsException(String parlMess){
        super(parlMess);
    }
}
