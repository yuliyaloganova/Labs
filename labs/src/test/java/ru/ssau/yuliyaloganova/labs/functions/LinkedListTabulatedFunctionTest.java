package ru.ssau.yuliyaloganova.labs.functions;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class LinkedListTabulatedFunctionTest {
    double[] arr1={1,2,3};
    double[] arr2={4,5,6};
    LinkedListTabulatedFunction testLink=new LinkedListTabulatedFunction(arr1,arr2);
    @Test
    public void testgetCount(){
        assertEquals(2,testLink.getCount());
    }
    @Test
    public void testrightBound(){
        assertEquals(3.0,testLink.rightBound());
    }
    @Test
    public void testindexOfX(){
        assertEquals(1,testLink.indexOfX(2));
    }
    @Test
    public void testindexOfY(){
        assertEquals(2,testLink.indexOfY(6));
    }
    @Test
    public void testGetX() {
        assertEquals(3.0, testLink.getX(2));
        assertEquals(1.0,testLink.getX(0));
    }

    @Test
    public void testGetY(){
        assertEquals(4.0,testLink.getY(0));
        assertEquals(6.0,testLink.getY(2));
    }
    @Test
    public void testAddNode() {
        testLink.addNode(7.5, 4);
        assertEquals(3, testLink.getCount());
        assertEquals(7.5, testLink.getX(3));
        assertEquals(4, testLink.getY(3));
    }

    @Test
    public void testRemove(){
        testLink.remove(1);
        assertEquals(3,testLink.getX(1));
        assertEquals(6,testLink.getY(1));
    }

    @Test
    public void testRemove2(){
        testLink.remove(0);
        assertEquals(2,testLink.getX(0));
        assertEquals(5,testLink.getY(0));
    }

}