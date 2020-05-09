package LC_3;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int right = -1, len = s.length(), ret = 0;
        for (int i = 0; i < len; i++) {
            if (i > 0)
                set.remove(s.charAt(i - 1));
            while (right + 1 < len) {
                if (!set.contains(s.charAt(right + 1))) {
                    set.add(s.charAt(++right));
                    ret = Math.max(ret, set.size());
                } else break;
            }
            if(len-1-i<=ret)
                break;

        }
        return ret;
    }
}
