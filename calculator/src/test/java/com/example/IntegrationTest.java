package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import com.example.operations.*;

public class IntegrationTest {
    static Polynomial polyOne = new Polynomial("2x+1");
    static Polynomial polyTwo = new Polynomial("-17x^2-1");
    static Polynomial polyThree = new Polynomial("3x^5 + 1");
    static Polynomial polyFour = new Polynomial("2x^3   +1");
    static Polynomial polyFive = new Polynomial("0");
    static Polynomial polySix = new Polynomial("17x^10+ 4x^2+ 9x - 1");
    static Polynomial polySeven = new Polynomial("20x");
    static Polynomial polyEight = new Polynomial("13x^13-x^5-34x^2+2");
    static Polynomial polyNine = new Polynomial("-x^100");

    static Integration one = new Integration(polyOne);
    static Integration two = new Integration(polyTwo);
    static Integration three = new Integration(polyThree);
    static Integration four = new Integration(polyFour);
    static Integration five = new Integration(polyFive);
    static Integration six = new Integration(polySix);
    static Integration seven = new Integration(polySeven);
    static Integration eight = new Integration(polyEight);
    static Integration nine = new Integration(polyNine);

    @Test
    public void testIntegration() {
        assertEquals("c+x+x^2", one.getPoly());
        assertEquals("c-x-5.666666666666667x^3", two.getPoly());
        assertEquals("c+x+0.5x^6", three.getPoly());
        assertEquals("c+x+0.5x^4", four.getPoly());
        assertEquals("0", five.getPoly());
        assertEquals("c-x+4.5x^2+1.3333333333333333x^3+1.5454545454545454x^11",
                six.getPoly());
        assertEquals("c+10.0x^2",
                seven.getPoly());
        assertEquals("c+2.0x-11.333333333333334x^3-0.16666666666666666x^6+0.9285714285714286x^14",
                eight.getPoly());
        assertEquals("c-0.009900990099009901x^101", nine.getPoly());
    }
}
