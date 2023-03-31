package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.operations.*;

public class AdditionTest {
    static Polynomial polyOne = new Polynomial("2x+1");
    static Polynomial polyTwo = new Polynomial("-17x^2-1");
    static Polynomial polyThree = new Polynomial("3x^5 + 1");
    static Polynomial polyFour = new Polynomial("2x^3   +1");
    static Polynomial polyFive = new Polynomial("0");

    static Addition addOne = new Addition(polyOne, polyTwo);
    static Addition addTwo = new Addition(polyTwo, polyThree);
    static Addition addThree = new Addition(polyFour, polyFour);
    static Addition addFour = new Addition(polyThree, polyTwo);
    static Addition addFive = new Addition(polyFive, polyTwo);
    static Addition addSix = new Addition(polyOne, polyOne);
    static Addition addSeven = new Addition(polyFive, polyFive);
    static Addition addEight = new Addition(polyThree, polyThree);
    static Addition addNine = new Addition(polyOne, polyFour);

    @Test
    public void testAddition() {
        assertEquals("2.0x-17.0x^2", addOne.getPoly());
        assertEquals("3.0x^5-17.0x^2", addTwo.getPoly());
        assertEquals("2.0+4.0x^3", addThree.getPoly());
        assertEquals("3.0x^5-17.0x^2", addFour.getPoly());
        assertEquals("-1.0-17.0x^2", addFive.getPoly());
        assertEquals("2.0+4.0x", addSix.getPoly());
        assertEquals("0", addSeven.getPoly());
        assertEquals("2.0+6.0x^5", addEight.getPoly());
        assertEquals("2.0+2.0x+2.0x^3", addNine.getPoly());
    }
}
