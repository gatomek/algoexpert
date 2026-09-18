package pl.gatomek.algoexpert;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class OptimalFreelancing {

    private static final String DEADLINE = "deadline";
    private static final String PAYMENT = "payment";
    private static final int PERIOD_IN_DAYS = 7;


    void main() {
        @SuppressWarnings("unchecked")
        Map<String, Integer>[] jobs = new Map[3];
        jobs[0] = Map.of(DEADLINE, 1, PAYMENT, 1);
        jobs[1] = Map.of(DEADLINE, 2, PAYMENT, 1);
        jobs[2] = Map.of(DEADLINE, 2, PAYMENT, 2);

        int result = optimalFreelancing(jobs);
        System.out.println(result);
    }

    public int optimalFreelancing(Map<String, Integer>[] jobs) {
        boolean[] week = new boolean[PERIOD_IN_DAYS];
        Arrays.sort(jobs, Comparator.comparingInt((Map<String, Integer> a) -> a.get(PAYMENT)).reversed());

        int summary = 0;

        for (var job : jobs) {
            int deadline = job.get(DEADLINE);
            int limit = Math.min(PERIOD_IN_DAYS, deadline);

            for (int i = limit - 1; i >= 0; i--) {
                if (!week[i]) {
                    week[i] = true;
                    summary += job.get(PAYMENT);
                    break;
                }
            }
        }

        return summary;
    }
}
