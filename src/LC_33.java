//  搜索旋转排序数组
public class LC_33 {
    public static int search(int[] nums, int target) {
        //  时间复杂度n
        int d = 0, len = nums.length;
        if (len == 0) {
            return -1;
        }
        for (int i = 0; i < len - 1; i++) {
            int j = i + 1;
            if (nums[j] < nums[i]) {
                d = i;
            }
        }
        System.out.println("d: " + d);
        int a = bsearch(nums, target, 0, d);
        int b = bsearch(nums, target, d + 1, len - 1);
        if (a != -1)
            return a;
        else if (b != -1)
            return b;
        else return -1;

    }

    public static int search_a(int[] arr, int target) {
        //  时间复杂度logn
        int len = arr.length;
        int low = 0, high = len - 1;
        if (len == 0) {
            return -1;
        }
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[low] <= arr[mid]) {
                if (target >= arr[low] && target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target > arr[mid] && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int search_recursive(int[] nums, int target) {
        return search_internal(nums, target, 0, nums.length - 1);
    }

    public static int search_internal(int[] arr, int val, int low, int high) {
        int mid = low + ((high - low) >> 1), r = -1;
        if (arr[mid] == val) {
            return mid;
        }
        if (arr[low] < arr[mid]) {
            int a = bsearch(arr, val, low, mid);
            if (a != -1)
                return a;
            int b = search_internal(arr, val, mid + 1, high);
            if (b != -1)
                return b;

        } else if (arr[high] > arr[mid]) {
            int b = bsearch(arr, val, mid, high);
            if (b != -1)
                return b;
            int a = search_internal(arr, val, low, mid - 1);
            if (a != -1)
                return a;
        }
        return -1;
    }

    public static int bsearch(int[] arr, int val, int low, int high) {
        int mid = low + ((high - low) >> 1);
        while (low <= high) {
            if (arr[mid] < val) {
                low = mid + 1;
                mid = low + ((high - low) >> 1);
            } else if (arr[mid] > val) {
                high = mid - 1;
                mid = low + ((high - low) >> 1);
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1};
        System.out.println(search_a(arr, 1));
    }
}
