package topics.Test;
import java.util.*;
import datastructure.*;

class Solution {
    int[] uf;
    int[] size;
    public String removeDuplicates(String s, int k) {
        uf = new int[s.length()];
        size = new int[s.length()];
        TreeSet<Integer> set = new TreeSet<>();
        char last = s.charAt(0);
        set.add(0);
        for(int i = 0; i < s.length(); ++i) {
            uf[i] = i;
            size[i] = 1;
            if(s.charAt(i) != last) {
                set.add(i);
                last = s.charAt(i);
            }
        }

        last = s.charAt(0);
        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if(c == last) {
                if(i != 0) {
                    helper(s, i - 1, i, set, k);
                }
            }
            else {
                last = c;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); ++i) {
            if(size[find(i)] < k) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();

    }

    private void helper(String s, Integer start, Integer end, TreeSet<Integer> set, int k) {
        if(start == null || end == null || start < 0 || end >= s.length() || s.charAt(start) != s.charAt(end)) return;
        union(start, end);
        System.out.println(start + "," + end);
        System.out.println("size" + size[find(start)]);
        while(start != null && size[find(start)] >= k) {
            start = set.lower(start);
        }
        while(end != null && size[find(end)] >= k) {
            end = set.higher(end);
        }
        System.out.println("new" + start + "," + end);
        helper(s, start, end, set, k);

    }

    private int find(int x){
        int p = uf[x];
        if(uf[x] != x) {
            uf[x] = find(uf[x]);
        }
        return uf[x];
    }

    private void union(int x, int y) {
        int x_p = find(x), y_p = find(y);
        if(x_p != y_p) {
            uf[x_p] = y_p;
            size[y_p] += size[x_p];
        }
    }
    public static void main(String[] args) {
        String test1 = "pbbcggttciiippooaais";
        String test2 = "acde";
        Solution sol = new Solution();
        System.out.println(sol.removeDuplicates(test1, 2));
    }
}

