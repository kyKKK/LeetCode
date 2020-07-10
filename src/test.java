import java.io.IOException;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Collections;

public class test {
    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 1, 0, 1, 4, 4, -1};
        print(arr, 0, 6);
    }

    public static void print(int[] arr, int s, int t) {
        if (arr[t] != -1 && t != s) {
            print(arr, s, arr[t]);
        }
        System.out.println(t + " ");
    }
}
