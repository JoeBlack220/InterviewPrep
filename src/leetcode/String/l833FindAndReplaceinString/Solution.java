package leetcode.String.l833FindAndReplaceinString;
import java.util.*;
public class Solution {
    // time O(n) space O(n)
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        HashMap<Integer, Pair> map = new HashMap<>();
        for(int i = 0; i < indexes.length; ++i) {
            map.put(indexes[i], new Pair(sources[i], targets[i]));
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < S.length(); ) {
            if(map.containsKey(i) && S.substring(i).startsWith(map.get(i).src)) {
                sb.append(map.get(i).tar);
                i += map.get(i).src.length();
            }
            else {
                sb.append(S.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }

    class Pair{
        String src;
        String tar;
        public Pair(String src, String tar) {
            this.src = src;
            this.tar = tar;
        }
    }
}
