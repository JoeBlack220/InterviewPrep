package topics.HashTable.l246StrobogrammaticNumber;
import java.util.HashMap;
public class Solution {
    public boolean isStrobogrammatic(String num) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(0, 0);
        // map.put(2, 5);
        // map.put(5, 2);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
        int len = num.length();
        for(int i = 0; i < (len + 1) / 2; ++i) {
            int head = num.charAt(i) - '0';
            int tail = num.charAt(len - 1 - i) - '0';
            if(!map.containsKey(head)) return false;
            else if(map.get(head) != tail) return false;
        }
        return true;

    }
}