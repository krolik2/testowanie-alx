package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TriangleAreaTest {

    @Test
    public void testInputLengthEquals3True() {
        String[] testStringArr = { "9", "4", "6" };
        assertTrue(TriangleArea.inputLengthEquals3(testStringArr));
    }

    @Test
    public void testInputLengthEquals3False() {
        String[] testStringArr = { "1", "2" };
        assertFalse(TriangleArea.inputLengthEquals3(testStringArr));
    }

    @Test
    public void testInputIsNumberTrue() {
        String[] testStringArr = { "9", "4", "6" };
        assertTrue(TriangleArea.inputIsNumber(testStringArr));
    }

    @Test
    public void testInputIsNumberFalse() {
        String[] testStringArr = { "9", "4", "x" };
        assertFalse(TriangleArea.inputIsNumber(testStringArr));
    }

    @Test
    public void testCanMakeTriangleTrue() {
        assertTrue(TriangleArea.canMakeTriangle(5, 4, 3));
    }

    @Test
    public void testCanMakeTriangleFalse() {
        assertFalse(TriangleArea.canMakeTriangle(1, 2, 3));
    }

    @Test
    public void testCalculateTriangleArea1() {
        double condition = TriangleArea.calculateTriangleArea(11, 25, 30);
        assertEquals(132.0, condition, 0.1);
    }

    @Test
    public void testCalculateTriangleArea2() {
        double condition = TriangleArea.calculateTriangleArea(5, 4, 3);
        assertEquals(6.0, condition, 0.1);
    }

}
