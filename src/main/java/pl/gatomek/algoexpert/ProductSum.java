package pl.gatomek.algoexpert;

import java.util.List;

public class ProductSum {
    private static int calcSum(List<Object> array, int level) {
        int sum = 0;
        for (Object o : array) {
            if (o instanceof List) {

                @SuppressWarnings("unchecked")
                List<Object> list = (List<Object>) o;
                sum += calcSum(list, level + 1);
            } else {
                sum += (Integer) o;
            }
        }
        return level * sum;
    }

    public static int productSum(List<Object> array) {
        return calcSum(array, 1);
    }
}
