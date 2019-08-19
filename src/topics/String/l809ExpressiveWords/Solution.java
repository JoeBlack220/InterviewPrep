package topics.String.l809ExpressiveWords;

public class Solution {
    public int expressiveWords(String S, String[] words) {
        int res = 0;
        for(String word: words) {
            int p_w = 0;
            int p_s = 0;
            while(p_w < word.length()) {
                if(p_s >= S.length() || word.charAt(p_w) != S.charAt(p_s)) {
                    break;
                }
                else {
                    int next_w = p_w;
                    int next_s = p_s;
                    while(next_w < word.length() && word.charAt(p_w) == word.charAt(next_w)) next_w++;
                    while(next_s < S.length() && S.charAt(p_s) == S.charAt(next_s)) next_s++;
                    if((next_w - p_w) > (next_s - p_s) || ((next_w - p_w) != (next_s - p_s) && (next_s - p_s) < 3)) {
                        break;
                    }
                    else{
                        p_w = next_w;
                        p_s = next_s;
                    }
                }
            }
            if(p_w == word.length() && p_s == S.length()) res++;
        }
        return res;
    }
}