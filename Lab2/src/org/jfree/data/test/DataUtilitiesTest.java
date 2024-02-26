package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.*;
import org.junit.*;

public class DataUtilitiesTest {
    private Values2D values2D;
    private KeyedValues keyedValues;

    @Before
    public void setUp() {
        DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
        values2D = testValues;
        testValues.addValue(1, 0, 0);
        testValues.addValue(4, 1, 0);
        
        DefaultKeyedValues defaultKeyedValues = new DefaultKeyedValues();
        keyedValues = defaultKeyedValues;
        defaultKeyedValues.addValue("A", 1);
        defaultKeyedValues.addValue("B", 2);
    }

    @After
    public void tearDown() {
        values2D = null;
        keyedValues = null;
    }

    @Test
    public void testValidDataAndColumnColumnTotal() {
       
    }

    @Test
    public void testNullDataColumnTotal() {
    }

    @Test
    public void testCalculateRowTotalValidData() {
        assertEquals("Row total calculation failed with valid data", 5.0, DataUtilities.calculateRowTotal(values2D, 0), 0.0000001d);
    }

    @Test
    public void testCreateNumberArrayValid() {
        double[] input = new double[]{1.0, 2.0, 3.0};
        Number[] expected = new Number[]{1.0, 2.0, 3.0};
        assertArrayEquals("Number array creation failed", expected, DataUtilities.createNumberArray(input));
    }

    @Test
    public void testCreateNumberArray2DValid() {
        double[][] input = new double[][]{{1.0, 2.0}, {3.0, 4.0}};
        Number[][] expected = new Number[][]{{1.0, 2.0}, {3.0, 4.0}};
        assertArrayEquals("2D Number array creation failed", expected, DataUtilities.createNumberArray2D(input));
    }

    @Test
    public void testGetCumulativePercentagesValid() {
        KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);
        assertEquals("Cumulative percentage calculation failed for first item", 0.3333333, result.getValue(0).doubleValue(), 0.000001);
        assertEquals("Cumulative percentage calculation failed for second item", 1.0, result.getValue(1).doubleValue(), 0.000001);
    }


}
