package LeetcodeSolutions.stack;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ValidParentheses {
    Map<Character, Character> map;

    public ValidParentheses(){
        this.map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
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
        String s = "{}{{}()(){}}[]()";
        System.out.println(solution(s));
    }
}
