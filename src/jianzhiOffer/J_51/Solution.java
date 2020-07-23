package jianzhiOffer.J_51;

public class Solution {
    private int num = 0;

    public int reversePairs(int[] nums) {
        internal(nums, 0, nums.length - 1);
        return num;
    }

    private void internal(int[] nums, int p, int r) {
        if (p >= r)
            return;
        int q = p + (r - p) / 2;
        internal(nums, p, q);
        internal(nums, q + 1, r);
        merge(nums, p, q, r);
    }

    private void merge(int[] nums, int p, int q, int r) {
        int[] tmp = new int[r - p + 1];
        int i = 0, j = p, k = q + 1;
        while (j <= q && k <= r) {
            if (nums[j] <= nums[k]) {
                tmp[i++] = nums[j++];
            } else {
                num += q - j + 1;
                tmp[i++] = nums[k++];
            }
        }
        int start = j, end = q;
        if (k <= r) {
            start = k;
            end = r;
        }
        while (start <= end) {
            tmp[i++] = nums[start++];
        }
        for (int n = 0; n < tmp.length; n++) {
            nums[p + n] = tmp[n];
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int arr[] = {1, 3, 2, 5, 1, 3, 5, 7, 8, 3};
        int ret = s.reversePairs(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
