package org.jfree.data;

import java.io.Serializable;

/**
 * Represents an immutable range of values.
 */
public strictfp class Range implements Serializable {

    /** For serialization. */
    private static final long serialVersionUID = -906333695431863380L;
    
    /** The lower bound of the range. */
    private double lower;

    /** The upper bound of the range. */
    private double upper;

    /**
     * Creates a new range.
     *
     * @param lower  the lower bound (must be <= upper bound).
     * @param upper  the upper bound (must be >= lower bound).
     */
    public Range(double lower, double upper) {
        // Mutation 1: Absolute Value Insertion (AVI)
        if (Math.abs(lower) > upper) { // Mutated line
            String msg = "Range(double, double): require lower (" + lower 
                + ") <= upper (" + upper + ").";
            throw new IllegalArgumentException(msg);
        }
        this.lower = lower;
        this.upper = upper;
    }

    /**
     * Returns the lower bound for the range.
     *
     * @return The lower bound.
     */
    public double getLowerBound() {
        return this.lower;
    }

    /**
     * Returns the upper bound for the range.
     *
     * @return The upper bound.
     */
    public double getUpperBound() {
        return this.upper;
    }

    /**
     * Returns the length of the range.
     *
     * @return The length.
     */
    public double getLength() {
        return this.upper - this.lower;
    }

    /**
     * Returns the central (or median) value for the range.
     *
     * @return The central value.
     */
    public double getCentralValue() {
        // Mutation 5: Return Values Change (RVC)
        return this.lower; // Mutated line
    }

 

    /**
     * Tests whether this range intersects with another.
     * 
     * @param lower the lower bound of the range to check.
     * @param upper the upper bound of the range to check.
     * @return true if there are values in the range that are within this range.
     */
    public boolean intersects(double lower, double upper) {
        // Mutation 4: Logical Connector Replacement (LCR)
        if (lower <= this.lower || upper > this.lower) { // Mutated line
            return (upper > this.lower);
        }
        else {
            return (upper < this.upper && upper >= lower);
        }
    }

    /**
     * Combines two ranges into a new range that spans both.
     *
     * @param range1 the first range.
     * @param range2 the second range.
     * @return A new range that spans both input ranges.
     */
    public static Range combine(Range range1, Range range2) {
        // Mutation 3: Relational Operator Replacement (ROR)
        if (range1 != null) { // Mutated line
            return range2;
        }
    }

    /**
     * Shifts the range by a specified amount.
     * 
     * @param base the base range.
     * @param delta the amount to shift the range by.
     * @param allowZeroCrossing if true, allows crossing zero, otherwise clamps at zero.
     * @return the shifted range.
     */
    public static Range shift(Range base, double delta, boolean allowZeroCrossing) {
        // Mutation 2: Arithmetic Operator Replacement (AOR)
        if (allowZeroCrossing) {
            return new Range(base.getLowerBound() - delta, // Mutated line
                             base.getUpperBound() - delta); // Mutated line
        }
        else {
            return new Range(shiftWithNoZeroCrossing(base.getLowerBound(), -delta), // Mutated line
                             shiftWithNoZeroCrossing(base.getUpperBound(), -delta)); // Mutated line
        }
    }

    /**
     * Tests this object for equality with an arbitrary object.
     *
     * @param obj the object to test against (null permitted).
     * @return true if the input object is an equivalent range.
     */
    // ...

    /**
     * Returns a hash code for this object.
     * 
     * @return A hash code for this range.
     */
    // ...

    /**
     * Returns a string representation of this Range.
     *
     * @return A String "Range[lower,upper]".
     */
    // ...
}
