package LC_35;

public class Solution {
    public int searchInsert(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target <= arr[mid]) {
                if (mid == 0 || arr[mid - 1] < target)
                    return mid;
                else
                    right = mid - 1;
            } else {
                if (mid == arr.length - 1)
                    return mid;
                else
                    left = mid + 1;
            }

        }
        return -1;
    }
}
