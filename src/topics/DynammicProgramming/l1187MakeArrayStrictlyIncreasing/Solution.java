package topics.DynammicProgramming.l1187MakeArrayStrictlyIncreasing;
import java.util.*;
public class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int num: arr2) set.add(num);
        int[] b = new int[set.size()];

        int curIndex = 0;

        for(int num: set) {
            b[curIndex++] = num;
        }

        int[] keep = new int[arr1.length];
        Arrays.fill(keep, Integer.MAX_VALUE / 2);
        int[][] swap = new int[arr1.length][b.length];
        for(int[] s: swap) Arrays.fill(s, Integer.MAX_VALUE / 2);
        keep[0] = 0;

        for(int i = 0; i < b.length; ++i) {
            swap[0][i] = 1;
        }

        for(int i = 1; i < arr1.length; ++i) {
            if(arr1[i] > arr1[i - 1]) keep[i] = Math.min(keep[i - 1], keep[i]);
            for(int j = 0; j < b.length; ++j) {
                if(arr1[i] > b[j]) keep[i] = Math.min(keep[i], swap[i - 1][j]);
                if(arr1[i - 1] < b[j]) swap[i][j] = Math.min(keep[i - 1] + 1, swap[i][j]);
                if(j != 0) swap[i][j] = Math.min(swap[i - 1][j - 1] + 1, swap[i][j]);
            }
        }

        int res = keep[arr1.length - 1];
        for(int i = 0; i < b.length; ++i) {
            res = Math.min(swap[arr1.length - 1][i], res);
        }

        return res >= Integer.MAX_VALUE / 2 ? -1 : res;
    }
}