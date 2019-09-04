package topics.String.l67AddBinary;

public class Solution {
    public String addBinary(String a, String b) {
        int indexA = a.length() - 1, indexB = b.length() - 1;
        int car = 0;
        StringBuilder sb = new StringBuilder();
        while(indexA >= 0 || indexB >= 0 || car > 0) {
            int curA = indexA >= 0 ? (a.charAt(indexA--) - '0') : 0;
            int curB = indexB >= 0 ? (b.charAt(indexB--) - '0') : 0;
            car = car + curA + curB;
            sb.insert(0, car % 2);
            car >>= 1;
        }
        return sb.toString();
    }
}