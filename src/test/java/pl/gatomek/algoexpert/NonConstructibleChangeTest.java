package pl.gatomek.algoexpert;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NonConstructibleChangeTest {

    @Test
    void test1() {
        int[] coins = {1, 2, 5};
        int result = NonConstructibleChange.nonConstructibleChange(coins);

        assertThat(result).isEqualTo(4);
    }

    @Test
    void test2() {
        int[] coins = {5, 7, 1, 1, 2, 3, 22};
        int result = NonConstructibleChange.nonConstructibleChange(coins);

        assertThat(result).isEqualTo(20);
    }

    @Test
    void test3() {
        int[] coins = {1, 1, 1, 1, 1};
        int result = NonConstructibleChange.nonConstructibleChange(coins);

        assertThat(result).isEqualTo(6);
    }
}
