package LC_46;

import java.util.LinkedList;
import java.util.List;

public class Review812 {
    List<List<Integer>> ret;

    public List<List<Integer>> permute(int[] nums) {
        ret = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        LinkedList<Integer> list = new LinkedList<>();
        helper(nums, list, used);
        return ret;
    }

    private void helper(int[] nums, LinkedList<Integer> list, boolean[] used) {
        if (list.size() == nums.length) {
            ret.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;
            list.add(nums[i]);
            used[i] = true;
            helper(nums, list, used);
            list.removeLast();
            used[i] = false;
        }
    }
}
