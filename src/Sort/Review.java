package Sort;

import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;

//  2020年5月12日
public class Review {
    public static void insert_sort(int[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            int val = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > val)
                    arr[j + 1] = arr[j];
                else break;
            }
            arr[j + 1] = val;
        }

    }

    public static void merge_sort(int[] arr) {
        int len = arr.length;
        merge_sort_internal(arr, 0, len - 1);
    }

    public static void merge_sort_internal(int[] arr, int left, int right) {
        if (left >= right)
            return;
        int mid = (left + right) / 2;
        System.out.println("now left: " + left + " mid: " + mid + " right: " + right);

        merge_sort_internal(arr, left, mid);
        merge_sort_internal(arr, mid + 1, right);
        merge_sentry(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left, j = mid + 1, n = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j])
                tmp[n++] = arr[i++];
            else
                tmp[n++] = arr[j++];
        }
        while (i <= mid)
            tmp[n++] = arr[i++];
        while (j <= right)
            tmp[n++] = arr[j++];
        for (int cur = 0; cur < n; cur++) {
            arr[left + cur] = tmp[cur];
        }
    }

    public static void merge_sentry(int[] arr, int left, int mid, int right) {
        int[] l = new int[mid - left + 2];
        int[] r = new int[right - mid + 1];
        for (int i = 0; i < mid - left + 1; i++) {
            l[i] = arr[left + i];
        }
        for (int i = 0; i < right - mid; i++) {
            r[i] = arr[mid + 1 + i];
        }
        l[mid - left + 1] = Integer.MAX_VALUE;
        r[right - mid] = Integer.MAX_VALUE;
        int i = 0, j = 0;
        for (int n = 0; n < right - left + 1; n++) {
            if (l[i] <= r[j])
                arr[left + n] = l[i++];
            else
                arr[left + n] = r[j++];
        }
    }

    public static void quick_sort(int[] arr) {
        int left = 0, right = arr.length - 1;
        quick_sort_internal(arr, left, right);
    }

    public static void quick_sort_internal(int[] arr, int left, int right) {
        if (left >= right)
            return;
        int p = partition(arr, left, right);
        quick_sort_internal(arr, left, p - 1);
        quick_sort_internal(arr, p + 1, right);
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left, j = left;
        while (j < right) {
            if (arr[j] <= pivot) {
                if (i == j) {
                    ++i;
                    ++j;
                } else {
                    swap(arr, i, j);
                    ++i;
                    ++j;
                }
            } else
                ++j;
        }
        swap(arr, i, j);
        return i;
    }

    public static void heapSort(int[] arr) {
        buildHeap(arr, arr.length);
        for (int i = arr.length; i > 1; i--) {
            swap(arr, 0, i - 1);
            heapify(arr, i - 1, 0);
        }
    }

    public static void buildHeap(int[] arr, int n) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

    }

    public static void heapify(int[] arr, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 + 1 < n && arr[i] < arr[i * 2 + 1])
                maxPos = i * 2 + 1;
            if (i * 2 + 2 < n && arr[maxPos] < arr[i * 2 + 2])
                maxPos = i * 2 + 2;
            if (maxPos == i)
                break;
            swap(arr, i, maxPos);
            i = maxPos;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    //  生成测试用例
    public static int[] selectSort(int n, int rodanf, int raanl) {
        int[] a = new int[n];
        Random random = new Random();
        if (raanl > rodanf) {
            for (int i = 0; i < n; i++) {
                a[i] = (int) Math.round(Math.random() * (raanl - rodanf + 1) + rodanf);
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] ints = selectSort(100, 20, 100);
        System.out.println(Arrays.toString(ints));
        heapSort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
