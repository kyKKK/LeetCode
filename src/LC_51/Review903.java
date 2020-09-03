package LC_51;

import java.util.LinkedList;
import java.util.List;

public class Review903 {
    private int[] arr;
    private List<List<String>> ret;


    public List<List<String>> solveNQueens(int n) {
        arr = new int[n];
        ret = new LinkedList<>();
        backTrace(0);
        return ret;
    }

    private void backTrace(int row) {
        if (row == arr.length) {
            List<String> list = new LinkedList<>();
            for (int i : arr) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < arr.length; j++) {
                    if (j == i)
                        sb.append('Q');
                    else
                        sb.append('.');
                }
                list.add(sb.toString());
            }
            ret.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (check(row, i)) {
                arr[row] = i;
                backTrace(row + 1);
            }
        }
    }

    private boolean check(int row, int column) {
        int left = column - 1, right = column + 1;
        for (int i = row - 1; i >= 0; i--) {
            if (arr[i] == column)
                return false;
            if (left >= 0 && left-- == arr[i])
                return false;
            if (right < arr.length && right++ == arr[i])
                return false;
        }
        return true;
    }
}
