package pl.gatomek.algoexpert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TwoNumberSum {
    private static final Logger logger = Logger.getLogger(TwoNumberSum.class.getName());

    public static int[] twoNumberSum(int[] array, int targetSum) {
        Map<Integer, Integer> map = HashMap.newHashMap(array.length);

        for (int val : array) {
            Integer prev = map.get(val);
            if (prev != null) {
                return new int[]{prev, val};
            }
            Integer trigger = targetSum - val;
            map.put(trigger, val);
        }

        return new int[0];
    }

    void main() {
        int[] test = {3, 5, -4, 8, 11, 1, -1, 6};
        int sum = 10;

        int[] result = twoNumberSum(test, sum);
        Arrays.stream(result).forEach(s -> logger.log(Level.INFO, "{}", s));
    }
}
