import java.util.HashSet;
import java.util.Set;

public class LC_3 {

    //暴力
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (unique(i, j, s)) {
                    max = Math.max(max, j - i);
                }else
                    break;
            }
        }
        return max;
    }
    public boolean unique(int begin, int end, String s) {
        Set<Character> set = new HashSet<>();
        for (int i = begin; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch))
                return false;
            set.add(ch);
        }
        return true;
    }

    //滑动窗口
    public int lengthOfLongestSubstring2(String s) {
        int i=0, j=0, max=0;
        int n=s.length();
        Set<Character> set = new HashSet<>();
        while (i < n && j < n) {
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, j-i);
            }else
                set.remove(s.charAt(i++));
        }
        return max;
    }



    public static void main(String[] args) {
        LC_3 th = new LC_3();
        System.out.println(th.lengthOfLongestSubstring("aaaaavbnfhyiwo"));


    }
}
