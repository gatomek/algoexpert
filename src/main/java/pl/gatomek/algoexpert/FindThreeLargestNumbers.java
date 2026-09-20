package pl.gatomek.algoexpert;

// todo: add priority queue with list implementation
// todo: collect only three max value list via single pass O(n)
// todo: make performance comparison with JMH

public class FindThreeLargestNumbers {
    public static int[] findThreeLargestNumbers(int[] array) {
        // time complexity: O(n*log(n))
        // mem complexity: 1

        if (array == null || array.length < 3) {
            throw new IllegalArgumentException("Array must contain at least 3 elements");
        }

        int len = array.length;
        for (int i = 1; i < len; i++) {
            tryMoveUp(i, array);
        }

        final int max0 = getMax(array, len);
        final int max1 = getMax(array, len - 1);
        final int max2 = getMax(array, len - 2);

        return new int[]{max2, max1, max0};
    }

    private static int getMax(int[] array, int len) {
        final int max = array[0];
        array[0] = array[len - 1];
        tryMoveDown(0, array, len - 1);
        return max;
    }

    private static void tryMoveDown(int index, int[] array, int len) {
        final int value = array[index];

        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;
        boolean canLeft = leftIndex < len;
        boolean canRight = rightIndex < len;

        if (canLeft || canRight) {
            if (canLeft && canRight) {
                final int left = array[leftIndex];
                final int right = array[rightIndex];

                if (left > right) {
                    if (left > value) {
                        swap(index, leftIndex, array);
                        tryMoveDown(leftIndex, array, len);
                    }
                } else {
                    if (right > value) {
                        swap(index, rightIndex, array);
                        tryMoveDown(rightIndex, array, len);
                    }
                }
            } else if (canLeft) {
                final int left = array[leftIndex];
                if (left > value) {
                    swap(index, leftIndex, array);
                    tryMoveDown(leftIndex, array, len);
                }
            } else {
                final int right = array[rightIndex];
                if (right > value) {
                    swap(index, rightIndex, array);
                    tryMoveDown(rightIndex, array, len);
                }
            }
        }
    }

    private static void tryMoveUp(int index, int[] array) {
        final int value = array[index];

        final int parentIndex = (index - 1) / 2;
        final int parentValue = array[parentIndex];

        if (parentValue < value) {
            swap(parentIndex, index, array);

            if (parentIndex > 0) {
                tryMoveUp(parentIndex, array);
            }
        }
    }

    private static void swap(int a, int b, int[] array) {
        final int v = array[a];
        array[a] = array[b];
        array[b] = v;
    }
}
