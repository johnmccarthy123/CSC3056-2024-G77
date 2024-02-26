package org.jfree.data.test;

import junit.framework.TestCase;
import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class RangeTest {
    private Range exampleRange1, exampleRange2;

    @Before
    public void setUp() throws Exception {
        exampleRange1 = new Range(-1, 1);
        exampleRange2 = new Range(1, 3);
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
        Range shifted = Range.shift(exampleRange1, 2);
        assertEquals("Shifting exampleRange1 by 2 should result in range from 1 to 3", 
                     new Range(1, 3), shifted);
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
}
