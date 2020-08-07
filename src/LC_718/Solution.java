package LC_718;

public class Solution {
    public int findLength(int[] A, int[] B) {
        int ans = 0;
        if (A.length < B.length) {
            ans = compareTwo(A, B);
        } else {
            ans = compareTwo(B, A);
        }
        return ans;
    }

    private int compareTwo(int[] A, int[] B) {
        int count = A.length + B.length - 1;
        int AStart, BStart, cmpCount, ans = 0;
        for (int i = 0; i < count; i++) {
            if (i < A.length - 1) {
                AStart = A.length - 1 - i;
                BStart = 0;
                cmpCount = i + 1;
                ans = Math.max(ans, compareLen(A, B, AStart, BStart, cmpCount));
            } else {
                AStart = 0;
                BStart = i - A.length + 1;
                cmpCount = Math.min(A.length, B.length - BStart);
                ans = Math.max(ans, compareLen(A, B, AStart, BStart, cmpCount));
            }
        }
        return ans;
    }

    private int compareLen(int[] A, int[] B, int AStart, int BStart, int cmpLen) {
        int count = 0, ans = 0;
        for (int i = 0; i < cmpLen; i++) {
            if (A[AStart + i] == B[BStart + i]) {
                ans = Math.max(ans, ++count);
            } else {
                count = 0;
            }
        }
        return count;
    }
}
