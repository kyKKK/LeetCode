package LC_209;

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0, right = 0, sum = 0, ans = -1;
        int len = nums.length;
        while (right < len) {
            sum += nums[right];
            while (sum >= s) {
                ans = ans == -1 ? right - left + 1 : Math.min(ans, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        if (ans == -1)
            return 0;
        else
            return ans;
    }
}
