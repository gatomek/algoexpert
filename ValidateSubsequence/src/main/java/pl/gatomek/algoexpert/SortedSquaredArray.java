package pl.gatomek.algoexpert;

import java.util.Arrays;

// todo: performance comparison tests with JMH

class SortedSquaredArray {
    private static int[] sortedSquaredArray(int[] array) {
        return Arrays.stream(array).map(n -> n * n).sorted().toArray();
    }

    public static int[] sortedSquaredArray2(int[] array) {
        final int len = array.length;

        int[] absArray = new int[len];
        if (len == 0) {
            return absArray;
        }

        for (int i = 0; i < len; i++) {
            absArray[i] = Math.abs(array[i]);
        }

        int minIndex = 0;
        int minValue = absArray[minIndex];

        for (int i = 1; i < len; i++) {
            int value = absArray[i];
            if (value < minValue) {
                minValue = value;
                minIndex = i;
            }
        }

        int leftIndex = minIndex;
        int rightIndex = minIndex;
        int targetIndex = 0;

        int[] target = new int[len];
        target[targetIndex++] = absArray[minIndex];
        leftIndex--;
        rightIndex++;

        while (leftIndex > -1 || rightIndex < len) {
            if (leftIndex > -1 && rightIndex < len) {
                int lValue = absArray[leftIndex];
                int rValue = absArray[rightIndex];

                if (rValue < lValue) {
                    target[targetIndex++] = rValue;
                    rightIndex++;
                } else {
                    target[targetIndex++] = lValue;
                    leftIndex--;
                }
                continue;
            }

            if (leftIndex > -1) {
                int lValue = absArray[leftIndex];
                target[targetIndex++] = lValue;
                leftIndex--;
                continue;
            }

            int rValue = absArray[rightIndex];
            target[targetIndex++] = rValue;
            rightIndex++;
        }

        if(targetIndex != len) {
            throw new IllegalStateException("target index with array length mismatch");
        }

        for (int i = 0; i < len; i++) {
            target[i] = target[i] * target[i];
        }

        return target;
    }

    void main() {
        int[] array = {-2, -1, 3, 4, 5, 6, 7, 9};
        int[] result = sortedSquaredArray2(array);
        Arrays.stream(result).forEach(n -> System.out.print(n + ", "));
    }
}
