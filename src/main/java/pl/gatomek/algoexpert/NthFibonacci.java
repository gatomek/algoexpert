package pl.gatomek.algoexpert;

public class NthFibonacci {
    public static int getNthFib(int n) {
        if (n == 1) {
            return 0;
        }

        if (n == 2) {
            return 1;
        }

        return getNthFib(n - 2) + getNthFib(n - 1);
    }
}
