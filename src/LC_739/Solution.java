package LC_739;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    // 时间复杂度O(n^2)
    public int[] dailyTemperatures(int[] T) {
        int[] ret = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            int j = i + 1;
            for (; j < T.length; j++) {
                if (T[j] > T[i]) {
                    ret[i] = j - i;
                    break;
                }
            }
            if (j == T.length)
                ret[i] = 0;
        }
        return ret;
    }

    public int[] dailyTemperatures_2(int[] T) {
        int len = T.length;
        int[] ret = new int[len];

        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int i = 1; i < len; i++) {
            while (stack.peek() != null) {
                if (T[stack.peek()] < T[i]) {
                    ret[stack.peek()] = i - stack.peek();
                    stack.pop();
                } else {
                    stack.push(i);
                    break;
                }
                if (stack.peek() == null)
                    stack.push(i);
            }
        }
        while (stack.size() > 0) {
            ret[stack.pop()] = 0;
        }
        return ret;
    }

    public int[] dailyTemperatures_3(int[] T) {
        int len = T.length;
        int[] ret = new int[len];

        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            int tmp = T[i];
            while (!stack.isEmpty() && tmp > T[stack.peek()]) {
                ret[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return ret;
    }
}
