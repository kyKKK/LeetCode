package HW_Interview;

public class Solution {

    public void quickSort(int[] arr) {
        int len = arr.length;
        quickSortInternal(arr, 0, len - 1);
    }

    private void quickSortInternal(int[] arr, int left, int right) {
        if (left >= right)
            return;
        int mid = partition(arr, left, right);
        quickSortInternal(arr, left, mid - 1);
        quickSortInternal(arr, mid + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int i = left, j = left;
        int pivot = arr[right];
        for (; j < right; j++) {
            if (arr[j] < pivot) {
                if (i == j)
                    i++;
                else {
                    swap(arr, i, j);
                    i++;
                }
            }
        }
        swap(arr, i, j);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

