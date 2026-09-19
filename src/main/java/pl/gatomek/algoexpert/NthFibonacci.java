package pl.gatomek.algoexpert;

// todo: add optimalized version with cache for previous calculated numbers

public class NthFibonacci {
    public static int getNthFib(int n) {
        if (n <= 0) {
            throw new IllegalStateException("index of Fibonacci number must be positive");
        }

        if (n == 1) {
            return 0;
        }

        if (n == 2) {
            return 1;
        }

        return getNthFib(n - 2) + getNthFib(n - 1);
    }
}
