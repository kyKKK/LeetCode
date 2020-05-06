package Interview_56_I;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
    public int[] singleNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
                continue;
            }
            set.add(num);

        }
        Integer[] integers = set.toArray(new Integer[]{});
        int[] ret_arr = new int[integers.length];
        for (int i = 0; i < integers.length; i++) {
            ret_arr[i] = integers[i];
        }
        return ret_arr;
    }
}
