package com.bemach.labguide.lab2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by ktran on 5/3/2015.
 */
@RunWith(value=Parameterized.class)
public class MultipleOfThreeAndFiveUseParameterizedTest {
    private final Boolean expectedMultipleOfThreeResult;
    private final Integer multipleOfThree;
    private final Integer multipleOfFive;
    private final Boolean expectedMultipleOfFiveResult;
    private MultipleOfThreeAndFiveSolver solver;

    public MultipleOfThreeAndFiveUseParameterizedTest(Integer multipleOfThree, Boolean expectedMultipleOfThreeResult,
                                                      Integer multipleOfFive, Boolean expectedMultipleOfFiveResult) {
        this.multipleOfThree = multipleOfThree;
        this.expectedMultipleOfThreeResult = expectedMultipleOfThreeResult;
        this.multipleOfFive = multipleOfFive;
        this.expectedMultipleOfFiveResult = expectedMultipleOfFiveResult;
    }
    @Before
    public void setUp() {
        solver = new MultipleOfThreeAndFiveSolver();
    }

    @Test
    public void shouldCreateAnObject() {
        assertNotNull("Object is Null!",solver);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestParameters() {
        return Arrays.asList(new Object[][]{
                {Integer.valueOf(3), Boolean.TRUE, Integer.valueOf(5), Boolean.TRUE},
                {Integer.valueOf(12), Boolean.TRUE, Integer.valueOf(15), Boolean.TRUE},
                {Integer.valueOf(123), Boolean.TRUE, Integer.valueOf(145), Boolean.TRUE},
                {Integer.valueOf(11), Boolean.FALSE, Integer.valueOf(112), Boolean.FALSE},
                {Integer.valueOf(124), Boolean.FALSE, Integer.valueOf(322), Boolean.FALSE}
        });
    }

    @Test
    public void shouldValidateForMultipleOfThreeOrFive() {
        Boolean actualResult = solver.isMultipleOfThree(multipleOfThree);
        assertEquals(expectedMultipleOfThreeResult, actualResult);
        actualResult = solver.isMultipleOfFive(multipleOfFive);
        assertEquals(expectedMultipleOfFiveResult, actualResult);
    }
}
