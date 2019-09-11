package topics.Stack.l32LongestValidParentheses;
import java.util.Deque;
import java.util.LinkedList;
public class Solution {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new LinkedList<>();
        int res = 0, left = -1;

        for(int j = 0; j < s.length(); ++j) {
            if(s.charAt(j) == '(') {
                stack.push(j);
            }
            else {
                if(stack.isEmpty()) left = j;
                else {
                    stack.pop();
                    if(stack.isEmpty()) {
                        res = Math.max(j - left, res);
                    }
                    else {
                        res = Math.max(j - stack.peek(), res);
                    }
                }
            }
        }
        return res;
    }
}