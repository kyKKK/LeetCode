package LC_46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static List<List<Integer>> res = new LinkedList<>();

    public static List<List<Integer>> permute(int[] nums) {
        backtrack_1(nums, nums.length);
        return res;
    }

    public static void backtrack(int[] nums, LinkedList<Integer> track) {
        if (nums.length == track.size()) {
            res.add(new LinkedList<>(track));
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i]))
                continue;
            track.add(nums[i]);
            backtrack(nums, track);
            track.removeLast();
        }
    }

    //  元素交换方法, k:要处理的元素
    public static void backtrack_1(int[] nums, int k) {
        if (k == 1) {
            List<Integer> l = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                l.add(nums[i]);
            }
            res.add(new LinkedList<>(l));
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i]+" ");
            }
            System.out.println();

        }
        for (int i = 0; i < k; i++) {
            swap(nums, i, k - 1);
            backtrack_1(nums, k - 1);
            swap(nums, i, k - 1);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2};
        backtrack_1(arr,arr.length);
    }
}
