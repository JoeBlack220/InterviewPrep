package leetcode.String.l937ReorderLogFiles;
import java.util.*;
public class Solution {
    // rewrite the comparator
    // then use the built in sort method
    // time O(nlogn) space O(1)
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
            char firstA = a.charAt(a.indexOf(' ') + 1);
            char firstB = b.charAt(b.indexOf(' ') + 1);
            boolean typeA = Character.isDigit(firstA);
            boolean typeB = Character.isDigit(firstB);
            if(typeA && typeB) return 0;
            else if (!typeA && typeB) return -1;
            else if (typeA && !typeB) return 1;
            else {
                int res = a.substring(a.indexOf(' ') + 1).compareTo(b.substring(b.indexOf(' ') + 1));
                if(res == 0) return a.substring(0, a.indexOf(' ') + 1).compareTo
                        (b.substring(b.indexOf(' ') + 1));
                else return res;
            }
        });
        return logs;
    }
}

class Solution2 {
    // another way to implement the sort
    // seems to be much faster then the first one (first one time 33ms, this one 6ms)
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                char firstA = a.charAt(a.indexOf(' ') + 1);
                char firstB = b.charAt(b.indexOf(' ') + 1);
                boolean typeA = Character.isDigit(firstA);
                boolean typeB = Character.isDigit(firstB);
                if(typeA && typeB) return 0;
                else if (!typeA && typeB) return -1;
                else if (typeA && !typeB) return 1;
                else {
                    int res = a.substring(a.indexOf(' ') + 1).compareTo(b.substring(b.indexOf(' ') + 1));
                    if(res == 0) return a.substring(0, a.indexOf(' ') + 1).compareTo
                            (b.substring(b.indexOf(' ') + 1));
                    else return res;
                }
            }
        });
        return logs;
    }
}