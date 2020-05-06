package Cell_division;

public class Solution {
    public static int cell_division(int n) {
        if (n < 0)
            return 0;
        if (n == 0)
            return 1;
        if (n == 1)
            return 2;
        if (n == 2)
            return 4;
        if (n == 3)
            return 7;
        return cell_division(n - 1) * 2 - cell_division(n - 4);
    }

    public static void main(String[] args) {
        System.out.println(cell_division(5));
    }
}
