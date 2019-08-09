package topics.Backtrack.l22GenerateParentheses;
import java.util.*;
public class Solution {
    // iterate method
    public static List<String> generateParenthesis(int n) {
        List<List<String>> cache = new LinkedList<>();
        cache.add(Arrays.asList(""));

        for (int i = 1; i <= n; i++) {
            List<String> nList = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                List<String> inside = cache.get(j);
                List<String> tail = cache.get(i - j - 1);
                for (int k = 0; k < inside.size(); k++) {
                    for (int l = 0; l < tail.size(); l++) {
                        nList.add("(" + inside.get(k) + ")" + tail.get(l));
                    }
                }
            }
            cache.add(nList);
        }
        return cache.get(n);
    }
    // backtrack (recursive) method
    // performance time is similar
    List<String> res = new LinkedList<>();
    public List<String> generateParenthesis2(int n) {
        helper(new StringBuilder(), n, n);
        return res;
    }

    private void helper(StringBuilder sb, int l, int r) {
        if(r == 0 && l == 0) res.add(sb.toString());
        if(l > r || l < 0 || r < 0) return;
        sb.append('(');
        helper(sb, l - 1, r);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(')');
        helper(sb, l, r - 1);
        sb.deleteCharAt(sb.length() - 1);
    }
}
