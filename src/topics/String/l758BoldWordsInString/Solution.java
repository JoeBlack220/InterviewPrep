package topics.String.l758BoldWordsInString;
import java.util.*;
public class Solution {
    // using substring and equals beats 45%
    public String boldWords(String[] words, String S) {
        if (words == null || words.length == 0) return "";

        boolean[] marked = new boolean[S.length()];
        for (String word : words) {
            markWords(S, word, marked);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (marked[i] && (i == 0 || !marked[i - 1])) {
                sb.append("<b>");
            }
            sb.append(S.charAt(i));
            if (marked[i] && (i == S.length() - 1 || !marked[i + 1])) {
                sb.append("</b>");
            }
        }
        return sb.toString();
    }

    private void markWords(String S, String word, boolean[] marked) {
        for (int i = 0; i <= S.length() - word.length(); i++) {
            String substr = S.substring(i, i + word.length());
            if (substr.equals(word)) {
                for (int j = i; j < i + word.length(); j++) {
                    marked[j] = true;
                }
            }
        }
    }
}

class Solution2 {
    // using KMP to search for pattern beats 71.38%
    public String boldWords(String[] words, String S) {
        boolean[] bold = new boolean[S.length ()];
        for (int i = 0; i < words.length; i++) {
            List<Integer> indices = kmp (S, words[i]);
            if (!indices.isEmpty ()) for (int idx : indices) for (int j = 0; j < words[i].length (); j++)
                bold[idx + j] = true;
        }
        char[] chs = S.toCharArray ();
        StringBuilder sb = new StringBuilder ();
        if (bold[0]) sb.append ("<b>");
        for (int i = 0; i < chs.length; i++) {
            if (bold[i] && i > 0 && !bold[i - 1]) sb.append ("<b>");
            sb.append (String.valueOf (chs[i]));
            if (bold[i] && i < chs.length - 1 && !bold[i + 1]) sb.append ("</b>");
        }
        if (bold[chs.length - 1]) sb.append ("</b>");
        return sb.toString ();
    }

    List<Integer> kmp (String A, String B) {
        List<Integer> res = new ArrayList<> ();
        char[] cha = A.toCharArray (), chb = B.toCharArray ();
        int[] lps = new int[chb.length];
        for (int len = 0, i = 1; i < chb.length; ) {
            if (chb[len] == chb[i]) lps[i++] = ++len;
            else if (len > 0) len = lps[len - 1];
            else i++;
        }
        for (int i = 0, j = 0; i < cha.length; i += j - lps[j - 1], j = lps[j - 1]) {
            while (j < chb.length && i + j < cha.length && cha[i + j] == chb[j]) j++;
            if (j == chb.length) {
                res.add (i);
                continue;
            }
            if (i + j >= cha.length) break;
            if (j == 0) j++;
        }
        return res;
    }
}
