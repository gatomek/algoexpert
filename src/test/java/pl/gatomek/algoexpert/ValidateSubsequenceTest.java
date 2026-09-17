package pl.gatomek.algoexpert;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ValidateSubsequenceTest {

    @Test
    void shouldReturnTrue_whenProperSubsequence() {
        List<Integer> array = List.of(5,1,22,25,6,-1,8,10);
        List<Integer> sequence = List.of(1,6,-1,10);

        boolean vld = ValidateSubsequence.isValidSubsequence(array, sequence);
        assertThat(vld).isTrue();
    }

    @Test
    void shouldReturnFalse_whenDifferentSubsequence() {
        List<Integer> array = List.of(5,1,22,25,6,-1,8,10);
        List<Integer> sequence = List.of(1,2,3,4);

        boolean vld = ValidateSubsequence.isValidSubsequence(array, sequence);
        assertThat(vld).isFalse();
    }

    @Test
    void shouldReturnTrue_whenSequenceIsEmpty() {
        List<Integer> array = List.of(5,1,22,25,6,-1,8,10);
        List<Integer> sequence = List.of();

        boolean vld = ValidateSubsequence.isValidSubsequence(array, sequence);
        assertThat(vld).isTrue();
    }

    @Test
    void shouldReturnFalse_whenArrayIsEmpty() {
        List<Integer> array = List.of();
        List<Integer> sequence = List.of(1,6,-1,10);

        boolean vld = ValidateSubsequence.isValidSubsequence(array, sequence);
        assertThat(vld).isFalse();
    }

    @Test
    void shouldReturnTrue_whenArrayAndSequenceAreTheSame() {
        List<Integer> array = List.of(5,1,22,25,6,-1,8,10);
        List<Integer> sequence = List.of(5,1,22,25,6,-1,8,10);

        boolean vld = ValidateSubsequence.isValidSubsequence(array, sequence);
        assertThat(vld).isTrue();
    }
}