package ru.ssau.yuliyaloganova.labs.functions;

import ru.ssau.yuliyaloganova.labs.exceptions.ArrayIsNotSortedException;
import ru.ssau.yuliyaloganova.labs.exceptions.DifferentLengthOfArraysException;
import ru.ssau.yuliyaloganova.labs.exceptions.InterpolationException;

import junit.framework.Assert;
import org.junit.Test;
import ru.ssau.yuliyaloganova.labs.exceptions.ArrayIsNotSortedException;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTabulatedFunctionTest {
    double[] arr1 = {1, 2, 3};
    double[] arr2 = {4, 5, 6};
    LinkedListTabulatedFunction testLink = new LinkedListTabulatedFunction(arr1, arr2);

    @Test
    public void testgetCount() { Assert.assertEquals(3, testLink.getCount());
    }

    @Test
    public void testrightBound() {
        Assert.assertEquals(3.0, testLink.rightBound());
    }

    @Test
    public void testleftBound() { Assert.assertEquals(1.0, testLink.leftBound());}

    @Test
    public void testindexOfX() {
        Assert.assertEquals(-1, testLink.indexOfX(5));
    }

    @Test
    public void testindexOfY() {
        Assert.assertEquals(-1, testLink.indexOfY(-1));
    }

    @Test
    public void testGetX() {
        Assert.assertEquals(3.0, testLink.getX(2));
        Assert.assertEquals(1.0, testLink.getX(0));
    }

    @Test
    public void testGetY() {
        Assert.assertEquals(5.0, testLink.getY(1));
        Assert.assertEquals(6.0, testLink.getY(2));
    }

    @Test
    public void testsetY() {
        testLink.setY(0, 7.0);
        Assert.assertEquals(7.0, testLink.getY(0));
    }

    @Test
    public void testfloorIndexOfX() {
        assertEquals(1, testLink.floorIndexOfX(10));
        assertEquals(0, testLink.floorIndexOfX(1.5));
        assertEquals(1, testLink.floorIndexOfX(2.7));
    }

    @Test
    public void testFloorNodeOfX() {
        testLink.addNode(4.0, 4.0);
        assertEquals(4.0, testLink.floorNodeOfX(5.0));
    }


    @Test
    public void testextrapolateLeft() {
        assertEquals(-2.0, testLink.extrapolateLeft(-5));
    }

    @Test
    public void testextrapolateRight() {
        assertEquals(13, testLink.extrapolateRight(10));
    }

    @Test
    public void testAddNode() {
        testLink.addNode(8.5, 4.0);
        assertEquals(4.0, testLink.getCount());
        assertEquals(8.5, testLink.getX(3));
        assertEquals(6.0, testLink.getY(2));
    }

    @Test
    public void testRemove() {
        testLink.remove(1);
        assertEquals(3, testLink.getX(1));
        assertEquals(6, testLink.getY(1));
    }

    @Test
    public void testRemove2() {
        testLink.remove(0);
        assertEquals(2, testLink.getX(0));
        assertEquals(5, testLink.getY(0));
    }

    @Test
    public void toStringTest() {
        LinkedListTabulatedFunction.Node node = new LinkedListTabulatedFunction.Node(1.1, -7.5);
        String Str = node.toString();
        assertEquals("(1.1; -7.5)", node.toString());
    }

    @Test
    public void equalsTest() {
        LinkedListTabulatedFunction.Node node1 = new LinkedListTabulatedFunction.Node(5, 7);
        LinkedListTabulatedFunction.Node node2 = new LinkedListTabulatedFunction.Node(5, 7);
        boolean bool = node1.equals(node2);
        assertTrue(bool);
    }

    @Test
    public void hashCodeTest() {
        LinkedListTabulatedFunction.Node node = new LinkedListTabulatedFunction.Node(3.5, 1.2);
        LinkedListTabulatedFunction.Node node2 = new LinkedListTabulatedFunction.Node(3.5, 1.2);
        LinkedListTabulatedFunction.Node node3 = new LinkedListTabulatedFunction.Node(5, 7);
        assertEquals(node.hashCode(), node2.hashCode());
        assertNotEquals(node.hashCode(), node3.hashCode());
    }

    @Test
    public void cloneTest() {
        LinkedListTabulatedFunction.Node node = new LinkedListTabulatedFunction.Node(4, 4);
        Object nodeCopy = node.clone();
        assertEquals(node, nodeCopy);
    }

    @Test
    public void ListToStringtest(){
        assertEquals("(1.0; 4.0), (2.0; 5.0), (3.0; 6.0)", testLink.toString());
    }

    @Test
    public void ListEqualsTest() {
        double[] arr3 = {2, 7, 1, 5};
        double[] arr4 = {6, 8.5, 3, 5};
        LinkedListTabulatedFunction testLink2 = new LinkedListTabulatedFunction(arr3, arr4);
        LinkedListTabulatedFunction testLink3 = new LinkedListTabulatedFunction(arr2, arr1);
        LinkedListTabulatedFunction testLink4 = new LinkedListTabulatedFunction(arr1, arr2);
        boolean Test12 = testLink.equals(testLink2);
        boolean Test13 = testLink.equals(testLink3);
        boolean Test14 = testLink.equals(testLink4);
        assertFalse(Test12);
        assertFalse(Test13);
        assertTrue(Test14);
    }

    @Test
    public void ListHashCodeTest() {
        double[] arr3 = {2, 7, 1};
        double[] arr4 = {6, 8.5, 3};
        LinkedListTabulatedFunction testLink2 = new LinkedListTabulatedFunction(arr1, arr2);
        LinkedListTabulatedFunction testLink3 = new LinkedListTabulatedFunction(arr3, arr4);
        assertEquals(testLink.hashCode(), testLink2.hashCode());
        assertNotEquals(testLink.hashCode(), testLink3.hashCode());
    }

    @Test
    public void ListCloneTest() {
        Object cloneList = testLink.clone();
        assertEquals(testLink, cloneList);
    }

    @Test
     public void testgetNodeException() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            testLink.getNode(10);
        });
    }

    @Test
    public void testgetXException() {

        assertThrows(IllegalArgumentException.class, () -> {
            testLink.getX(10);
        });
    }

    @Test
    public void testgetYException() {

        assertThrows(IndexOutOfBoundsException.class, () -> {
            testLink.getY(-10);
        });
    }

    @Test
    public void testsetYException() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            testLink.setY(13, 10);
        });
    }

    @Test
    public void testindexOfXException() {
        assertThrows(NoSuchElementException.class, () -> {
            testLink.indexOfX(2);
        });
    }

    @Test
    public void testfloorIndexOfXException() {
        assertThrows(IllegalArgumentException.class, () -> {
            testLink.floorIndexOfX(-2);
        });
    }

    @Test
    public void testLinkedListTabulatedFunctionLengthException() {
        double[] arr3 = {5, 6, 5};
        double[] arr4 = {2, 6, 7, 95};
        assertThrows(DifferentLengthOfArraysException.class, () -> {
            LinkedListTabulatedFunction testLink2 = new LinkedListTabulatedFunction(arr3, arr4);
        });
    }

    @Test
    public void testLinkedListTabulatedFunctionSortedException() {
        double[] arr3 = {2, 3, 4, 17, 3, 45, 0};
        double[] arr4 = {2, 34, 5, 56, 7, 6, 5};
        assertThrows(ArrayIsNotSortedException.class, () -> {
            LinkedListTabulatedFunction testLink2 = new LinkedListTabulatedFunction(arr3, arr4);
        });
    }

    @Test
    public void testLinkedListInterpolateException() {
        assertThrows(InterpolationException.class, () -> {
            testLink.interpolate(2.5, 2);
        });
    }
    @Test
    public void testLinkedListIteratorException(){
        Iterator<Point> iterator= testLink.iterator();
        LinkedListTabulatedFunction.Node node=  testLink.getNode(0);
        while(iterator.hasNext())
        {
            Point point=iterator.next();
            assertEquals(node.x,point.x);
            assertEquals(node.y,point.y);
            node=node.next;
        }
        node= testLink.getNode(0);
        for(Point point: testLink)
        {
            assertEquals(node.x,point.x);
            assertEquals(node.y,point.y);
            node=node.next;
        }

    }
}