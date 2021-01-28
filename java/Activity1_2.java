package javaActivity1;

import java.util.Arrays;

public class Activity1_2 {
    public static void main(String[] args) {
        //Initializing  the array
        int[] numArr = {10, 77, 10, 54, -11, 10};
        System.out.println("Original Array: " + Arrays.toString(numArr));
        
        int searchNum = 10;
        int fixedSum = 30;

        //Printing  result
        System.out.println("Result: " + result(numArr, searchNum, fixedSum));
    }

    public static boolean result(int[] numbers, int searchNum, int fixedSum) {
        int temp_sum = 0;
        for (int number : numbers) {
            if (number == searchNum) {
                temp_sum += searchNum;
            }

            if (temp_sum > fixedSum) {
                break;
            }
        }

        //Returning true if condition satisfies
        return temp_sum == fixedSum;
    }
}
