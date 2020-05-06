package Sort;

public class Heap_Sort {
    public static void heap_sort(int[] arr) {
        build_heap(arr);
        int k = arr.length - 1;
        while (k > 0) {
            swap(arr, 0, k--);
            heapify(arr, k, 0);
        }
    }

    public static void build_heap(int[] arr) {
        int len = arr.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(arr, len - 1, i);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int maxPos = i;
        while (true) {
            if (i * 2 + 1 <= n && arr[i * 2 + 1] > arr[maxPos]) {
                maxPos = i * 2 + 1;
            }
            if (i * 2 + 2 <= n && arr[i * 2 + 2] > arr[maxPos]) {
                maxPos = i * 2 + 2;
            }
            if (maxPos == i) {
                break;
            }
            swap(arr, i, maxPos);
            i = maxPos;

        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 4, 2, 6, 9, 15, 18, 7, 5, 6};
        heap_sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
