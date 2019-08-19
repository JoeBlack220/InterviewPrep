package topics.String.l929UniqueEmailAddresses;
import java.util.*;
public class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> visited = new HashSet<>();
        for(String email: emails) visited.add(filter(email));
        return visited.size();
    }

    private String filter(String s) {
        StringBuilder sb = new StringBuilder();
        boolean afterAt = false;
        boolean afterPlus = false;
        for(char c: s.toCharArray()) {
            if(c == '@') afterAt = true;
            if(!afterPlus && !afterAt) {
                if(c == '+') afterPlus = true;
                else if(c == '.') continue;
                else sb.append(c);
            }
            else if(afterPlus && !afterAt) continue;
            else sb.append(c);
        }
        return sb.toString();
    }
}
