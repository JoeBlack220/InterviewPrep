package topics.BinarySearch.l1095FindinMountainArray;
import java.util.*;

public class Solution {
    public int findInMountainArray(int target, MountainArray m) {
        int r = m.length() - 1, l = 0, p = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while(l < r - 1) {
            int mid = l + (r - l) / 2;
            int mid_0 = getHelper(m, mid - 1, map);
            int mid_1 = getHelper(m, mid, map);
            int mid_2 = getHelper(m, mid + 1, map);
            if(mid_1 > mid_0 && mid_1 > mid_2) {
                p = mid;
                break;
            }
            else if(mid_1 < mid_0) r = mid;
            else l = mid;
        }

        r = p + 1;
        l = 0;
        while(l < r) {
            int mid = l + (r - l) / 2;
            int m_val = getHelper(m, mid, map);
            if(m_val == target) return mid;
            else if(m_val < target) l = mid + 1;
            else r = mid;
        }

        r = m.length();
        l = p + 1;

        while(l < r) {
            int mid = l + (r - l) / 2;
            int m_val = getHelper(m, mid, map);
            if(m_val == target) return mid;
            else if(m_val < target) r = mid;
            else l = mid + 1;
        }

        return -1;
    }

    private int getHelper(MountainArray m, int i, Map<Integer, Integer> map) {
        if(map.containsKey(i)) return map.get(i);
        else {
            int res = m.get(i);
            map.put(i, res);
            return res;
        }
    }
}
interface MountainArray {
    public int get(int index);
    public int length();
}