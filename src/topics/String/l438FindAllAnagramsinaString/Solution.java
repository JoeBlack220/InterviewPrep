package topics.String.l438FindAllAnagramsinaString;
import java.util.*;
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int len = s.length();
        int[][] dict = new int[len + 1][26];

        for(int i = 0; i < s.length(); ++i) {
            for(int j = 0; j < 26; ++j) {
                dict[i + 1][j] = dict[i][j];
            }
            dict[i + 1][s.charAt(i) - 'a']++;
        }

        int[] pdict = new int[26];
        for(char c: p.toCharArray()) pdict[c - 'a']++;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < s.length() - p.length() + 1; ++i) {
            for(int j = 0; j < 26; ++j) {
                if(dict[i + p.length()][j] - dict[i][j] != pdict[j]) {
                    // if(pdict[j] != 0)System.out.println(dict[i + p.length()][j] + "," + dict[i][j] + "," + j);
                    break;
                }
                if(j == 25) res.add(i);
            }
        }
        return res;
    }
}