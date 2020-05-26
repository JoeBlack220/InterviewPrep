package topics.Stack.l1249MinimumRemovetoMakeValidParentheses;
import java.util.*;
public class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            }
            else if(s.charAt(i) == ')') {
                if(!stack.isEmpty()) {
                    set.add(i);
                    set.add(stack.pop());
                }
            }
        }

        for(int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) == '(' || s.charAt(i) == ')') {
                if(set.contains(i)) sb.append(s.charAt(i));
            }
            else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
