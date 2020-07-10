package LC_560;


public class Solution {
    public static int subarraySum(int[] nums, int k) {
        int ret = 0;
        for (int right = 0; right < nums.length; right++) {
            int sum = 0;
            for (int left = right; left >= 0; left--) {
                sum += nums[left];
                if (sum == k)
                    ret++;
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-313, -462, 381, -374, -249, -123, 704, 477, 982, -684, -372, 779, -68, 593, -254, -930, -142, -369, 811, -621, 682, 167, -125, 565, 438, -137, -683, 257, -454, -256, 306, 635, -571, 52, -59, -411, 628, 895, -509, -9, -722, 926, 79, 392, -720, 94, -190, 902, 96, 486, -147, 363, -24, 604, -265, -680, 529, -462, -477, -384, 991, 319, -520, -799, -95, 705, 528, 684};
        System.out.println(subarraySum(nums, 339));
    }
}