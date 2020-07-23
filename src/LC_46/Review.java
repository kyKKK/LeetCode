package LC_46;

import java.util.LinkedList;
import java.util.List;

public class Review {
    List<List<Integer>> ret = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return ret;
    }


    private void backtrack(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            ret.add(new LinkedList<>(track));
            return;
        }
        for (int num : nums) {
            if (track.contains(num))
                continue;
            track.add(num);
            backtrack(nums, track);
            track.removeLast();
        }
    }
}
