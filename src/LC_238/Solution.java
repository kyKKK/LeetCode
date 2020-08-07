package LC_238;

import java.util.Arrays;

public class Solution {
    //  时间复杂度O(n^2)
    public int[] productExceptSelf(int[] nums) {
        int[] ret = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int total = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    total *= nums[j];
                }
            }
            ret[i] = total;
        }
        return ret;
    }

    //  时间复杂度O(n)
    public int[] productExceptSelf_1(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int lSum = 1, rSum = 1;
        for (int i = 0; i < left.length; i++) {
            if (i != 0) {
                lSum *= nums[i - 1];
                left[i] = lSum;
            } else {
                left[i] = 1;
            }
        }
        for (int i = right.length - 1; i >= 0; i--) {
            if (i != right.length - 1) {
                rSum *= nums[i + 1];
                right[i] = rSum;
            } else {
                right[i] = 1;
            }
        }
        int[] ret = new int[nums.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = right[i] * left[i];
        }
        return ret;
    }

    //  时间复杂度O(n)，空间复杂度O(1)，（出于对空间复杂度分析的目的，输出数组不被视为额外空间。)
    public static int[] productExceptSelf_2(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for (int i = 1; i < ans.length; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];

        }
        System.out.println(Arrays.toString(ans));
        for (int i = nums.length - 2; i >= 0; i--) {
            ans[i] = ans[i + 1] * nums[i + 1];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf_2(new int[] {1,2,3,4})));
    }
}
