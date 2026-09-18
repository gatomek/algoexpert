package pl.gatomek.algoexpert;

import java.util.Arrays;

public class MinimumWaitingTime {
    public int minimumWaitingTime(int[] queries) {
        int[] arr = queries.clone();
        Arrays.sort(arr);

        final int len = arr.length-1;
        int sum = 0;
        for (int i=0; i<len; i++){
            int v = arr[i];
            sum += v * (len-i);
        }
        return sum;
    }
}
