package topics.BitManipulation.l405ConvertaNumbertoHexadecimal;

public class Solution {
    public String toHex(int num) {
        char[] dict = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
                , 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb = new StringBuilder();
        while(num != 0) {
            int cur = (num & 15);
            sb.insert(0, dict[cur]);
            num >>>= 4;
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}