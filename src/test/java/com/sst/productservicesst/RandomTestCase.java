package com.sst.productservicesst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RandomTestCase {
    @Test
    void testIsOnePlusOneIsTwo() {
        // 3 A's Arrange, Act, Assert(Check)
        int i = 1 + 1; // Arrange + Act

        //check
//        assert i == 3;

        assertEquals(2, i, "i value isn't 4, that's why test case failed.");
//
//        assertThrows(RuntimeException.class,
//                fun(100))

//        assertFalse(variable);
    }

    @Test
    void testIsTwoMultiplyByTwoIsFour() {
        int i = 2 * 2;

        assert i == 4;
    }
}
