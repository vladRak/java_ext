package java_ext.hw_1.task_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FibonacciNumbersConsoleInput {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        int[] input = readLines();

        Long oddSum = 0L;
        Long evenSum = 0L;
        List<Long> oddArray = new ArrayList<>();
        List<Long> evenArray = new ArrayList<>();

        for (int i = input[0]; i <= input[1]; i++) {
            if (i % 2 == 0) {
                evenSum += i;
                evenArray.add(Long.valueOf(i));
            } else {
                oddSum += i;
                oddArray.add(Long.valueOf(i));
            }
        }

        List<Long> fibNumb = fibonacciNumbers(oddArray, evenArray, input);

        printArrays(oddArray,evenArray);

        System.out.println("Odd sum: " + oddSum);
        System.out.println("Even sum: " + evenSum);
        System.out.println("Percent of odd in Fibonacci numbers: " + (100 - percentOfEven(fibNumb)) + "%.");
        System.out.println("Percent of even in Fibonacci numbers: " + percentOfEven(fibNumb) + "%.");
    }

    private static int[] readLines() {
        int[] ints = new int[3];

        try {
            System.out.print("Enter a start of interval:");
            ints[0] = Integer.parseInt(br.readLine());

            System.out.print("Enter a end of interval:");
            ints[1] = Integer.parseInt(br.readLine());

            System.out.print("Enter the size of Fibonacci numbers set:");
            ints[2] = Integer.parseInt(br.readLine());

        } catch (NumberFormatException ex) {
            System.out.println("Number format error");
        } catch (IOException ex) {
            System.out.println("Reading error");
        }
        return ints;
    }

    private static List<Long> fibonacciNumbers(List<Long> oddArray, List<Long> evenArray, int[] input) {
        List<Long> f = new ArrayList<>(input[2]);
        f.add(0, oddArray.get(oddArray.size() - 1));
        f.add(1, evenArray.get(evenArray.size() - 1));
        for (int i = 2; i < input[2]; ++i) {
            f.add(i, f.get(i - 1) + f.get(i - 2));
        }
        return f;
    }

    private static void printArrays(List<Long> oddArray, List<Long> evenArray){
        for (Long i : oddArray) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = evenArray.size() - 1; i >= 0; i--) {
            System.out.print(evenArray.get(i) + " ");
        }
        System.out.println();
    }

    private static int percentOfEven(List<Long> fibonacciNumbersArray) {
        int evenFib = 0;
        for (Long l : fibonacciNumbersArray) {
            if (l % 2 == 0) {
                evenFib++;
            }
        }
        return evenFib * 100 / fibonacciNumbersArray.size();
    }
}
