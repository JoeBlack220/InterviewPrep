package topics.Backtrack.l753CrackingtheSafe;
import java.util.*;
public class Solution {
    public String crackSafe(int n, int k) {
        StringBuilder start = new StringBuilder();
        StringBuilder res = new StringBuilder();
        Set<String> visited = new HashSet<>();
        int total = (int) Math.pow(k, n);

        for(int i = 0; i < n; ++i) start.append('0');
        String startString = start.toString();
        res.append(startString);
        visited.add(startString);
        if(backtrack(visited, res, k, n, total)) return res.toString();
        else return null;
    }

    private boolean backtrack(Set<String> visited, StringBuilder res, int k, int n, int total) {
        if(visited.size() == total) return true;
        for(int i = 0; i < k; ++i) {
            res.append(i);
            String toAppend = res.substring(res.length() - 1 - n + 1);
            if(visited.add(toAppend)) {
                if(backtrack(visited, res, k, n, total)) return true;
                else {
                    visited.remove(toAppend);
                }
            }
            res.deleteCharAt(res.length() - 1);
        }
        return false;
    }
}