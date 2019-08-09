package topics.String.l415AddStrings;

public class Solution {
    // add from the tail
    // time O(len1) space O(len1)
    public String addStrings(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        if(len1 < len2) return addStrings(num2, num1);
        int car = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = len1 - 1; i >= len1 - len2; i--) {
            int now = num1.charAt(i) + num2.charAt(i - len1 + len2) + car - '0' * 2;
            if(now >= 10) {
                car = 1;
                now %= 10;
            }
            else car = 0;
            sb.insert(0, now);
        }

        for(int i = len1 - len2 - 1; i >= 0; i--) {
            int now = num1.charAt(i) - '0' + car;
            if(now >= 10) {
                car = 1;
                now %= 10;
            }
            else car = 0;
            sb.insert(0, now);
        }
        if(car == 1) sb.insert(0, car);
        return sb.toString();
    }
}
