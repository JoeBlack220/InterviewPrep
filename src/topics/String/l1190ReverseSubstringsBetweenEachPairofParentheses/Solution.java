package topics.String.l1190ReverseSubstringsBetweenEachPairofParentheses;

public class Solution {
    public String reverseParentheses(String s) {
        return helper("((" + s + "))", new int[]{0});

    }

    private String helper(String s, int[] index) {
        boolean flag = false;

        if(s.charAt(index[0]) == '(') {
            index[0]++;
            flag = true;
        }

        StringBuilder sb = new StringBuilder();

        while(index[0] < s.length() && s.charAt(index[0]) != ')') {
            if(s.charAt(index[0]) == '(') {
                sb.append(helper(s, index));
            }
            else sb.append(s.charAt(index[0]));
            index[0]++;
        }

        return flag ? sb.reverse().toString() : sb.toString();
    }
}