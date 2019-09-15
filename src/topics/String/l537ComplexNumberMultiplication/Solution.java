package topics.String.l537ComplexNumberMultiplication;

public class Solution {
    public String complexNumberMultiply(String a, String b) {
        int[] aarr = parse(a);
        int[] barr = parse(b);
        int real = aarr[0] * barr[0] - aarr[1] * barr[1];
        int comp = aarr[0] * barr[1] + aarr[1] * barr[0];
        StringBuilder sb = new StringBuilder();
        sb.append(real);
        sb.append('+');
        sb.append(comp);
        sb.append('i');
        return sb.toString();
    }

    private int[] parse(String a) {
        int plus = a.indexOf('+');
        int real = Integer.parseInt(a.substring(0, plus));
        int comp = Integer.parseInt(a.substring(plus + 1, a.length() - 1));
        return new int[]{real, comp};
    }
}