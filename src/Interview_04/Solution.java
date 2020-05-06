package Interview_04;

import java.util.Arrays;

public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        boolean is_exist = false;

        for (int i = 0; i < matrix.length; i++) {
            if (Arrays.binarySearch(matrix[i], target) != -1) {
                is_exist = true;
            }
        }
        return is_exist;
    }

    public static void main(String[] args) {

    }
}
