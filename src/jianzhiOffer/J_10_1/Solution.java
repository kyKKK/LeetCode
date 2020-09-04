package jianzhiOffer.J_10_1;

public class Solution {
    public int fib(int n) {
        if(n==0)
            return 0;
        int[] arr = new int[n + 1];
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = (arr[i - 2] + arr[i - 1])%(int)(1e9+7);
        }
        return arr[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fib(81));
    }
}
