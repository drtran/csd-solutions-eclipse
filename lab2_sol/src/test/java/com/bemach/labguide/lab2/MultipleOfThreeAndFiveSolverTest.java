package com.bemach.labguide.lab2;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * from: https://projecteuler.net/problem=1
 *
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
 * The sum of these multiples is 23. Find the sum of all the multiples of 3 or 5 below 1000.
 *
 */

public class MultipleOfThreeAndFiveSolverTest {

    private MultipleOfThreeAndFiveSolver solver;

    @Before
    public void setUp() {
        solver = new MultipleOfThreeAndFiveSolver();
    }

    @Test
    public void shouldCreateAnObject() {
        assertNotNull("Object is Null!",solver);
    }

    @Test
    public void shouldReturnTrueForMultipleOfThree() {
        boolean actualResult = solver.isMultipleOfThree(3);
        assertTrue("Is Not a multipleOfThree", actualResult);
        actualResult = solver.isMultipleOfThree(12);
        assertTrue("Is Not a multipleOfThree", actualResult);
    }

    @Test
    public void shouldReturnFalseForMultipleOfThree() {
        boolean actualResult = solver.isMultipleOfThree(4);
        assertFalse("Is a multipleOfThree", actualResult);
        actualResult = solver.isMultipleOfThree(8);
        assertFalse("Is a multipleOfThree", actualResult);
    }

    @Test
    public void shouldReturnTrueForMultipleOfFive() {
        boolean actualResult = solver.isMultipleOfFive(5);
        assertTrue("Is Not a multipleOfFive", actualResult);
        actualResult = solver.isMultipleOfFive(15);
        assertTrue("Is Not a multipleOfFive", actualResult);
    }

    @Test
    public void shouldReturnFalseForMultipleOfFive() {
        boolean actualResult = solver.isMultipleOfFive(12);
        assertFalse("Is a multipleOfFive", actualResult);
        actualResult = solver.isMultipleOfFive(36);
        assertFalse("Is a multipleOfFive", actualResult);
    }

    @Test
    public void shouldReturnTrueForMultipleOfThreeAndFive() {
        boolean actualResult = solver.isMultipleOfThreeAndFive(15);
        assertTrue("Is Not a multipleOfThreeAndFive", actualResult);
        actualResult = solver.isMultipleOfThreeAndFive(30);
        assertTrue("Is Not a multipleOfThreeAndFive", actualResult);
    }

    @Test
    public void shouldReturnFalseForMultipleOfThreeAndFive() {
        boolean actualResult = solver.isMultipleOfThreeAndFive(13);
        assertFalse("Is a multipleOfThreeAndFive", actualResult);
        actualResult = solver.isMultipleOfThreeAndFive(25);
        assertFalse("Is a multipleOfThreeAndFive", actualResult);
    }
}
