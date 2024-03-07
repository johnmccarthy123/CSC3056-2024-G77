package org.jfree.data;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class RangeTest {
    private Range exampleRange1, exampleRange2, exampleRange3;

    @Before
    public void setUp() throws Exception {
        exampleRange1 = new Range(-1, 1);
        exampleRange2 = new Range(1, 3);
        exampleRange3 = new Range(0, 4);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCentralValueShouldBeZero() {
        assertEquals("The central value of -1 and 1 should be 0",
                     0, exampleRange1.getCentralValue(), 0.000000001d);
    }

    @Test
    public void testCombineWithNull() {
        Range combined = Range.combine(null, exampleRange1);
        assertEquals("Combining a null range with a non-null range should return the non-null range",
                     exampleRange1, combined);
    }

    @Test
    public void testCombineTwoNulls() {
        Range combined = Range.combine(null, null);
        assertNull("Combining two null ranges should return null", combined);
    }

    @Test
    public void testExpandToInclude() {
        Range expanded = Range.expandToInclude(exampleRange1, 2);
        assertEquals("Expanding exampleRange1 to include 2 should result in range from -1 to 2",
                     new Range(-1, 2), expanded);
    }

    @Test
    public void testShift() {
        Range shiftedPositive = Range.shift(exampleRange1, 2);
        assertEquals("Shifting exampleRange1 by 2 should result in range from 1 to 3",
                     new Range(1, 3), shiftedPositive);

        Range shiftedNegative = Range.shift(exampleRange1, -2);
        assertEquals("Shifting exampleRange1 by -2 should result in range from -3 to -1",
                     new Range(-3, -1), shiftedNegative);

        Range shiftedZero = Range.shift(exampleRange1, 0);
        assertEquals("Shifting exampleRange1 by 0 should result in the same range",
                     exampleRange1, shiftedZero);
    }

    @Test
    public void testConstrain() {
        double constrainedBelow = exampleRange1.constrain(-2);
        assertEquals("Constraining -2 should result in -1",
                     -1, constrainedBelow, 0.000000001d);

        double constrainedAbove = exampleRange1.constrain(2);
        assertEquals("Constraining 2 should result in 1",
                     1, constrainedAbove, 0.000000001d);

        double constrainedWithin = exampleRange1.constrain(0);
        assertEquals("Constraining 0 should still result in 0",
                     0, constrainedWithin, 0.000000001d);
    }

    @Test
    public void testContains() {
        assertTrue("exampleRange1 should contain 0", exampleRange1.contains(0));
        assertFalse("exampleRange1 should not contain 2", exampleRange1.contains(2));
    }

    @Test
    public void testExpandToIncludeWithinRange() {
        Range expanded = Range.expandToInclude(exampleRange3, 2);
        assertEquals("Expanding exampleRange3 to include 2 should not change the range",
                     exampleRange3, expanded);
    }

    @Test
    public void testShiftNegativeDelta() {
        Range shifted = Range.shift(exampleRange2, -3);
        assertEquals("Shifting exampleRange2 by -3 should result in range from -2 to 0",
                     new Range(-2, 0), shifted);

        Range shiftedToLowerBound = Range.shift(exampleRange2, -1);
        assertEquals("Shifting exampleRange2 to lower bound should result in range from 0 to 2",
                     new Range(0, 2), shiftedToLowerBound);

        Range shiftedToUpperBound = Range.shift(exampleRange2, -2);
        assertEquals("Shifting exampleRange2 to upper bound should result in range from 1 to 3",
                     new Range(1, 3), shiftedToUpperBound);
    }

    @Test
    public void testShiftZeroDelta() {
        Range shifted = Range.shift(exampleRange2, 0);
        assertEquals("Shifting exampleRange2 by 0 should result in the same range",
                     exampleRange2, shifted);
    }

    @Test
    public void testConstrainAtLowerBound() {
        double constrained = exampleRange3.constrain(0);
        assertEquals("Constraining 0 should result in 0",
                     0, constrained, 0.000000001d);
    }

    @Test
    public void testConstrainAtUpperBound() {
        double constrained = exampleRange3.constrain(4);
        assertEquals("Constraining 4 should result in 4",
                     4, constrained, 0.000000001d);
    }

    @Test
    public void testContainsLowerBound() {
        assertTrue("exampleRange3 should contain 0", exampleRange3.contains(0));
    }

    @Test
    public void testContainsUpperBound() {
        assertTrue("exampleRange3 should contain 4", exampleRange3.contains(4));
    }

    @Test
    public void testContainsOutsideLower() {
        assertFalse("exampleRange1 should not contain -2", exampleRange1.contains(-2));
    }

    @Test
    public void testContainsOutsideUpper() {
        assertFalse("exampleRange2 should not contain 4", exampleRange2.contains(4));
    }

    // Additional tests to improve coverage based on the previous suggestions
    @Test
    public void testCombineOverlappingRanges() {
        Range combined = Range.combine(exampleRange1, exampleRange2);
        assertEquals("Combining overlapping ranges should result in the correct range",
                     new Range(-1, 3), combined);
    }

    @Test
    public void testCombineNonOverlappingRanges() {
        Range combined = Range.combine(new Range(-10, -5), new Range(5, 10));
        assertNull("Combining non-overlapping ranges should result in null", combined);
    }

    @Test
    public void testPrecisionOfCentralValue() {
        Range range = new Range(-1.0000001, 1.0000001);
        assertEquals("The central value calculation should handle precision correctly",
                     0, range.getCentralValue(), 0.0000001d);
    }

    @Test
    public void testExpandToIncludeNullRangeLowerBoundary() {
        Range expanded = Range.expandToInclude(null, -1);
        assertEquals("Expanding a null range to include -1 should result in the correct range",
                     new Range(-1, -1), expanded);
    }

    @Test
    public void testExpandToIncludeNullRangeUpperBoundary() {
        Range expanded = Range.expandToInclude(null, 1);
        assertEquals("Expanding a null range to include 1 should result in the correct range",
                     new Range(1, 1), expanded);
    }
}
