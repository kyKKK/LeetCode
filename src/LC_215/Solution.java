package LC_215;

import java.util.Random;

public class Solution {
    //  方法1 暴力
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums);
        return nums[3];
    }

    public void quickSort(int[] arr) {
        int right = arr.length - 1;
        internal(arr, 0, right);
    }

    public void internal(int[] arr, int left, int right) {
        if (left >= right)
            return;
        int pivot = partition(arr, left, right);
        internal(arr, left, pivot - 1);
        internal(arr, pivot + 1, right);

    }

    //  方法2 快速查找，快速排序每次分区会确定当次分区的pivot的下标
    Random random = new Random();

    public int findKthLargest_1(int[] nums, int k) {
        int t = nums.length - k;
        return internal_1(nums, 0, nums.length - 1, t);
    }

    public int internal_1(int[] nums, int left, int right, int t) {
        int index = partition(nums, left, right);
        if (index == t) {
            return nums[index];
        } else if (index < t) {
            left = index + 1;
            return internal_1(nums, left, right, t);
        } else {
            right = index - 1;
            return internal_1(nums, left, right, t);
        }
    }

    public int partition(int[] arr, int left, int right) {
        if (right > left) {
            int r = left + random.nextInt(right - left);
            swap(arr, r, right);
        }
        int pivot = arr[right];
        int i = left, j = left;
        while (j < right) {
            if (arr[j] < pivot) {
                if (i == j) {
                    i++;
                } else {
                    swap(arr, i, j);
                    i++;
                }
            }
            j++;
        }
        swap(arr, i, j);
        return i;

    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int arr[] = {1, 3, 2, 5, 1, 3, 5, 7, 8, 3};
        s.quickSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
