package LC_1;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    //  两遍HashMap
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> intMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            intMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int c = target - nums[i];
            if (intMap.containsKey(c) && intMap.get(c) != i) {
                return new int[]{intMap.get(c), i};
            }
        }
        return null;

    }

    //  暴力
    public int[] twoSum_1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int c = target - nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (j == i)
                    continue;
                if (c == nums[j])
                    return new int[]{i, j};
            }
        }
        return null;
    }

    //  一遍HashMap
    public int[] twoSum_2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int c = target - nums[i];
            if (map.containsKey(c))
                return new int[]{map.get(c), i};
            map.put(nums[i], i);
        }
        return null;
    }
}
