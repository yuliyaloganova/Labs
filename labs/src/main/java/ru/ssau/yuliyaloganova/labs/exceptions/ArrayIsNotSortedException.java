package ru.ssau.yuliyaloganova.labs.exceptions;

public class ArrayIsNotSortedException extends RuntimeException{
    public ArrayIsNotSortedException(){};
    public ArrayIsNotSortedException(String parlMess){
        super(parlMess);
    }
}
