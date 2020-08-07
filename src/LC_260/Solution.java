package LC_260;

public class Solution {
    public int[] singleNumber(int[] nums) {
        int[] ret = new int[2];
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num ^= nums[i];
        }
        int first = 1;
        while ((num & first) == 0)
            first = first << 1;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & first) == 0)
                ret[0] ^= nums[i];
            else
                ret[1] ^= nums[i];
        }
        return ret;
    }
}
