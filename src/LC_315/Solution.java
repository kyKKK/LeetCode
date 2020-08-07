package LC_315;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private int[] ret;
    private int[] index;
    private int[] tempIndex;

    public List<Integer> countSmaller(int[] nums) {
        this.ret = new int[nums.length];
        this.index = new int[nums.length];
        this.tempIndex = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
    }

    private void internal(int[] nums, int p, int r) {
        if (p >= r)
            return;
        int q = p + ((r - p) >> 2);
        internal(nums, p, q);
        internal(nums, q + 1, r);
        merge(nums, p, q, r);
    }

    private void merge(int[] nums, int p, int q, int r) {
        int[] tmp = new int[r - p + 1];
        int i = p, j = q + 1, k = 0;
        while (i <= q && j <= r) {
            if (nums[i] < nums[j]) {
                tmp[k] = nums[i];
                tempIndex[p + k] = index[i];
                ret[index[i]] += r - j - 1;
                k++;
                i++;
            }
        }

    }
}
