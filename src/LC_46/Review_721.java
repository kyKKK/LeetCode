package LC_46;

import java.util.LinkedList;
import java.util.List;

public class Review_721 {
    List<List<Integer>> ret = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        helper(nums);
        return ret;
    }

    LinkedList<Integer> list = new LinkedList<>();

    public void helper(int[] nums) {
        if (list.size() == nums.length) {
            ret.add(new LinkedList<>(list));
            return;
        }
        for (int num : nums) {
            if (list.contains(num))
                continue;
            list.add(num);
            helper(nums);
            list.removeLast();
        }
    }
}
