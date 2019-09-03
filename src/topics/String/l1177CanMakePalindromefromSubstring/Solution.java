package topics.String.l1177CanMakePalindromefromSubstring;
import java.util.*;
// use the ideas from range query
// make prefix sum arrays of the string
public class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int[][] cnts = new int[s.length() + 1][26];

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 26; j++) {
                cnts[i + 1][j] = cnts[i][j];
            }
            cnts[i + 1][s.charAt(i) - 'a']++;
        }

        List<Boolean> ret = new ArrayList<>();
        for(int[] q : queries){
            int odd = 0;
            for (int i = 0; i < 26; i++) {
                int nums = cnts[q[1] + 1][i] - cnts[q[0]][i];
                odd += nums % 2;
            }

            if(odd - 2 * q[2] <= 1) ret.add(true);
            else ret.add(false);
        }
        return ret;
    }
}