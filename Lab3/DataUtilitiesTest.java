package org.jfree.data;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class DataUtilitiesTest {
    private Values2D values2D;
    private KeyedValues keyedValues;

    @Before
    public void setUp() {
        DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
        values2D = testValues;
        testValues.addValue(1, 0, 0);
        testValues.addValue(4, 1, 0);
        testValues.addValue(3, 0, 1);
        testValues.addValue(2, 1, 1);
        
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
        assertEquals("Column total calculation failed with valid data", 5.0, 
                     DataUtilities.calculateColumnTotal(values2D, 0), 0.0000001d);
        assertEquals("Column total calculation failed with valid data", 5.0, 
                     DataUtilities.calculateColumnTotal(values2D, 1), 0.0000001d);
    }

    @Test
    public void testCalculateRowTotalValidData() {
        assertEquals("Row total calculation failed with valid data", 4.0, 
                     DataUtilities.calculateRowTotal(values2D, 0), 0.0000001d);
        assertEquals("Row total calculation failed with valid data", 6.0, 
                     DataUtilities.calculateRowTotal(values2D, 1), 0.0000001d);
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
        assertEquals("Cumulative percentage calculation failed for first item", 0.3333333, 
                     result.getValue(0).doubleValue(), 0.000001);
        assertEquals("Cumulative percentage calculation failed for second item", 1.0, 
                     result.getValue(1).doubleValue(), 0.000001);
    }

    // Keeping the original methods unchanged as per your request

    // Additional tests
    @Test
    public void testCreateNumberArrayWithEmptyData() {
        double[] input = new double[]{};
        Number[] expected = new Number[]{};
        assertArrayEquals("Number array creation with empty data failed", expected, DataUtilities.createNumberArray(input));
    }

    @Test
    public void testCreateNumberArray2DWithEmptyData() {
        double[][] input = new double[][]{};
        Number[][] expected = new Number[][]{};
        assertArrayEquals("2D Number array creation with empty data failed", expected, DataUtilities.createNumberArray2D(input));
    }

    @Test
    public void testGetCumulativePercentagesWithEmptyData() {
        KeyedValues emptyValues = new DefaultKeyedValues();
        KeyedValues result = DataUtilities.getCumulativePercentages(emptyValues);
        assertTrue("Cumulative percentages with empty data should be empty", result.getItemCount() == 0);
    }

    @Test
    public void testCreateNumberArray2DWithSingleElement() {
        double[][] input = new double[][]{{42.0}};
        Number[][] expected = new Number[][]{{42.0}};
        assertArrayEquals("2D Number array creation with single element failed", expected, DataUtilities.createNumberArray2D(input));
    }

    @Test
    public void testCreateNumberArrayWithNegativeNumbers() {
        double[] input = new double[]{-1.0, -2.0, -3.0};
        Number[] expected = new Number[]{-1.0, -2.0, -3.0};
        assertArrayEquals("Number array creation with negative numbers failed", expected, DataUtilities.createNumberArray(input));
    }

    // Example placeholders for the unchanged methods
    @Test
    public void testColumnTotalWithNegativeIndex() {
        // Your original implementation...
    }

    @Test
    public void testColumnTotalWithOutOfRangeIndex() {
        // Your original implementation...
    }
    
    // Add any other additional tests here...
}
