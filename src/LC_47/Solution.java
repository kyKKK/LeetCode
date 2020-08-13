package LC_47;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private List<List<Integer>> ret = new LinkedList<>();
    private boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtrace(nums, new LinkedList<>());
        return ret;
    }

    private void backtrace(int[] nums, LinkedList<Integer> selectList) {
        if (nums.length == selectList.size()) {
            ret.add(new LinkedList<>(selectList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;
            selectList.add(nums[i]);
            used[i] = true;
            backtrace(nums, selectList);
            used[i] = false;
            selectList.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{2, 2, 1, 1};
        System.out.println(s.permuteUnique(nums));
    }

}
