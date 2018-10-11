package java_ext.hw_1.fibonnaci;

import java.util.ArrayList;
import java.util.List;

public class FibonacciUtil {
    private int startInterval;
    private int endInterval;
    private int fibonacciSizeSet;
    private List<Long> oddArray = new ArrayList<>();
    private List<Long> evenArray = new ArrayList<>();
    private Long oddSum = 0L;
    private Long evenSum = 0L;


    public FibonacciUtil(int startInterval, int endInterval, int fibonacciSizeSet) {
        this.startInterval = startInterval;
        this.endInterval = endInterval;
        this.fibonacciSizeSet = fibonacciSizeSet;
    }

    public void printResult() {

        /*
        1. Очень много связного кода. Нету четкого разграничение действий.
        2. main метод и считывает строку и считает и печатает в консоль. По Мартину на 1 метод 1 действие в определенной абстаркции.
        3. Так же, как по мне, нету смысла здесь в static методах внутри класса.
        */

        countNumbersSum();
        List<Long> fibonacciNumbers = createFibonacci();
        printArrays(oddArray, evenArray);

        System.out.println("Odd sum: " + oddSum);
        System.out.println("Even sum: " + evenSum);
        System.out.println(
                "Percent of odd in Fibonacci numbers: "
                        + (100 - percentOfEven(fibonacciNumbers)) + "%.");
        System.out.println(
                "Percent of even in Fibonacci numbers: "
                        + percentOfEven(fibonacciNumbers) + "%.");
    }


    private List<Long> createFibonacci() {
        List<Long> fibonacciSet = new ArrayList<>();
        fibonacciSet.add(0, oddArray.get(oddArray.size() - 1));
        fibonacciSet.add(1, evenArray.get(evenArray.size() - 1));
        for (int i = 2; i < fibonacciSizeSet; ++i) {
            fibonacciSet.add(i, fibonacciSet.get(i - 1) + fibonacciSet.get(i - 2));
        }
        return fibonacciSet;
    }

    private void countNumbersSum() {
        for (int i = startInterval; i <= endInterval; i++) {
            if (i % 2 == 0) {
                evenSum += i;
                evenArray.add(Long.valueOf(i));
            } else {
                oddSum += i;
                oddArray.add(Long.valueOf(i));
            }
        }
    }

    private void printArrays(List<Long> oddArray, List<Long> evenArray) {
        for (Long i : oddArray) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = evenArray.size() - 1; i >= 0; i--) {
            System.out.print(evenArray.get(i) + " ");
        }
        System.out.println();
    }

    private int percentOfEven(List<Long> fibonacciNumbersArray) {
        int evenFib = 0;
        for (Long l : fibonacciNumbersArray) {
            if (l % 2 == 0) {
                evenFib++;
            }
        }
        return evenFib * 100 / fibonacciNumbersArray.size();
    }
}
