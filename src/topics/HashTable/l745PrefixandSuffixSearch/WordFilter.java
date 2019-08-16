package topics.HashTable.l745PrefixandSuffixSearch;
import java.util.*;
public class WordFilter {
    // solution 1
    // hash table
    // for each suffix and prefix of a word, put prefix_suffix into the hashtable
    // that will cover all the cases if prefix and suffix both match with the current word
    Map<String, Integer> map;
    public WordFilter(String[] words) {
        map = new HashMap<>();
        for(int j = 0; j < words.length; ++j) {
            String word = words[j];
            int len = word.length();
            String[] suffix = new String[len + 1];
            String[] prefix = new String[len + 1];
            for(int i = 0; i <= len; ++i) {
                prefix[i] = word.substring(0, i);
                suffix[i] = word.substring(i, len);
            }
            for(String p: prefix) {
                for(String s: suffix) {
                    map.put(p + "_" + s, j);
                }
            }
        }
    }

    public int f(String prefix, String suffix) {
        return map.getOrDefault(prefix + "_" + suffix, -1);
    }
}
