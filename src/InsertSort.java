import java.util.ArrayList;
import java.util.Arrays;

public class InsertSort {
    static int count=0;
    public static void insertSort(int[] arr) {

        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int value = arr[i];
            int j=i-1;
            for (; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                }else
                    break;
                count++;
            }

            arr[j + 1] = value;
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 2, 5, 1, 3, 5, 7, 8, 3, 2};
        insertSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println("count: "+count);
    }
}
