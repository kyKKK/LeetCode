package BinarySearch;

public class BinarySearch {
    public static int bs_classic(int[] arr, int target) {
        //  二分查找
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == arr[mid])
                return mid;
            if (target < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int bs_classic_recursive(int[] arr, int target) {
        //  二分查找，递归
        return bs_classic_recursive_internal(arr, 0, arr.length - 1, target);
    }

    public static int bs_classic_recursive_internal(int[] arr, int low, int high, int target) {
        if (low >= high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (arr[mid] == target)
            return mid;
        if (target < arr[mid])
            return bs_classic_recursive_internal(arr, low, high - 1, target);
        else
            return bs_classic_recursive_internal(arr, low + 1, high, target);
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7, 9, 12, 15};
        System.out.println(bs_classic(arr, 16));
    }
}
