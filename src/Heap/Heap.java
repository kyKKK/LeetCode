package Heap;

import java.util.ArrayList;

public class Heap {
    int size;
    int count;
    int[] arr;

    public Heap(int size) {
        this.size = size;
        arr = new int[size + 1];
    }

    public void insert(int val) {

        if (count >= size)
            return;
        arr[count++] = size;
        int i = count;
        while (i / 2 > 0 && arr[i / 2] > arr[i]) {
            swap(arr, i / 2, i);
            i = i / 2;
        }
    }

    public int removeFirst() {
        int ret_val = arr[1];
        arr[1] = arr[count--];
        heapify(arr, 1, count);
        return ret_val;
    }

    public void heapify(int[] arr, int i, int n) {
        int minPos = i;
        while (true) {
            if (i * 2 <= n && minPos < arr[i * 2]) {
                minPos = i * 2;
            }
            if (i * 2 + 1 <= n && minPos < arr[i * 2 + 1]) {
                minPos = i * 2 + 1;
            }
            if (minPos == i)
                return;
            swap(arr, i, minPos);
            i = minPos;
        }
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
