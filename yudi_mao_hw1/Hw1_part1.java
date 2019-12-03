
/**
 * CS526 Hw1
 * Name: Yudi Mao
 * BU ID: U39319244
 */

import java.util.Arrays;
import java.util.Scanner;

public class Hw1_part1 {
    public static int sumOfSquareOfOdds(int n) {
        //This method calculates sum of squares of all positive odds <= input integer
        int sum = 0;
        // initialize sum
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                sum += i * i;
            }
        }
        return sum;
    }

    public static void shuffle(int[] a) {

        /**
         * This method exchanges the first half and the second half of an array of integers
         * If given array a has an odd number of integers, the middle number remains the same
         */

        final double mid = Math.ceil((double) a.length / 2);
        final int mid_int = (int) mid;
        //Ceiling number, for 6 is 3, for 7 is 4
        final int fhalf = a.length / 2; // for 6 and 7 are both 3
        for (int i = 0; i < fhalf; i++) {
            //only shuffle first half and second half if odd num
            int temp = a[i];
            a[i] = a[mid_int + i]; //for odd num, index of second half should be 1 more, so we use variable mid
            a[mid_int + i] = temp;
        }
    }

    public static String statistcs(double[] numbers) {

        /**
         * This method receives an array of double numbers, output the largest number, the smallest number and
         * the average of all numbers
         */

        double maxValue = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > maxValue) {
                maxValue = numbers[i];
            }
        }

        double minValue = numbers[0];
        for (int j = 1; j < numbers.length; j++) {
            if (numbers[j] < minValue) {
                minValue = numbers[j];
            }
        }

        double sum = 0;
        for (int k = 0; k < numbers.length; k++) {
            sum += numbers[k];
        }
        double ave = sum / (double) numbers.length;

        return "max: " + Double.toString(maxValue) + "\n" +
                "min: " + Double.toString(minValue) + "\n" +
                "average: " + Double.toString(ave);
    }


    public static void main(String[] args) {

        /**
         * to test method sumOfSquareOfOdds
         */

        System.out.println("Test method sumOfSquareOfOdds");
        Scanner in = new Scanner(System.in);

        System.out.println("Enter an integer (professor said to enter 10): "); //input int 10
        System.out.println("Sum of squares of odds is " + sumOfSquareOfOdds(in.nextInt()) + "\n");

        System.out.println("Enter another integer (professor said to enter 20): "); //input int 20
        System.out.println("Sum of squares of odds is " + sumOfSquareOfOdds(in.nextInt()) + "\n");

        /**
         * to test method shuffle
         */

        System.out.println("Test method shuffle");

        System.out.println("Enter length of next array (professor said to enter 20): "); //test with an array of 20 integer
        int length_1 = in.nextInt();
        System.out.println("Enter integers in this array, spilt by space: "); //enter 20 integers
        System.out.println("You might want to copy: ");
        System.out.println("1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20");
        int[] array_1 = new int[length_1];
        for (int i = 0; i < length_1; i++) {
            array_1[i] = in.nextInt();
        }
        System.out.println("Original array is: " + Arrays.toString(array_1));
        shuffle(array_1);
        System.out.println("Shuffled array is: " + Arrays.toString(array_1) + "\n");

        //test another array
        System.out.println("Enter length of next array (professor said to enter 21): "); //test with an array of 21 integer
        int length_2 = in.nextInt();
        System.out.println("Enter integers in this array, spilt by space: "); //enter 21 integers
        System.out.println("You might want to copy again: ");
        System.out.println("1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21");
        int[] array_2 = new int[length_2];
        for (int i = 0; i < length_2; i++) {
            array_2[i] = in.nextInt();
        }
        System.out.println("Original array is: " + Arrays.toString(array_2));
        shuffle(array_2);
        System.out.println("Shuffled array is: " + Arrays.toString(array_2) + "\n");

        /**
         * to test method statistics
         */

        System.out.println("Test method statistics");

        System.out.println("Enter 10 doubles, spilt by space: "); //test with an array of 10 doubles
        System.out.println("You might want to copy: ");
        System.out.println("1.1 2.2 3.3 4.4 5.5 1.2 1.3 1.4 1.5 1.6");
        double[] array_3 = new double[10];
        for (int i = 0; i < 10; i++) {
            array_3[i] = in.nextDouble();
        }
        System.out.println("Original array is: " + Arrays.toString(array_3));
        System.out.println("The statistic of this array is: ");
        System.out.println(statistcs(array_3) + "\n");

        //test one more array
        System.out.println("Enter 10 more doubles, spilt by space: "); //test with an array of 10 doubles
        System.out.println("You might want to copy: ");
        System.out.println("5.0 4.8 4.4 4.0 4.5 4.5 4.7 4.3 4.2 5.0");
        double[] array_4 = new double[10];
        for (int i = 0; i < 10; i++) {
            array_4[i] = in.nextDouble();
        }
        System.out.println("Original array is: " + Arrays.toString(array_4));
        System.out.println("The statistic of this array is: ");
        System.out.println(statistcs(array_4));
    }

}
