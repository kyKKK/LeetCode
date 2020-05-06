package Sort;

public class Insert_sort {
    public static void insert_sort(int[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            int j;
            int val = arr[i];
            for (j = i - 1; j >= 0; j--) {
                if (val < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = val;
        }
    }
    public static void main(String[] args) {
        int arr[] = {1, 3, 2, 5, 1, 3, 5, 7, 8, 3, 2};
        insert_sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
