package Sort;

public class HeapSort_review {
    public void heapSort(int[] arr) {
        buildHeap(arr);
        int k = arr.length - 1;
        while (k > 0) {
            swap(arr, 0, k--);
            heapify(arr, 0, k);
        }
    }

    private void buildHeap(int[] arr) {
        int len = arr.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(arr, i, len - 1);
        }
    }

    private void heapify(int[] arr, int i, int n) {
        int maxPos = i;
        while (true) {
            if (i * 2 + 1 <= n && arr[i] < arr[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (i * 2 + 2 <= n && arr[maxPos] < arr[i * 2 + 2]) {
                maxPos = i * 2 + 2;
            }
            if (maxPos == i)
                break;
            swap(arr, i, maxPos);
            i = maxPos;
        }

    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 4, 2, 6, 9, 15, 18, 7, 5, 6};
        new HeapSort_review().heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
