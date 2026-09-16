package pl.gatomek.algoexpert;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ValidateSubsequenceTest {

    @Test
    void test() {
        List<Integer> array = List.of(5,1,22,25,6,-1,8,10);
        List<Integer> sequence = List.of(1,6,-1,10);

        boolean vld = ValidateSubsequence.isValidSubsequence(array, sequence);
        assertThat(vld).isTrue();
    }
}