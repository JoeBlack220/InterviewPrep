package topics.Greedy.l763PartitionLabels;
import java.util.*;
// record the last position of each character
// iterate the string, update the last position of the current partition
// if the last position equals the current index, add the current partition's length to the result list
public class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] dict = new int[26];
        for(int i = 0; i < S.length(); ++i) {
            dict[S.charAt(i) - 'a'] = i;
        }

        List<Integer> res = new ArrayList<>();
        int before = -1;
        int last = 0;

        for(int i = 0; i < S.length(); ++i) {
            last = Math.max(last, dict[S.charAt(i) - 'a']);
            if(last == i) {
                res.add(last - before);
                before = last;
            }
        }
        return res;
    }
}