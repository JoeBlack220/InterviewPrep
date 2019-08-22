package topics.BreadthFirstSearch.l127WordLadder;
import java.util.*;
public class Solution {
    // bfs solution
    // time O(b^d) d is depth while b is breadth
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        Set<String> visited = new HashSet<>();

        for(String word: wordList) dict.add(word);
        if(!dict.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int count = 1;
        while(!queue.isEmpty()) {
            count ++;
            int size = queue.size();
            for(int m = 0; m < size; ++m){
                String cur = queue.poll();
                for(int i = 0; i < cur.length(); ++i) {
                    char[] sarr = cur.toCharArray();
                    for(char c = 'a'; c <= 'z'; ++c) {
                        sarr[i] = c;
                        String next = new String(sarr);
                        if(next.equals(endWord)) return count;
                        else if(dict.contains(next) && visited.add(next)) {
                            queue.offer(next);
                        }
                    }
                }
            }
        }
        return 0;
    }
}

// solution 2 bidirectional bfs
// time b^(d/2)
class Solution2 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Set<String> begin = new HashSet<>(), end = new HashSet<>(), visited = new HashSet<>();
        int count = 1, len = beginWord.length();

        if(!dict.contains(endWord)) return 0;

        begin.add(beginWord);
        end.add(endWord);
        visited.add(endWord);

        while(!begin.isEmpty() && !end.isEmpty()) {
            count++;
            if(begin.size() > end.size()) {
                Set<String> temp = begin;
                begin = end;
                end = temp;
            }
            Set<String> nextBegin = new HashSet<>();
            for(String s: begin) {
                for(int i = 0; i < len; ++i) {
                    char[] arr = s.toCharArray();
                    for(char c = 'a'; c <= 'z'; ++c) {
                        arr[i] = c;
                        String next = new String(arr);
                        if(end.contains(next)) return count;
                        else if(dict.contains(next) && visited.add(next)) {
                            nextBegin.add(next);
                        }
                    }
                }
            }
            begin = nextBegin;
        }
        return 0;
    }
}