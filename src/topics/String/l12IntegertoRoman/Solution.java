package topics.String.l12IntegertoRoman;

public class Solution {
// I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000
    public String intToRoman(int num) {
        int[] vals = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < vals.length; ++i) {
            while(vals[i] <= num) {
                sb.append(symbols[i]);
                num -= vals[i];
            }
        }
        return sb.toString();
    }
}