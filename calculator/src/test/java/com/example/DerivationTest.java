package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import com.example.operations.*;

public class DerivationTest {
        static Polynomial polyOne = new Polynomial("2x+1");
        static Polynomial polyTwo = new Polynomial("-17x^2-1");
        static Polynomial polyThree = new Polynomial("3x^5 + 1");
        static Polynomial polyFour = new Polynomial("2x^3   +1");
        static Polynomial polyFive = new Polynomial("0");
        static Polynomial polySix = new Polynomial("17x^10+ 4x^2+ 9x - 1");
        static Polynomial polySeven = new Polynomial("20x");
        static Polynomial polyEight = new Polynomial("13x^13-x^5-34x^2+2");
        static Polynomial polyNine = new Polynomial("-x^100");

        static Derivation one = new Derivation(polyOne);
        static Derivation two = new Derivation(polyTwo);
        static Derivation three = new Derivation(polyThree);
        static Derivation four = new Derivation(polyFour);
        static Derivation five = new Derivation(polyFive);
        static Derivation six = new Derivation(polySix);
        static Derivation seven = new Derivation(polySeven);
        static Derivation eight = new Derivation(polyEight);
        static Derivation nine = new Derivation(polyNine);

        @Test
        public void testDerivation() {
                assertEquals("2.0", one.getPoly());
                assertEquals("-34.0x", two.getPoly());
                assertEquals("15.0x^4", three.getPoly());
                assertEquals("6.0x^2", four.getPoly());
                assertEquals("0", five.getPoly());
                assertEquals("9.0+8.0x+170.0x^9",
                                six.getPoly());
                assertEquals("20.0",
                                seven.getPoly());
                assertEquals("-68.0x-5.0x^4+169.0x^12",
                                eight.getPoly());
                assertEquals("-100.0x^99", nine.getPoly());
        }
}
