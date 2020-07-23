package Sort;

public class MergeSort_review_722 {
    public void mergeSort(int[] arr) {
        sortInternal(arr, 0, arr.length - 1);
    }

    private void sortInternal(int[] arr, int p, int q) {
        if (p >= q)
            return;
        int r = p + (q - p) / 2;
        sortInternal(arr, p, r);
        sortInternal(arr, r + 1, q);
        merge(arr, p, q, r);
    }

    private void merge(int[] arr, int p, int q, int r) {
        int[] tmp = new int[q - p + 1];
        int i = 0;
        int j = p, k = r + 1;
        while (j <= r && k <= q) {
            if (arr[j] <= arr[k])
                tmp[i++] = arr[j++];
            else
                tmp[i++] = arr[k++];
        }
        while (j <= r)
            tmp[i++] = arr[j++];
        while (k <= q)
            tmp[i++] = arr[k++];
        for (int n = 0; n < tmp.length; n++) {
            arr[p + n] = tmp[n];
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 2, 5, 1, 3, 5, 7, 8, 3};
        MergeSort_review_722 m = new MergeSort_review_722();
        m.mergeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
