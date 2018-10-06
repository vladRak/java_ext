package java_ext.hw_1.task_1;

public class FibonacciNumbers {


    public static void main(String[] args) {

        long oddSum = 0;
        long evenSum = 0;
        int[] oddArray;
        int[] evenArray;
        int[] ints = new int[3];

        try {
            for (int i = 0; i < args.length; i++) {
                ints[i] = Integer.parseInt(args[i]);
            }

            int interval = ints[1] - ints[0] + 1;

            if (interval % 2 == 0) {
                oddArray = new int[interval / 2];
                evenArray = new int[interval / 2];
            } else if (ints[0] % 2 == 0) {
                oddArray = new int[interval / 2];
                evenArray = new int[interval / 2 + 1];
            } else {
                oddArray = new int[interval / 2 + 1];
                evenArray = new int[interval / 2];
            }

            int oddCount = 0;
            int evenCount = 0;

            for (int i = ints[0]; i <= ints[1]; i++) {
                if (i % 2 == 0) {
                    evenSum += i;
                    evenArray[evenCount] = i;
                    evenCount++;
                } else {
                    oddSum += i;
                    oddArray[oddCount] = i;
                    oddCount++;
                }
            }

            long[] f = new long[ints[2]];
            f[0] = oddArray[oddArray.length - 1];
            f[1] = evenArray[evenArray.length -1];
            int evenFib = 1;
            for (int i = 2; i < ints[2]; ++i) {
                f[i] = f[i - 1] + f[i - 2];
                if (f[i] % 2 == 0) {
                    evenFib++;
                }
            }

            int oddPerc = (f.length - evenFib) * 100 / f.length;
            int evenPerc = evenFib * 100 / f.length;

            for (int i : oddArray) {
                System.out.print(i + " ");
            }
            System.out.println();

            for (int i = evenArray.length - 1; i >= 0; i--) {
                System.out.print(evenArray[i] + " ");
            }
            System.out.println();

            System.out.println("Odd sum: " + oddSum);
            System.out.println("Even sum: " + evenSum);
            System.out.println("Percent of odd in Fibonacci numbers: " + oddPerc + "%.");
            System.out.println("Percent of even in Fibonacci numbers: " + evenPerc + "%.");

        } catch (NumberFormatException ex) {
            System.out.println("Values must be numbers.");
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Exception.");
            System.out.println(ex.getMessage());
        }
    }
}
