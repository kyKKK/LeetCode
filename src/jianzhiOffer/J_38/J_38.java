package jianzhiOffer.J_38;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class J_38 {
    int len;
    List<String> ret;

    public String[] permutation(String s) {
        len = s.length();
        ret = new ArrayList<>(len);
        boolean[] used = new boolean[s.length()];
        StringBuffer sb = new StringBuffer();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        helper(chars, sb, used);
        String[] retArr = new String[ret.size()];
        for (int i = 0; i < retArr.length; i++) {
            retArr[i] = ret.get(i);
        }
        return retArr;
    }

    private void helper(char[] chars, StringBuffer sb, boolean[] used) {
        if (chars.length == sb.length()) {
            ret.add(sb.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (!used[i]) {
                if (i > 0 && chars[i - 1] == chars[i] && !used[i - 1])
                    continue;
                sb.append(chars[i]);
                used[i] = true;
                helper(chars, sb, used);

                sb.deleteCharAt(sb.length() - 1);
                used[i] = false;
            }
        }

    }

    public static void main(String[] args) {
        J_38 j = new J_38();
        j.permutation("abc");
    }
}
