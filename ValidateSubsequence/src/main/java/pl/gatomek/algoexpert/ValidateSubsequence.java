package pl.gatomek.algoexpert;

import java.util.List;
import java.util.logging.Logger;

public class ValidateSubsequence {
    private static final Logger logger = Logger.getLogger(ValidateSubsequence.class.getName());

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int is = 0;
        int sLen = sequence.size();

        for (Integer va : array) {
            Integer vs = sequence.get(is);

            if (va.equals(vs)) {
                is++;
            }

            if (is == sLen) {
                break;
            }
        }

        return is == sLen;
    }

    void main() {
        List<Integer> array = List.of(5, 1, 22, 25, 6, -1, 8, 10);
        List<Integer> sequence = List.of(1, 6, -1, 10);

        boolean vld = isValidSubsequence(array, sequence);
        logger.info("" + vld);
    }
}
