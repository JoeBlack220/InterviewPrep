package topics.String.l937ReorderLogFiles;
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

// solution using split
class Solution3 {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String[] a_arr = a.split(" ");
                String[] b_arr = b.split(" ");
                boolean aIsLetter = Character.isLetter(a_arr[1].charAt(0));
                boolean bIsLetter = Character.isLetter(b_arr[1].charAt(0));

                if(!aIsLetter && !bIsLetter) return 0;
                else if(!bIsLetter) return -1;
                else if(!aIsLetter) return 1;
                else {
                    int len = Math.max(a_arr.length, b_arr.length);
                    for(int i = 1; i < len; ++i) {
                        if(i >= a_arr.length) return -1;
                        if(i >= b_arr.length) return 1;
                        int res = a_arr[i].compareTo(b_arr[i]);
                        if(res != 0) return res;
                    }
                    return a_arr[0].compareTo(b_arr[0]);
                }
            }
        });
        return logs;
    }
}