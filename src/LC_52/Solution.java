package LC_52;

public class Solution {
    int[] results;
    int count = 0;

    public int totalNQueens(int n) {
        results = new int[n];
        backtrace(0);
        return count;
    }

    private void backtrace(int row) {
        if (row == results.length)
            count++;
        for (int column = 0; column < results.length; column++) {
            if (check(column, row)) {
                results[row] = column;
                backtrace(row + 1);
            }
        }
    }

    private boolean check(int column, int row) {
        int left = column - 1, right = column + 1;
        for (int i = row - 1; i >= 0; i--) {
            if (results[i] == column)
                return false;
            if (left >= 0 && results[i] == left)
                return false;
            if (right < results.length && results[i] == right)
                return false;
            --left;
            ++right;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.totalNQueens(9));
    }
}
