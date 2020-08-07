package BinarySearch;

//  2020年5月9日
public class Review {
    //  迭代
    public static int bs(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target)
                return mid;
            else if (target < arr[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }

    public static int bs_recur(int[] arr, int target) {
        return helper(arr, 0, arr.length - 1, target);
    }

    public static int helper(int[] arr, int left, int right, int target) {
        if (left > right)
            return -1;
        int mid = left + (right - left) / 2;
        if (arr[mid] == target)
            return mid;
        if (target < arr[mid])
            return helper(arr, left, mid - 1, target);
        else
            return helper(arr, mid + 1, right, target);
    }

    //  查找第一个值等于给定值的元素位置
    public static int bs_1(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {

            int mid = left + (right - left) / 2;
            System.out.println("left: " + left + " right: " + right + " mid: " + mid);

            if (target < arr[mid])
                right = mid - 1;
            else if (target > arr[mid])
                left = mid + 1;
            else {
                if (mid == 0 || arr[mid - 1] != arr[mid])
                    return mid;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }

    //  查找最后一个值等于给定值的元素位置
    public static int bs_2(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < arr[mid])
                right = mid - 1;
            else if (target > arr[mid])
                left = mid + 1;
            else {
                if (mid == arr.length - 1 || arr[mid + 1] != arr[mid])
                    return mid;
                else
                    left = mid + 1;
            }
        }
        return -1;
    }

    //  查找第一个值大于等于给定值的元素
    public static int bs_3(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target <= arr[mid]) {
                if (mid == 0 || arr[mid - 1] < target)
                    return mid;
                else
                    right = mid - 1;
            } else
                left = mid + 1;

        }
        return -1;
    }

    //  查找最后一个值小于等于给定值的元素
    public static int bs_4(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target >= arr[mid]) {
                if (mid == arr.length - 1 || arr[mid + 1] > target)
                    return mid;
                else
                    left = mid + 1;
            } else
                right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 5, 5, 7, 12, 12, 16, 19};
        System.out.println(bs_2(arr, 12));
    }
}
