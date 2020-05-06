package Sort;

public class MergeSort_review {
    public static void merge_sort(int[] arr) {
        int len = arr.length;
        sort_internal(arr, 0, len - 1);
    }

    public static void sort_internal(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = p + ((r - p) >> 1);
        sort_internal(arr, p, q);
        sort_internal(arr, q + 1, r);
        merge_sentry(arr, p, q, r);

    }

    public static void merge(int[] arr, int p, int q, int r) {
        int[] tmp = new int[r - p + 1];
        int i = p, j = q + 1, n = 0;
        while (i <= q && j <= r) {
            if (arr[i] <= arr[j]) {
                tmp[n++] = arr[i++];
            } else {
                tmp[n++] = arr[j++];
            }
        }
        while (i <= q) {
            tmp[n++] = arr[i++];
        }
        while (j <= r) {
            tmp[n++] = arr[j++];
        }
        for (int k = 0; k < tmp.length; k++) {
            arr[p + k] = tmp[k];
        }
    }

    public static void merge_sentry(int[] arr, int p, int q, int r) {
        int[] left = new int[q - p + 2];
        left[q - p + 1] = Integer.MAX_VALUE;
        int[] right = new int[r - q + 1];
        right[r - q] = Integer.MAX_VALUE;
        for (int i = 0; i < q - p + 1; i++) {
            left[i] = arr[p + i];
        }
        for (int i = 0; i < r - q; i++) {
            right[i] = arr[q + 1 + i];
        }
        for (int i = 0, j = 0, n = 0; n < r - p + 1; n++) {
            if (left[i] <= right[j]) {
                arr[p + n] = left[i++];
            } else {
                arr[p + n] = right[j++];
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 2, 5, 1, 3, 5, 7, 8, 3, 2,12,11,6};
        merge_sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
