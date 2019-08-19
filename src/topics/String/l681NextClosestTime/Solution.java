package topics.String.l681NextClosestTime;
import java.util.TreeSet;
public class Solution {
    public String nextClosestTime(String time) {
        StringBuilder sb = new StringBuilder();
        TreeSet<Character> set = new TreeSet<>();
        for(char c: time.toCharArray()) {
            if(c != ':') set.add(c);
        }
        boolean flag = false;
        for(int i = time.length() - 1; i >= 0; --i) {
            char cur = time.charAt(i);
            if(flag) sb.append(cur);
            else {
                if(cur == ':') sb.append(cur);
                else {
                    Character sub = set.higher(cur);
                    if(valid(sub, i, time)) {
                        flag = true;
                        sb.append(sub);
                    }
                    else {
                        sb.append(set.first());
                    }
                }
            }
        }
        return sb.reverse().toString();
    }

    private boolean valid(Character c, int i, String t) {
        if(c == null) return false;
        if(i == 3 && c >= '6') return false;
        else if(i == 1 && t.charAt(0) == '2' && c >= '4') return false;
        else if(i == 0 && c >= '2') return false;
        return true;
    }
}
