
import java.util.Scanner;

public class pr1 {
    public static void fibonacciIteratively(int n) {
        int num1 = 0;
        int num2 = 1;
        int fib = 0;
        int stepCount = 0;

        System.out.println("Fibonacci Iteratively:");
        for (int i = 0; i < n; i++) {
            System.out.print(" " + num1);
            fib = num1 + num2;
            num1 = num2;
            num2 = fib;
            stepCount++; 
        }
        System.out.println("\nStep count (Iterative): " + stepCount);
    }

    public static int fibonacciRecursively(int n, int[] stepCounter) {
        stepCounter[0]++; 
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursively(n - 1, stepCounter) + fibonacciRecursively(n - 2, stepCounter);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();

        fibonacciIteratively(n);

        System.out.println("Fibonacci Recursively:");
        int[] stepCounter = {0}; 
        for (int i = 0; i < n; i++) {
            System.out.print(" " + fibonacciRecursively(i, stepCounter));
        }
        System.out.println("\nStep count (Recursive): " + stepCounter[0]);

        scanner.close();
    }
}
