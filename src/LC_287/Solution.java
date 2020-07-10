package LC_287;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    //  方法一：二分查找
    public int findDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1, ans = 0;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            int cnt = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid)
                    cnt++;
            }
            if (cnt <= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }

    //  方法二：双指针
    public int findDuplicate_1(int[] nums) {
        int fast = nums[0], slow = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (fast != slow);
        fast = nums[0];
        while (slow != fast) {
            System.out.println("now slow: " + slow + " fast: " + fast);
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{3, 2, 4, 2, 1, 5};
        System.out.println(s.findDuplicate_1(arr));
    }
}
