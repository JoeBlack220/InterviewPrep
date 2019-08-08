package leetcode.Stack.l844BackspaceStringCompare;
import java.util.Stack;
public class Solution {
    // string builder solution
    public boolean backspaceCompare(String S, String T) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        build(sb1, S);
        build(sb2, T);
        return sb1.toString().equals(sb2.toString());
    }

    private void build(StringBuilder sb, String s) {
        for(char c: s.toCharArray()) {
            if(c == '#') {
                if(sb.length() != 0) sb.deleteCharAt(sb.length() - 1);
            }
            else sb.append(c);
        }
    }
}
// stack solution
class Solution1 {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for(char c : S.toCharArray()) {
            if(c == '#') {
                if(!stack1.empty()) stack1.pop();
            }
            else stack1.push(c);
        }

        for(char c : T.toCharArray()) {
            if(c == '#') {
                if(!stack2.empty()) stack2.pop();
            }
            else stack2.push(c);
        }

        while(!stack1.empty() && !stack2.empty()) {
            if(stack1.pop() != stack2.pop()) return false;
        }
        return stack1.size() == stack2.size();
    }
}
