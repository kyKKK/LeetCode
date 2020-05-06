package BinarySearch;

public class Binary_Search_1 {
    //  二分查找变体，查找第一个值等于给定值的元素
    public static int bs_1(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target < arr[mid])
                high = mid - 1;
            else if (target > arr[mid])
                low = mid + 1;
            else {
                if (mid == 0 || arr[mid - 1] != target)
                    return mid;
                else mid = high - 1;
            }
        }
        return -1;
    }

    //  查找最后一个值等于给定值的元素
    public static int bs_2(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target < arr[mid]) {
                high = mid - 1;
            } else if (target > arr[mid]) {
                low = mid + 1;
            } else {
                if (mid == arr.length - 1 || arr[mid + 1] != target) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    //  查找第一个大于等于给定值的元素
    public static int bs_3(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target > arr[mid]) {
                low = mid + 1;
            } else {
                if (mid == 0 || arr[mid - 1] < target)
                    return mid;
                else high = mid - 1;
            }
        }
        return -1;
    }

    //  查找最后一个小于等于给定值的元素
    public static int bs_4(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target < arr[mid]) {
                high = mid - 1;
            } else {
                if (mid == arr.length - 1 || arr[mid + 1] > target) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 4};
        System.out.println(bs_1(arr, 12));
    }
}
