package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import com.example.operations.*;

public class DivisionTest {
    static Polynomial polyOne = new Polynomial("2x+1");
    static Polynomial polyTwo = new Polynomial("-17x^2-1");
    static Polynomial polyThree = new Polynomial("3x^5 + 1");
    static Polynomial polyFour = new Polynomial("2x^3   +1");
    static Polynomial polyFive = new Polynomial("0");

    static Division One = new Division(polyOne, polyTwo);
    static Division Two = new Division(polyTwo, polyThree);
    static Division Three = new Division(polyFour, polyFour);

    @Test
    public void testDivision() {
        assertEquals("0", One.getR());
        assertEquals("1.0+2.0x", One.getQ());
        assertEquals("0", Two.getR());
        assertEquals("-1.0-17.0x^2", Two.getQ());
        assertEquals("0", Three.getR());
        assertEquals("1.0", Three.getQ());
    }

}
