package org.hbrs.se1.ss25.uebung1.test;

import org.hbrs.se1.ss25.uebung1.businesslogic.HexNumberTransformer;
import org.hbrs.se1.ss25.uebung1.businesslogic.NumberTransformer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestHexNumberTransformer {


        private final NumberTransformer transformer = new HexNumberTransformer();

        // Positivtests
        @Test
        void testTransform_0() {
            assertEquals("0", transformer.transformNumber(0));
        }

        @Test
        void testTransform_255() {
            assertEquals("ff", transformer.transformNumber(255));
        }

        @Test
        void testTransform_65535() {
            assertEquals("ffff", transformer.transformNumber(65535));
        }

        // Negativtests
        @Test
        void testTransform_NegativeNumber() {
            assertEquals("Außerhalb des Wertebereiches", transformer.transformNumber(-1));
        }

        @Test
        void testTransform_TooLargeNumber() {
            assertEquals("Außerhalb des Wertebereiches", transformer.transformNumber(65536));
        }

}
