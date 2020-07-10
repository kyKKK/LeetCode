package jianzhiOffer.J_04;

public class Solution {
    //  法1
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0)
            return false;
        int con = matrix[0].length;
        for (int i = 0; i < row; i++) {
            if (bs_1(matrix[i], target) != -1) {
                return true;
            }
        }
        return false;
    }

    //  法2
    public boolean findNumberIn2DArray_1(int[][] matrix, int target) {
        int rows = matrix.length;
        if(rows==0)
            return false;
        int cons = matrix[0].length;
        int row = 0, con = cons - 1;
        while (row < rows && con >= 0) {
            if (matrix[row][con] < target) {
                ++row;
            } else if (matrix[row][con] > target) {
                --con;
            } else {
                return true;
            }
        }
        return false;
    }

    private int bs_1(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
