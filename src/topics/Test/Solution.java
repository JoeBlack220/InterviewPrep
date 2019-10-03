package topics.Test;
import java.util.*;
import datastructure.*;
class Solution {
    int[] uf;
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        uf = new int[s.length()];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < s.length(); ++i) {
            uf[i] = i;
        }
        char[] arr = s.toCharArray();
        for(List<Integer> list: pairs) {
            union(list.get(0), list.get(1));
        }
        for(int i = 0; i < s.length(); ++i) {
            int g = find(i);
            List<Integer> l = map.computeIfAbsent(g, x -> new ArrayList<>());
            l.add(i);
        }
        for(List<Integer> l: map.values()) {
            char[] toSort = new char[l.size()];
            int curIndex = 0;
            for(int i: l) {
                toSort[curIndex++] = arr[i];
            }
            Arrays.sort(toSort);
            curIndex = 0;
            for(int i: l) {
                arr[i] = toSort[curIndex++];
            }
        }
        return new String(arr);

    }

    private int find(int x) {
        int res = uf[x];
        if(res != x) {
            uf[x] = find(uf[x]);
        }
        return uf[x];
    }

    private void union(int x, int y ) {
        int pX = find(x);
        int pY = find(y);
        if(pX != pY) {
            uf[pX] = pY;
        }
    }
    public static void main(String[] args ) {
        
    }

}
