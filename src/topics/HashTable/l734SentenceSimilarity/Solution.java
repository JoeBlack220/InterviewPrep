package topics.HashTable.l734SentenceSimilarity;
import java.util.*;
public class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
        if(words1.length != words2.length) return false;
        Map<String, Set<String>> map = new HashMap<>();
        for(List<String> pair : pairs) {
            String s1 = pair.get(0);
            String s2 = pair.get(1);
            Set<String> set1, set2;
            if(map.containsKey(s1)) set1 = map.get(s1);
            else {
                set1 = new HashSet<>();
                map.put(s1, set1);
            }
            if(map.containsKey(s2)) set2 = map.get(s2);
            else {
                set2 = new HashSet<>();
                map.put(s2, set2);
            }
            set1.add(s2);
            set2.add(s1);
        }
        for(int i = 0; i < words1.length; i++) {
            String s1 = words1[i], s2 = words2[i];
            if(!s1.equals(s2) && (!map.containsKey(s1) || !map.get(s1).contains(s2))){
                return false;
            }
        }
        return true;
    }
}