package LC_322;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        return dynamic(coins, amount);
    }

    //  动态规划，自底向上
    private int dynamic(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        //  状态值，下标表示金额，值表示凑出该金额需要的需要最少的零钱数
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if ((i - coin) < 0)
                    continue;

                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }


    Map<Integer, Integer> map = new HashMap<>();

    //  带备忘录的递归，自顶向下
    private int helper(int[] coins, int n) {
        if (map.containsKey(n))
            return map.get(n);
        if (n == 0)
            return 0;
        if (n < 0) {
            return -1;
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {

            int subpro = helper(coins, n - coin);
            if (subpro == -1)
                continue;
            res = Math.min(res, 1 + subpro);
        }
        if (res == Integer.MAX_VALUE)
            map.put(n, -1);
        else
            map.put(n, res);
        return map.get(n);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] coins = new int[]{1,2,3};

        System.out.println(s.coinChange(coins, 3));
    }
}
