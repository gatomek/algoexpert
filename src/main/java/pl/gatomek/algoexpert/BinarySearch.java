package pl.gatomek.algoexpert;

public class BinarySearch {
    public static int binarySearch(int[] array, int target) {
        return binary(array, 0, array.length, target);
    }

    private static int binary(int[] array, int start, int end, int target) {
        if (start == end) {
            return -1;
        }

        int middle = start + (end - start) / 2;
        int middleValue = array[middle];

        if (middleValue == target) {
            return middle;
        }

        if (target < middleValue) {
            return binary(array, start, middle, target);
        }

        return binary(array, middle + 1, end, target);
    }
}
