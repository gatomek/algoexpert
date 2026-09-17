package pl.gatomek.algoexpert;

import java.util.Arrays;

class NonConstructibleChange {
    public static int nonConstructibleChange(int[] coins) {
        final int sumRange = Arrays.stream(coins).sum();
        int sum = 1;
        for (; sum <= sumRange; sum++) {
            boolean success = tryCollectSum(0, coins.length, coins, sum);
            if (!success) {
                return sum;
            }
        }
        return sum;
    }

    private static boolean tryCollectSum(int start, int end, int[] coins, int targetSum) {
        for (int i = start; i < end; i++) {
            final int coin = coins[i];

            if (coin == targetSum) {
                return true;
            }

            final int missingValue = targetSum - coin;
            if( missingValue > 0) {
                boolean result = tryCollectSum(i + 1, end, coins, missingValue);
                if (result) {
                    return true;
                }
            }
        }

        return false;
    }

    void main() {
        int[] coins = {5, 7, 1, 1, 2, 3, 22};
        int change = nonConstructibleChange(coins);
        System.out.println(change);
    }
}
