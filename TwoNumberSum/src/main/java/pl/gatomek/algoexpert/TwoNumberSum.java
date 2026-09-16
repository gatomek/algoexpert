package pl.gatomek.algoexpert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoNumberSum {
    static void main() {
        int[] test = {3,5,-4,8,11,1,-1,6};
        int sum = 10;

        int[] result = twoNumberSum(test, sum);
        Arrays.stream(result).asLongStream().forEach( IO::println);
    }

    public static int[] twoNumberSum(int[] array, int targetSum) {
        Map<Integer,Integer> map = HashMap.newHashMap(array.length);

        for(int val : array) {
            Integer prev = map.get(val);
            if(prev != null) {
                return new int[] {prev,val};
            }
            Integer trigger = targetSum - val;
            map.put(trigger, val);
        }

        return new int[0];
    }
}
