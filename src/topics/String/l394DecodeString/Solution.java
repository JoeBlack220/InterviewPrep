package topics.String.l394DecodeString;
import java.util.*;
// solution 1 recursively parse the string
public class Solution {
    public String decodeString(String s) {
        return helper(s, new int[]{0});
    }

    private String helper(String s, int[] curIndex) {
        while(curIndex[0] < s.length() && s.charAt(curIndex[0]) == '[') curIndex[0]++;
        StringBuilder sb = new StringBuilder();
        while(curIndex[0] < s.length() && s.charAt(curIndex[0]) != ']') {
            // System.out.println(curIndex[0]);
            if(Character.isDigit(s.charAt(curIndex[0]))) {
                int k = 0;
                while(Character.isDigit(s.charAt(curIndex[0]))) {
                    k *= 10;
                    k += s.charAt(curIndex[0] ++) - '0';
                }
                String inside = helper(s, curIndex);
                for(int i = 0; i < k; ++i) sb.append(inside);
            }
            else sb.append(s.charAt(curIndex[0]++));
        }
        if(curIndex[0] < s.length() && s.charAt(curIndex[0]) == ']') curIndex[0]++;
        return sb.toString();
    }
}
// solution2 using a stack to iteratively parse the string
class Solution2 {
    public String decodeString(String s) {
        Stack<Integer> intStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        int k = 0;
        StringBuilder res = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                k = k * 10 + ch - '0';
            }
            else if(ch == '['){
                intStack.push(k);
                strStack.push(res);
                res = new StringBuilder();
                k = 0;
            }
            else if(ch == ']'){
                StringBuilder curString = res;
                res = strStack.pop();
                for(k = intStack.pop(); k > 0; --k){
                    res.append(curString);
                }
            }
            else{
                res.append(ch);
            }
        }
        return res.toString();
    }
}