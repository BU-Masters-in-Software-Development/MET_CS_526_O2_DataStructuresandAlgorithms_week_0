package student;    // DO NOT REMOVE FROM SUBMITTED FILE

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
This lab is primarily concerned with familiarizing you with the development environment and style of the labs.
Complete the twoSum method
When you run this file, all test cases should print true.

2Sum Problem Statement
Given an array of integers nums and an integer target, find the two integers that add up to a target.
The answer should be returned as an array of the two indices into the array  in ascending order.
If there is no solution return None.

You should assume that there is at most 1 solution

EXAMPLE: Nums = [3,4,5,10] Target = 13
3 (index 0) + 10 (index 3) = 13
Return [0, 3]
**/

/*
I am choosing the hash table approach vs the double nested for loop approach
 for efficiency at the cost of memory heap resources...
*/


public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        // Create a map to store numbers and their indices
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            // Check if the map already contains the complement of the current number
            if (indexMap.containsKey(complement)) {
                // Return the indices of the two numbers
                return new int [] {indexMap.get(complement), i};
            }
            // Store the current number and its index in the map
            indexMap.put(nums[i], i);
        }
        return null;
    }

    /*
    DO NOT EDIT BELOW THIS
    Below is the unit testing suite for this file.
    It provides all the tests that your code must pass to get full credit.
    */
    private static void printTestResult(String testName, boolean result) {
        String color = result ? "\033[92m" : "\033[91m";
        String reset = "\033[0m";
        System.out.printf("%s[%b] %s%s\n", color, result, testName, reset);
    }

    private static void testAnswer(String testName, int[] expected, int[] actual) {
        if (Arrays.equals(actual, expected)) {
            printTestResult(testName, true);
        }
        else {
            printTestResult(testName, false);
            System.out.printf("Expected: %s \nGot:      %s\n", Arrays.toString(expected), Arrays.toString(actual));
        }
    }

    public static void runTests() {
        testExample();
        testSimple();
        testNoAnswer();
        testDuplicateValue();
        testLongerList();
    }

    private static void testExample() {
        int[] nums = new int[]{3, 4, 5, 10};
        int target = 13;
        int[] expected = new int[]{0, 3};
        testAnswer("testExample", expected, twoSum(nums, target));
    }

    private static void testSimple() {
        int[] nums = new int[]{1, 3, 7};
        int target = 8;
        int[] expected = new int[]{0, 2};
        testAnswer("testSimple", expected, twoSum(nums, target));
    }

    private static void testNoAnswer() {
        int[] nums = new int[]{1, 4, 6};
        int target = 8;
        int[] expected = null;
        testAnswer("testNoAnswer", expected, twoSum(nums, target));
    }

    private static void testDuplicateValue() {
        int[] nums = new int[]{1, 4, 4, 6};
        int target = 8;
        int[] expected = new int[]{1, 2};
        testAnswer("testDuplicateValue", expected, twoSum(nums, target));
    }

    private static void testLongerList() {
        int[] nums = new int[]{2, 6, 3, 10, 5, 7, 1, 1, 3};
        int target = 15;
        int[] expected = new int[]{3, 4};
        testAnswer("testLongerList", expected, twoSum(nums, target));
    }

    public static void main(String[] args) {
        TwoSum.runTests();
    }



}
