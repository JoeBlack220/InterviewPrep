package leetcode.Design.l288UniqueWordAbbreviation;
import java.util.*;
public class ValidWordAbbr {
    // we return true if we don't have the current word abbreviation in our dictionary
    // or we have it, but we just have the exactly same word for the abbreviation
    // so we need to keep track of all the words with the same abbrevation
    Map<String, Set<String>> map;
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        for(String word: dictionary) {
            String afterAbbr = helper(word);
            Set curSet = map.computeIfAbsent(afterAbbr, x -> new HashSet<>());
            curSet.add(word);
        }
    }

    public boolean isUnique(String word) {
        String wordAfterAbbr = helper(word);
        if(!map.containsKey(wordAfterAbbr)) return true;
        else if(map.get(wordAfterAbbr).size() == 1 && map.get(wordAfterAbbr).contains(word)) return true;
        else return false;
    }

    private String helper(String toAbbr) {
        int len = toAbbr.length();
        if(len <= 2) return toAbbr;
        else return toAbbr.charAt(0) + Integer.toString(len - 2) + toAbbr.charAt(len - 1);
    }
}
