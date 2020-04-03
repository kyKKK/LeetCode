//  归并排序
public class MergeSort {
    public static void merge_sort(int[] arr) {
        int length = arr.length;
        merge_internal(arr, 0, length - 1);
    }

    public static void merge_internal(int[] arr, int p, int q) {
        if (p >= q)
            return;
        int r = p + (q - p) / 2;
        merge_internal(arr, p, r);
        merge_internal(arr, r + 1, q);
        merge(arr, p, r, q);
    }

    public static void merge(int[] arr, int p, int r, int q) {
        System.out.println("now p: " + p + " q: " + q + " r: " + r);
        int[] tmp = new int[q - p + 1];
        int i = p, j = r + 1, k = 0;
        while (i <= r && j <= q) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        while (i <= r) {
            tmp[k++] = arr[i++];
        }
        while (j <= q) {
            tmp[k++] = arr[j++];
        }
        for (int n = 0; n < tmp.length; n++) {
            arr[p + n] = tmp[n];
        }
    }

    public static void merge_sentry(int[] arr, int p, int r, int q) {
        System.out.println("now p: " + p + " q: " + q + " r: " + r);
        int[] left_arr = new int[r - p + 2];
        int[] right_arr = new int[q - r + 1];
        left_arr[r - p + 1] = Integer.MAX_VALUE;
        right_arr[q - r] = Integer.MAX_VALUE;
        for (int i = p, n = 0; i <= r; i++) {
            left_arr[n++] = arr[i];
        }
        for (int i = r + 1, n = 0; i <= q; i++) {
            right_arr[n++] = arr[i];
        }
//        System.out.println("left arr");
//        for (int i = 0; i < left_arr.length; i++) {
//            System.out.print(left_arr[i] + " ");
//        }
//        System.out.println("right arr");
//        for (int i = 0; i < right_arr.length; i++) {
//            System.out.print(right_arr[i] + " ");
//        }
        int i = 0, j = 0;
        for (int n = 0; n < q - p + 1; n++) {
            if (left_arr[i] <= right_arr[j]) {
                arr[p + n] = left_arr[i++];
            } else {
                arr[p + n] = right_arr[j++];
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 2, 5, 1, 3, 5, 7, 8, 3};
        int[] arr2 = {1, 0};
        merge_sort(arr2);
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
    }
}
