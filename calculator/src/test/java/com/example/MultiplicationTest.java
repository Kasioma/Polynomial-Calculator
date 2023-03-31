package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import com.example.operations.*;

public class MultiplicationTest {
    static Polynomial polyOne = new Polynomial("2x+1");
    static Polynomial polyTwo = new Polynomial("-17x^2-1");
    static Polynomial polyThree = new Polynomial("3x^5 + 1");
    static Polynomial polyFour = new Polynomial("2x^3   +1");
    static Polynomial polyFive = new Polynomial("0");

    static Multiplication One = new Multiplication(polyOne, polyTwo);
    static Multiplication Two = new Multiplication(polyTwo, polyThree);
    static Multiplication Three = new Multiplication(polyFour, polyFour);
    static Multiplication Four = new Multiplication(polyThree, polyTwo);
    static Multiplication Five = new Multiplication(polyFive, polyTwo);
    static Multiplication Six = new Multiplication(polyOne, polyOne);
    static Multiplication Seven = new Multiplication(polyFive, polyFive);
    static Multiplication Eight = new Multiplication(polyThree, polyThree);
    static Multiplication Nine = new Multiplication(polyOne, polyFour);

    @Test
    public void testMultiplication() {
        assertEquals("-1.0-2.0x-17.0x^2-34.0x^3", One.getPoly());
        assertEquals("-1.0-17.0x^2-3.0x^5-51.0x^7", Two.getPoly());
        assertEquals("1.0+4.0x^3+4.0x^6", Three.getPoly());
        assertEquals("-1.0-17.0x^2-3.0x^5-51.0x^7", Four.getPoly());
        assertEquals("0", Five.getPoly());
        assertEquals("1.0+4.0x+4.0x^2", Six.getPoly());
        assertEquals("0", Seven.getPoly());
        assertEquals("1.0+6.0x^5+9.0x^10", Eight.getPoly());
        assertEquals("1.0+2.0x+2.0x^3+4.0x^4", Nine.getPoly());
    }
}
