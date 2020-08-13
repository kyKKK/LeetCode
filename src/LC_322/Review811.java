package LC_322;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Review811 {
    public int coinChange(int[] coins, int amount) {
        return helper(coins, amount);
    }

    Map<Integer, Integer> map = new HashMap<>();

    private int helper(int[] coins, int amount) {
        if (map.containsKey(amount))
            return map.get(amount);
        int res = Integer.MAX_VALUE;
        if (amount < 0)
            return -1;
        if (amount == 0)
            return 0;
        for (int coin : coins) {
            int sub = helper(coins, amount - coin);
            if (sub == -1)
                continue;
            res = Math.min(res, sub + 1);
        }
        if (res == Integer.MAX_VALUE)
            map.put(amount, -1);
        else
            map.put(amount, res);
        return map.get(amount);
    }

    private int dp(int[] coins, int amount) {
        int[] arr = new int[amount + 1];
        Arrays.fill(arr, 1, amount + 1, amount + 1);
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                int last = i - coin;
                if (last < 0)
                    continue;
                arr[i] = Math.min(arr[i], arr[last] + 1);
            }
        }
        return arr[amount] == amount + 1 ? -1 : arr[amount];
    }
}
