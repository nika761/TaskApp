package com.example.taskapp.utils;

import java.util.ArrayDeque;
import java.util.Deque;

public class AnotherTasks {

    //// Task 1 - Is text a palindrome
    public static boolean isPalindrome(String text) {
        int i = 0, j = text.length() - 1;
        while (i < j) {
            if (text.charAt(i) != text.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    ////

    //// Task 2 - Split coins
    private static int minSplit(int amount) {

        int[] coins = {1, 5, 10, 20, 50};

        if (amount == 0) return 0;

        int result = Integer.MAX_VALUE;

        for (int current : coins) {
            if (current <= amount) {
                int subResult = minSplit(amount - current);
                if (subResult != Integer.MAX_VALUE && subResult + 1 < result)
                    result = subResult + 1;
            }
        }
        return result;
    }
    ////

    //// Task 3 - Min value from Array
    private static int notContains(int[] array) {
        int minValue = array[0];

        for (int current : array) {
            if (current < minValue) {
                minValue = current;
            }
        }

        return minValue - 1;
    }
    ////

    //// Task 4 - Is ( ) Properly
    private static boolean isProperly(String text) {

        Deque<Character> characterDeque = new ArrayDeque<>();

        for (int i = 0; i < text.length(); i++) {
            char x = text.charAt(i);

            if (x == '(') {
                characterDeque.push(x);
                continue;
            }

            if (characterDeque.isEmpty())
                return false;

            if (x == ')') {
                characterDeque.pop();
            }

        }
        return (characterDeque.isEmpty());
    }
    ////

    //// Task 5 - Stair Count Variants
    private static int countVariants(int n) {
        switch (n) {
            case 0:

            case 1:
                return 1;

            case 2:
                return 2;

            default:
                return countVariants(n - 2) + countVariants(n - 1);
        }
    }
    ////

}
