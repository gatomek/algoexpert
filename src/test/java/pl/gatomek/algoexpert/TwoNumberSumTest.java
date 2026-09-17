package pl.gatomek.algoexpert;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TwoNumberSumTest {
    @Test
    void test() {
        int[] test = {3,5,-4,8,11,1,-1,6};
        int sum = 10;
        int[] ints = TwoNumberSum.twoNumberSum(test, sum);
        int[] expected = {-1,11};
        assertThat(ints).containsExactlyInAnyOrder(expected);
    }
}
