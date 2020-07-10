package LC_215;

import java.util.Arrays;

//  基于堆排序
public class Solution_2 {
    public int findKthLargest(int[] nums, int k) {
        buildHeap(nums);
        for (int i = 1; i < k; i++) {
            nums[0] = nums.length - i;
            heapify(nums, 0, nums.length - i);
        }
        return nums[0];
    }

    private void buildHeap(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
    }

    private void heapify(int[] arr, int k, int n) {
        int maxPos = k;
        while (true) {
            if (k * 2 + 1 < n && arr[k * 2 + 1] > arr[k]) {
                maxPos = k * 2 + 1;
            }
            if (k * 2 + 2 < n && arr[k * 2 + 2] > arr[maxPos]) {
                maxPos = k * 2 + 2;
            }
            if (maxPos == k)
                break;
            swap(arr, k, maxPos);
            k = maxPos;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7, 2, 3, 4, 5, 6};
        new Solution_2().buildHeap(arr);
        System.out.println(Arrays.toString(arr));
    }

}
