package com.bemach.labguide.lab2;

/**
 * Created by ktran on 4/25/2015.
 *
 * For test driven development
 *
 * from: https://projecteuler.net/problem=1
 *
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
 * The sum of these multiples is 23. Find the sum of all the multiples of 3 or 5 below 1000.
 *
 *
 */
public class MultipleOfThreeAndFiveSolver {
    public boolean isMultipleOfThree(int multipleOfThree) {
        int remainder = multipleOfThree % 3;
        return remainder == 0;
    }

    public boolean isMultipleOfFive(int multipleOfFive) {
        int remainder = multipleOfFive % 5;
        return remainder == 0;
    }

    public boolean isMultipleOfThreeAndFive(int multipleOfThreeAndFive) {
        return isMultipleOfThree(multipleOfThreeAndFive) &&
                isMultipleOfFive(multipleOfThreeAndFive);
    }

    public static void main(String[] args) {
        int maxValue = Integer.valueOf(args[0]);
        MultipleOfThreeAndFiveSolver solver = new MultipleOfThreeAndFiveSolver();
        System.out.println("Values that are multiple of 3 and 5 are: ");
        int count = 0;
        for (int value = 3; value < maxValue; value++) {
            if (solver.isMultipleOfThreeAndFive(value)) {
                count++;
                System.out.print(String.format("%d, ", value));
            }
        }
        System.out.println(String.format("\nCount: %d", count));
    }
}
