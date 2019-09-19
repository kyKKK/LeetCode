import java.util.Arrays;

public class LC_4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int n = l1 + l2;
        if (l1 == 0) {
            if (l2 % 2 == 0)
                return (nums2[l2 / 2] + nums2[l2 / 2 - 1]) / 2.0;
            else
                return nums2[l2 / 2];
        }
        if (l2 == 0) {
            if (l1 % 2 == 0)
                return (nums1[l1 / 2] + nums1[l1 / 2 - 1]) / 2.0;
            else
                return nums1[l1 / 2];
        }
        int mid = n / 2;
        int[] arr = new int[n];
        for (int i = 0; i < l1; i++) {
            arr[i] = nums1[i];
        }
        for (int i = 0; i < l2; i++) {
            arr[i + l1] = nums2[i];
        }
        if (mid % 2 == 0)
            return (arr[n / 2] + arr[n / 2 - 1]) / 2.0;
        else
            return arr[n / 2];
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 4, 5, 6};
        int[] b = {8, 9, 13};
        System.out.println(findMedianSortedArrays(a, b));
    }
}
