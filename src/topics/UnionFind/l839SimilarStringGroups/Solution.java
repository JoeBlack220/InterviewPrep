package topics.UnionFind.l839SimilarStringGroups;
import java.util.*;
public class Solution {
    public int numSimilarGroups(String[] A) {
        Map<String, String> map = new HashMap<>();
        int len = A.length;
        int res = 0;
        for(int i = 0; i < len; ++i) {
            res++;
            for(int j = i - 1; j >= 0; --j) {
                if(A[i].equals(A[j])) {
                    res--;
                    break;
                }
                if(isAnagram(A[i], A[j])) {
                    if(union(map, A[i], A[j])) res--;
                }
            }
        }
        return res;
    }

    private String find(Map<String, String> map, String a) {
        if(map.get(a) == null) map.put(a, a);
        if(map.get(a) != a) {
            String parent = find(map, map.get(a));
            map.put(a, parent);
        }
        return map.get(a);
    }

    private boolean union(Map<String, String> map, String a, String b) {
        String aParent = find(map, a);
        String bParent = find(map, b);
        if(aParent != bParent) {
            map.put(aParent, bParent);
            return true;
        }
        return false;
    }

    private boolean isAnagram(String a, String b) {
        int lastDiff = -1;
        boolean flag = false;
        if(a.length() != b.length()) return false;
        for(int i = 0; i < a.length(); ++i) {
            if(a.charAt(i) != b.charAt(i)) {
                if(lastDiff == -1) lastDiff = i;
                else if(!flag){
                    if(a.charAt(lastDiff) != b.charAt(i) || a.charAt(i) != b.charAt(lastDiff))
                        return false;
                }
                else return false;
            }
        }
        return true;
    }
}
