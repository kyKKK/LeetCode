package LC_1431;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];
        for (int i : candies) {
            max = Math.max(i, max);
        }
        List<Boolean> ret = new LinkedList<>();
        for (int i : candies) {
            if (max - i <= extraCandies)
                ret.add(true);
            else
                ret.add(false);
        }
        return ret;
    }
}
