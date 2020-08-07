package LC_128;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int n : nums) {
            numSet.add(n);
        }
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!numSet.contains(nums[i] - 1)) {
                int count = 0;
                int num = nums[i];
                while (numSet.contains(num)) {
                    ++count;
                    ++num;
                }
                ret = Math.max(ret, count);
            }
        }
        return ret;
    }
}
