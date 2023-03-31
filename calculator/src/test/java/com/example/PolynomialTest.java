package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.operations.Polynomial;

public class PolynomialTest {

    Polynomial polyOne = new Polynomial("2x+1");
    Polynomial polyTwo = new Polynomial("-2x^2-1");
    Polynomial polyThree = new Polynomial("2x + 1");
    Polynomial polyFour = new Polynomial("2x   +1");
    Polynomial polyFive = new Polynomial("");

    @Test
    public void PolyTest() {
        assertEquals("1.0+2.0x", polyOne.returnResult(polyOne.getMonom()));
        assertEquals("-1.0-2.0x^2", polyTwo.returnResult(polyTwo.getMonom()));
        assertEquals("1.0+2.0x", polyThree.returnResult(polyThree.getMonom()));
        assertEquals("1.0+2.0x", polyFour.returnResult(polyFour.getMonom()));
        assertEquals("0", polyFive.returnResult(polyFive.getMonom()));
    }
}
