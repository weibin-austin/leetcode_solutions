package OnlineAssignment.Pax;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ValidParentheses {

    private Map<Character, Character> map = new HashMap<>();

    public ValidParentheses() {
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
    }

    public boolean solution(String s) {
        if(s.length() == 0) return true;

        Deque<Character> stack = new ArrayDeque<>();

        for(char c: s.toCharArray()) {
            if(map.containsKey(c)) {
                char top = stack.isEmpty() ? '#' : stack.pop();

                if(top != map.get(c)) return false;
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    @Test
    public void basic_test() {
        String s1 = "{}(()[]))(";
        String s2 = "{}[](){}[]";

        System.out.println("s1: " + solution(s1));
        System.out.println("s2: " + solution(s2));
    }
}
