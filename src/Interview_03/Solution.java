package Interview_03;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findRepeatNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else map.put(num, map.get(num) + 1);
        }
        for (Integer key : map.keySet()) {
            int num = map.get(key);
            if (num > 1) {
                return key;
            }
        }
        return -1;
    }
}
