package topics.BitManipulation.l1178NumberofValidWordsforEachPuzzle;
import java.util.*;
public class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int wordLen = words.length, puzzleslen = puzzles.length;
        int[] ws = new int[wordLen];
        for(int i = 0; i < wordLen; ++i) {
            ws[i] = create(words[i]);
        }
        for(int j = 0; j < puzzleslen; ++j) {
            int cur = create(puzzles[j]);
            String sig = puzzles[j].charAt(0) + "" + cur;

            if(map.containsKey(sig)) {
                res.add(map.get(sig));
                continue;
            }
            int count = 0;
            for(int i = 0; i < wordLen; ++i) {
                if((cur & ws[i]) != ws[i]) continue;
                if(((1 << (puzzles[j].charAt(0) - 'a')) & ws[i]) == 0) continue;
                count++;
            }
            res.add(count);
            map.put(sig, count);
        }
        return res;
    }
    public int create(String p) {
        int res = 0;
        for(char c: p.toCharArray()) {
            res = res | (1 << (c - 'a'));
        }
        return res;
    }


}