package LC_3;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, max = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            char ch = s.charAt(right);
            while (set.contains(ch)) {
                set.remove(s.charAt(left++));
            }
            set.add(ch);
            right++;
            max = Math.max(max, set.size());
        }
        return max;
    }
}
