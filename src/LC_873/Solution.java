package LC_873;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lenLongestFibSubseq(int[] A) {
        Set<Integer> integerSet = new HashSet<>();
        int ans = 0;
        for (int num : A)
            integerSet.add(num);
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if(j!=i+1)
                    break;
                int len = 2;
                int x = A[j], y = A[i] + A[j];
                while (integerSet.contains(y)) {
                    int tmp = y;
                    y = y + x;
                    x = tmp;
                    ans = Math.max(ans, ++len);
                }
            }
        }
        return ans >= 3 ? ans : 0;
    }

}
