package LC_315;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ret = new LinkedList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i])
                    count++;
            }
            ret.add(count);
        }
        return ret;
    }
}
