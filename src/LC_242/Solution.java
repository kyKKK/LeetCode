package LC_242;

import java.util.Arrays;

public class Solution {

    //  排序
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    //  哈希表1
    public boolean isAnagram_1(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
            table[t.charAt(i) - 'a']--;
        }
        for (int c : table) {
            if (c != 0)
                return false;
        }
        return true;
    }
    //  哈希表2
    public boolean isAnagram_2(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {

            if((--table[t.charAt(i)-'a'])<0)
                return false;
        }
        return true;
    }
}
