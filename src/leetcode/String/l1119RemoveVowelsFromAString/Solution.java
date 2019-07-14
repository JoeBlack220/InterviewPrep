package leetcode.String.l1119RemoveVowelsFromAString;
import java.util.Set;
import java.util.HashSet;
public class Solution {
    // use a set to help check whether we encounter a vowel
    // time O(n) space O(1)
    public String removeVowels(String S) {
        Set<Character> set = new HashSet<>();
        set.add('a'); set.add('e'); set.add('i'); set.add('o'); set.add('u');
        StringBuilder sb = new StringBuilder();
        for(char c: S.toCharArray()) {
            if(set.contains(c)) continue;
            sb.append(c);
        }
        return sb.toString();
    }
    // we can also use regular expression to help
    public String removeVowels2(String S) {
        return S.replaceAll("[aeiou]", "");
    }
}
