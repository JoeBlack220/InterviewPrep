package topics.TopologicalSort.l269AlienDictionary;
import java.util.*;
public class Solution {
    public String alienOrder(String[] words) {
        Set<Character>[] dict = new Set[26];
        int[] indegree = new int[26];
        int count = 0;
        for(String w: words) {
            for(char c: w.toCharArray()) {
                if(dict[c - 'a'] == null) {
                    count ++;
                    dict[c - 'a'] = new HashSet<>();
                }
            }
        }
        for(int i = 1; i < words.length; ++i) {
            buildDict(words[i - 1], words[i], indegree, dict);
        }
        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        for(int i = 0; i < 26; ++i) {
            if(indegree[i] == 0 && dict[i] != null) {
                char c = (char)(i + 'a');
                q.offer(c);
                sb.append(c);
            }
        }

        while(!q.isEmpty()) {
            char cur = q.poll();
            for(char c: dict[cur - 'a']) {
                indegree[c - 'a']--;
                if(indegree[c - 'a'] == 0) {
                    q.offer(c);
                    sb.append(c);
                }
            }
        }

        return sb.length() == count ? sb.toString() : "";
    }

    private void buildDict(String s1, String s2, int[] indegree, Set<Character>[] dict) {
        for(int i = 0; i < s1.length(); ++i) {
            if(i >= s2.length()) break;
            if(s1.charAt(i) == s2.charAt(i)) continue;
            else {
                if(dict[s1.charAt(i) - 'a'].add(s2.charAt(i))) {
                    indegree[s2.charAt(i) - 'a'] ++;
                }
                break;
            }
        }
    }
}