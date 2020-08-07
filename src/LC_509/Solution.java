package LC_509;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int fib(int N) {
        return helper(N);
    }

    private int helper(int N) {
        if (N == 0)
            return 0;
        if (N == 1)
            return 1;
        return helper(N - 1) + helper(N - 2);
    }

    //  带备忘录的递归
    Map<Integer, Integer> map = new HashMap<>();

    private int helper_1(int N) {
        if (N == 0)
            return 0;
        if (N == 1)
            return 1;
        int val = map.getOrDefault(N, 0);
        if (val != 0) {
            return val;
        }
        map.put(N, helper_1(N - 1) + helper_1(N - 2));
        return map.get(N);
    }

    //  dp数组
    private int helper_2(int N) {
        if (N == 0)
            return 0;
        if (N == 1)
            return 1;
        int[] dp = new int[N + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }

    //  状态压缩
    private int helper_3(int N) {
        if (N == 1 || N == 2)
            return 1;
        int prev = 1, curr = 1;
        for (int i = 3; i <= N; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }
}
