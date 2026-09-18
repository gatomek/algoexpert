package pl.gatomek.algoexpert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClassPhotos {
    public boolean classPhotos(
            ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights
    ) {
        redShirtHeights.sort(Collections.reverseOrder());
        blueShirtHeights.sort(Collections.reverseOrder());

        Integer redMax = redShirtHeights.getFirst();
        Integer blueMax = blueShirtHeights.getFirst();
        if (redMax.equals(blueMax)) {
            return false;
        }

        List<Integer> tallers = redMax > blueMax ? redShirtHeights : blueShirtHeights;
        List<Integer> lowers = redMax > blueMax ? blueShirtHeights : redShirtHeights;

        for (int i = 0; i < tallers.size(); i++) {
            Integer taller = tallers.get(i);
            Integer lower = lowers.get(i);

            if (lower >= taller) {
                return false;
            }
        }

        return true;
    }
}
