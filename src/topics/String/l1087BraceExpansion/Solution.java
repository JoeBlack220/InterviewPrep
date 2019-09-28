package topics.String.l1087BraceExpansion;
import java.util.*;
public class Solution {
    public String[] expand(String S) {
        List<String> res = new ArrayList<>();
        parse(S, 0, new StringBuilder(), res);
        String[] s_arr = new String[res.size()];
        for(int i = 0; i < res.size(); ++i) s_arr[i] = res.get(i);
        Arrays.sort(s_arr);
        return s_arr;
    }

    private void parse(String s, int index, StringBuilder sb, List<String> res) {
        while(index < s.length()) {
            if(s.charAt(index) == '{') {
                mul(s, index, sb, res);
                return;
            }
            else {
                sb.append(s.charAt(index));
            }
            index++;
        }
        res.add(sb.toString());
    }

    private void mul(String s, int index, StringBuilder sb, List<String> res) {
        int start = (++index);
        int end = s.indexOf('}', index);
        String[] options = s.substring(start, end).split(",");
        index = (++end);
        for(String o: options) {
            StringBuilder sb_new = new StringBuilder(sb);
            sb_new.append(o);
            parse(s, index, sb_new, res);
        }
    }
}