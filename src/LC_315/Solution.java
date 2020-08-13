package LC_315;

import java.util.*;

public class Solution {
    private int[] ret;
    private int[] index;
    private int[] tempIndex;
    private int[] tmp;

    public List<Integer> countSmaller(int[] nums) {
        this.ret = new int[nums.length];
        this.index = new int[nums.length];
        this.tempIndex = new int[nums.length];
        this.tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        internal(nums, 0, nums.length - 1);
        List<Integer> list = new LinkedList<>();
        for (int num : ret) {
            list.add(num);
        }
        return list;
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
        int i = p, j = q + 1, n = p;
        while (i <= q && j <= r) {
            if (nums[i] <= nums[j]) {
                tmp[n] = nums[i];
                tempIndex[n] = index[i];
                ret[index[i]] += j - q - 1;
                i++;
                n++;
            } else {
                tmp[n] = nums[j];
                tempIndex[n] = index[j];
                j++;
                n++;
            }
        }
        while (i <= q) {
            tmp[n] = nums[i];
            tempIndex[n] = index[i];
            ret[index[i]] += j - q - 1;
            i++;
            n++;
        }
        while (j <= r) {
            tmp[n] = nums[j];
            tempIndex[n] = index[j];
            j++;
            n++;
        }
        for (int k = p; k <= r; k++) {
            nums[k] = tmp[k];
            index[k] = tempIndex[k];
        }
    }

    public static void main(String[] args) {
        Solution s1 = new Solution();
        int[] nums = new int[]{5, 2, 6, 1};
        s1.countSmaller(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
