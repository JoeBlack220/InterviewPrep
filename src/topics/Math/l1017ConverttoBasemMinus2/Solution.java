package topics.Math.l1017ConverttoBasemMinus2;

public class Solution {
    public String baseNeg2(int N) {
        StringBuilder res = new StringBuilder();
        while(N != 0){
            res.append(N & 1);
            N = - (N >> 1);
        }
        return res.length() > 0 ? res.reverse().toString() : "0";
    }
}