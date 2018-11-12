package hw_1;

import hw_1.fibonnaci.FibonacciUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int startInterval = 0;
    private static int endInterval = 0;
    private static int fibonacciSizeSet = 0;

    private static BufferedReader br
            = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) {

        try {
            System.out.print("Enter a start of interval : ");
            startInterval = Integer.parseInt(br.readLine());

            System.out.print("Enter a end of interval : ");
            endInterval = Integer.parseInt(br.readLine());

            System.out.print("Enter the size of Fibonacci numbers set : ");
            fibonacciSizeSet = Integer.parseInt(br.readLine());

        } catch (NumberFormatException ex) {
            System.out.println("Number format error");
        } catch (IOException ex) {
            System.out.println("Reading error");
        }

        FibonacciUtil fibonacciUtil = new FibonacciUtil(startInterval, endInterval, fibonacciSizeSet);
        fibonacciUtil.printResult();
    }
}
