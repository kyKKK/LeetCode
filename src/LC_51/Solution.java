package LC_51;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private int[] results;
    private List<List<String>> ret;

    public List<List<String>> solveNQueens(int n) {
        results = new int[n];
        ret = new LinkedList<>();
        backtrace(0);
        return ret;
    }

    private void backtrace(int row) {
        if (row == results.length) {
            List<String> list = new LinkedList<>();
            for (int result : results) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < results.length; j++) {
                    if (j == result)
                        sb.append("Q");
                    else
                        sb.append(".");
                }
                list.add(sb.toString());
            }
            ret.add(new LinkedList<>(list));
        }
        for (int i = 0; i < results.length; i++) {
            if (check(row, i)) {
                results[row] = i;
                backtrace(row + 1);
            }
        }
    }

    private boolean check(int row, int column) {
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
}
