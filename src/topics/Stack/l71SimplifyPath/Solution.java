package topics.Stack.l71SimplifyPath;
import java.util.*;
public class Solution {
    public String simplifyPath(String path) {
        String[] arrs = path.split("/");
        StringBuilder sb = new StringBuilder();
        LinkedList<String> stack = new LinkedList<String>();
        for(String s: arrs) {
            if(s == null || s.length() == 0 || s.equals(".")) continue;
            if(s.equals("..")) {
                if(!stack.isEmpty()) stack.removeLast();
            }
            else {
                stack.add(s);
            }
        }

        for(String s: stack) {
            sb.append("/");
            sb.append(s);
        }
        if(sb.length() == 0) sb.append("/");
        return sb.toString();
    }
}