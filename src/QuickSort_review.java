public class QuickSort_review {
    public static void quickSort(int[] arr) {
        int len = arr.length;
        sort_internal(arr, 0, len - 1);

    }

    public static void sort_internal(int[] arr, int p, int q) {
        if (p >= q) {
            return;
        }
        int r = partition(arr, p, q);
        sort_internal(arr, p, r - 1);
        sort_internal(arr, r + 1, q);
    }

    public static int partition(int[] arr, int p, int q) {
        int pivot = arr[q];
        int i = p, j = p;
        while (j < q) {
            if (arr[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    swap(arr, i, j);
                    ++i;
                }
                ++j;
            }
            ++j;
        }
        swap(arr, i, j);
        return i;
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 2, 5, 1, 3, 5, 7, 8, 3};
        int[] arr2 = {1, 0};
        quickSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
