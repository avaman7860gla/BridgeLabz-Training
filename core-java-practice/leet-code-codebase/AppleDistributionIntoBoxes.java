import java.util.Arrays;

public class AppleDistributionIntoBoxes {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sumap = 0;
        for (int ap : apple) {
            sumap += ap;
        }

        Arrays.sort(capacity); 
        int sumcp = 0;
        int boxes = 0;

        for (int i = capacity.length - 1; i >= 0; i--) {
            sumcp += capacity[i];
            boxes++;
            if (sumcp >= sumap) {
                return boxes;
            }
        }
        return boxes;
    }
}

