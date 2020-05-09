package LC_70;

public class Solution {
    public int climbStairs(int n) {
        int[] arr = new int[n + 1];
        return helper(n, arr);
    }

    public int helper(int n, int[] arr) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        if(arr[n]!=0)
            return arr[n];
        return helper(n - 1, arr) + helper(n - 2, arr);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.climbStairs(5));
    }
}
