package topics.String.l126WordLadderII;
import java.util.*;
public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(), begin = new HashSet<>(), end = new HashSet<>();
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        dict.addAll(wordList);
        if(!dict.contains(endWord)) return res;
        begin.add(beginWord);
        end.add(endWord);
        bfs(dict, begin, end, map);
        List<String> sofar = new ArrayList<>();
        sofar.add(beginWord);
        dfs(res, map, beginWord, endWord, sofar);
        return res;
    }
    // two-end bfs, map is used for recording the possible path from the begin word to the end word
    // we first use bfs to create the possible path, then using dfs to build the path
    private void bfs(Set<String> dict, Set<String> begin, Set<String> end, Map<String, List<String>> map) {
        boolean reverse = false;
        boolean terminal = false;
        while(begin.size() > 0) {
            dict.removeAll(begin);
            dict.removeAll(end);
            if(begin.size() > end.size()) {
                reverse = !reverse;
                Set<String> temp = begin;
                begin = end;
                end = temp;
            }
            Set<String> nextBegin = new HashSet<>();
            for(String s: begin) {
                char[] arr = s.toCharArray();
                for(int i = 0; i < s.length(); ++i) {
                    char c = arr[i];
                    for(char r = 'a'; r <= 'z'; ++r) {
                        if(r == c) continue;
                        arr[i] = r;
                        String candidate = new String(arr);
                        if(end.contains(candidate)) {
                            // System.out.println(candidate);
                            if(!reverse) {
                                if(!map.containsKey(s)) map.put(s, new ArrayList<>());
                                map.get(s).add(candidate);
                                terminal = true;
                            }
                            else {
                                if(!map.containsKey(candidate)) map.put(candidate, new ArrayList<>());
                                map.get(candidate).add(s);
                                terminal = true;
                            }
                        }
                        else if(dict.contains(candidate)) {
                            // System.out.println(candidate);

                            if(!reverse) {
                                if(!map.containsKey(s)) map.put(s, new ArrayList<>());
                                map.get(s).add(candidate);
                                nextBegin.add(candidate);
                            }
                            else {
                                if(!map.containsKey(candidate)) map.put(candidate, new ArrayList<>());
                                map.get(candidate).add(s);
                                nextBegin.add(candidate);
                            }
                        }
                    }
                    arr[i] = c;
                }
            }
            if(terminal) return;
            begin = nextBegin;
        }
    }

    private void dfs(List<List<String>> res, Map<String, List<String>> map, String begin, String end, List<String> sofar) {
        if(!map.containsKey(begin)) return;
        for(String s: map.get(begin)) {
            if(s.equals(end)) {
                List<String> toAppend = new ArrayList<>(sofar);
                toAppend.add(end);
                res.add(toAppend);
                return;
            }
            else {
                sofar.add(s);
                dfs(res, map, s, end, sofar);
                sofar.remove(sofar.size() - 1);
            }
        }
    }
}