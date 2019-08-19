package topics.String.l20ValidParentheses;
import java.util.*;
public class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '('); map.put(']', '['); map.put('}', '{');
        for(char c: s.toCharArray()) {
            if(c == '(' || c == '[' || c == '{') stack.push(c);
            else if(stack.isEmpty()) return false;
            else {
                if(stack.pop() != map.get(c)) return false;
            }
        }
        return stack.isEmpty();
    }
}