package pl.gatomek.algoexpert;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SortedSquaredArrayTest {

    @Test
    void test() {
        int[] array = {-2, -1, 3, 4, 5, 6, 7, 9};
        int[] result = SortedSquaredArray.sortedSquaredArray2(array);

        int[] expected = {1, 4, 9, 16, 25, 36, 49, 81};
        assertThat(result).containsExactly(expected);
    }
}