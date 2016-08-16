package com.github.puddingspudding;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for {@link LongPredicates}.
 */
public class LongPredicatesTest {

    @Test
    public void isEqualTo() {
        assertTrue(LongPredicates.isEqualTo(1L).test(1L));
        assertFalse(LongPredicates.isEqualTo(1L).test(2L));
    }

    @Test
    public void isNotEqualTo() {
        assertFalse(LongPredicates.isNotEqualTo(1L).test(1L));
        assertTrue(LongPredicates.isNotEqualTo(1L).test(2L));
    }

    @Test
    public void IsBiggerThan() {
        assertTrue(LongPredicates.isBiggerThan(1L).test(2L));
        assertFalse(LongPredicates.isBiggerThan(1L).test(1L));
        assertFalse(LongPredicates.isBiggerThan(1L).test(0L));
    }

    @Test
    public void isSmallerThan() {
        assertFalse(LongPredicates.isSmallerThan(1L).test(2L));
        assertFalse(LongPredicates.isSmallerThan(1L).test(1L));
        assertTrue(LongPredicates.isSmallerThan(1L).test(0L));
    }

    @Test
    public void isEqualOrBiggerThan() {
        assertTrue(LongPredicates.isEqualOrBiggerThan(1L).test(1L));
        assertTrue(LongPredicates.isEqualOrBiggerThan(1L).test(2L));
        assertFalse(LongPredicates.isEqualOrBiggerThan(1L).test(0L));
    }

    @Test
    public void isEqualOrSmallerThan() {
        assertTrue(LongPredicates.isEqualOrSmallerThan(1L).test(1L));
        assertFalse(LongPredicates.isEqualOrSmallerThan(1L).test(2L));
        assertTrue(LongPredicates.isEqualOrSmallerThan(1L).test(0L));
    }

    @Test
    public void isInRange() {
        assertTrue(LongPredicates.isInRange(0L).apply(99L).test(99L));
        assertTrue(LongPredicates.isInRange(0L).apply(99L).test(0L));
        assertTrue(LongPredicates.isInRange(0L).apply(99L).test(50L));
        assertFalse(LongPredicates.isInRange(0L).apply(99L).test(100L));
        assertFalse(LongPredicates.isInRange(0L).apply(99L).test(-1L));
    }

    @Test
    public void isNotInRange() {
        assertFalse(LongPredicates.isNotInRange(0L).apply(99L).test(99L));
        assertFalse(LongPredicates.isNotInRange(0L).apply(99L).test(0L));
        assertFalse(LongPredicates.isNotInRange(0L).apply(99L).test(50L));
        assertTrue(LongPredicates.isNotInRange(0L).apply(99L).test(100L));
        assertTrue(LongPredicates.isNotInRange(0L).apply(99L).test(-1L));
    }

    @Test
    public void isNegative() {
        assertTrue(LongPredicates.isNegative().test(-1L));
        assertFalse(LongPredicates.isNegative().test(0L));
        assertFalse(LongPredicates.isNegative().test(1L));
    }

    @Test
    public void isPositive() {
        assertTrue(LongPredicates.isPositive().test(1L));
        assertFalse(LongPredicates.isPositive().test(0L));
        assertFalse(LongPredicates.isPositive().test(-1L));
    }

    @Test
    public void isEven() {
        assertTrue(LongPredicates.isEven().test(2L));
        assertFalse(LongPredicates.isEven().test(1L));
    }

    @Test
    public void idOdd() {
        assertTrue(LongPredicates.isOdd().test(1L));
        assertFalse(LongPredicates.isOdd().test(2L));
    }

}