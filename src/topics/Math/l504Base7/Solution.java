package topics.Math.l504Base7;

public class Solution {
    public String convertToBase7(int num) {
        if(num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        boolean minus = num < 0;
        num = Math.abs(num);
        while(num != 0) {
            sb.insert(0, num % 7);
            num /= 7;
        }
        return minus ? "-" + sb.toString() : sb.toString();
    }
}