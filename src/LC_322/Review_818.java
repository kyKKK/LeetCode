package LC_322;

import java.util.Arrays;

public class Review_818 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 1, dp.length, amount + 1);
        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0)
                    continue;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
