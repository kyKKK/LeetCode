package jianzhiOffer.J_10_1;

public class Solution {
    public int fib(int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 1;
        int a = 1, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = (a + b) % (int) (1e9 + 7);
            a = b;
            b = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fib(1));
    }
}
