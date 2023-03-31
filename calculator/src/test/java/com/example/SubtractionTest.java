package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import com.example.operations.*;

public class SubtractionTest {
    static Polynomial polyOne = new Polynomial("2x+1");
    static Polynomial polyTwo = new Polynomial("-17x^2-1");
    static Polynomial polyThree = new Polynomial("3x^5 + 1");
    static Polynomial polyFour = new Polynomial("2x^3   +1");
    static Polynomial polyFive = new Polynomial("0");

    static Subtraction One = new Subtraction(polyOne, polyTwo);
    static Subtraction Two = new Subtraction(polyTwo, polyThree);
    static Subtraction Three = new Subtraction(polyFour, polyFour);
    static Subtraction Four = new Subtraction(polyThree, polyTwo);
    static Subtraction Five = new Subtraction(polyFive, polyTwo);
    static Subtraction Six = new Subtraction(polyOne, polyOne);
    static Subtraction Seven = new Subtraction(polyFive, polyFive);
    static Subtraction Eight = new Subtraction(polyThree, polyThree);
    static Subtraction Nine = new Subtraction(polyOne, polyFour);

    @Test
    public void testSubtraction() {
        assertEquals("2.0+2.0x+17.0x^2", One.getPoly());
        assertEquals("-2.0-3.0x^5-17.0x^2", Two.getPoly());
        assertEquals("0", Three.getPoly());
        assertEquals("2.0+3.0x^5+17.0x^2", Four.getPoly());
        assertEquals("1.0+17.0x^2", Five.getPoly());
        assertEquals("0", Six.getPoly());
        assertEquals("0", Seven.getPoly());
        assertEquals("0", Eight.getPoly());
        assertEquals("2.0x-2.0x^3", Nine.getPoly());
    }
}
