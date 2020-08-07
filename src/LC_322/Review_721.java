package LC_322;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Review_721 {
    public int coinChange(int[] coins, int amount) {
        return dp(coins, amount);
    }

    Map<Integer, Integer> map = new HashMap<>();

    private int helper(int[] coins, int n) {
        if (map.containsKey(n))
            return map.get(n);
        if (n == 0)
            return 0;
        if (n < 0)
            return -1;
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = helper(coins, n - coin);
            if (sub < 0)
                continue;
            res = Math.min(sub + 1, res);
        }
        map.put(n, res == Integer.MAX_VALUE ? -1 : res);
        return map.get(n);
    }

    private int dp(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 1, dp.length - 1, amount + 1);
        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0)
                    continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
