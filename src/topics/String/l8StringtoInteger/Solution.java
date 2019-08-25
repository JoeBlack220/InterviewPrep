package topics.String.l8StringtoInteger;

public class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0) return 0;
        int pointer = 0;
        while(pointer < str.length() && str.charAt(pointer) == ' ') pointer++;
        int last = 0, cur = 0;
        boolean minus = false;
        boolean start = false;
        while(pointer < str.length()) {
            char c = str.charAt(pointer);
            if(!Character.isDigit(c) && !start) {
                if(c == '-' || c == '+') {
                    start = true;
                    minus = c == '-';
                }
                else {
                    return 0;
                }
            }
            else if(!Character.isDigit(c) && start) {
                return cur;
            }
            else if(minus) {
                start = true;
                cur *= 10;
                cur -= (c - '0');
                if(cur / 10 != last) return Integer.MIN_VALUE;
                last = cur;
            }
            else {
                start = true;
                cur *= 10;
                cur += c - '0';
                // System.out.println(cur);
                if(cur / 10 != last) return Integer.MAX_VALUE;
                last = cur;
            }
            pointer++;
        }
        return cur;
    }
}
