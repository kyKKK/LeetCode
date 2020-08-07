package Interview_16_11;

public class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0)
            return new int[0];
        if (shorter == longer)
            return new int[]{shorter * k};
        int[] ret = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            ret[i] = longer * i + shorter * (k - i);
        }
        return ret;
    }
}
