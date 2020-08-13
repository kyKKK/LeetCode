package jianzhiOffer.J_05;

public class Solution {
    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ')
                sb.append("%20");
            else
                sb.append(chars[i]);
        }
        return sb.toString();
    }

}
