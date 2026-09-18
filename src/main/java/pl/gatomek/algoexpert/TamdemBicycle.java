package pl.gatomek.algoexpert;

import java.util.Arrays;
import java.util.Collections;

public class TamdemBicycle {
    public int tandemBicycle(
            int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest
    ) {
        Integer[] reds = Arrays.stream(redShirtSpeeds).boxed().sorted().toArray(Integer[]::new);
        int speedSum = 0;

        Integer[] blues;
        if (fastest) {
            blues = Arrays.stream(blueShirtSpeeds).boxed().sorted(Collections.reverseOrder()).toArray(Integer[]::new);
        } else {
            blues = Arrays.stream(blueShirtSpeeds).boxed().sorted().toArray(Integer[]::new);
        }

        for (int i = 0; i < reds.length; i++) {
            speedSum += Math.max(reds[i], blues[i]);
        }

        return speedSum;
    }
}
