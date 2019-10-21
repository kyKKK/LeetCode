import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

//  有效的括号
public class LC_20 {
    public static boolean isValid(String s) {
        char[] ch = s.toCharArray();
        int len = ch.length;
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if (ch[i] == '(' || ch[i] == '[' || ch[i] == '{') {
                stack.push(ch[i]);
            } else {
                if (stack.size() == 0 || ch[i] == ')' && stack.pop() != '(' || ch[i] == ']' && stack.pop() != '[' || ch[i] == '}' && stack.pop() != '{')
                    return false;
            }
        }


        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
}
