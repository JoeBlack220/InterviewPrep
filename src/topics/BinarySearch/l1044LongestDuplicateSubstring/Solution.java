package topics.BinarySearch.l1044LongestDuplicateSubstring;
import java.util.*;
public class Solution {
    public String longestDupSubstring(String S) {
        int l = 1, r = S.length() - 1;
        String res = null;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            String last = search(mid, S);
            if(last == null) {
                r = mid - 1;
            }
            else {
                if(res == null || res.length() < last.length()) res = last;
                l = mid + 1;
            }
        }
        return res == null ? "" : res;
    }

    private String search(int len, String S) {
        long q = (1 << 31) - 1;
        Map<Long, List<Integer>> map = new HashMap<>();
        int d = 26;
        long h = 1;
        long hash_val = 0;
        for(int i = 1; i < len; ++i) h = (h * d) % q;
        for(int i = 0; i < len; ++i) {
            hash_val = (hash_val * d + S.charAt(i)) % q;
        }
        map.put(hash_val, new ArrayList<>());
        map.get(hash_val).add(0);

        for(int i = len; i < S.length(); ++i) {
            hash_val = ((hash_val - h * S.charAt(i - len)) * d % q  + S.charAt(i) + q) % q;
            if(!map.containsKey(hash_val)) {
                map.put(hash_val, new ArrayList<>());
                map.get(hash_val).add(i - len + 1);
            }
            else {
                String cur = S.substring(i - len + 1, i + 1);
                for(int index: map.get(hash_val)) {
                    String last = S.substring(index, index + len);
                    if(cur.equals(last)) return cur;
                }
                map.get(hash_val).add(i - len + 1);
            }
        }

        return null;
    }
}