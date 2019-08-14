package others.fct.newyork;
import java.util.*;
public class Solution {
    public int computeDistance(int[][] people) {
        int len = people.length;
        List<Integer> xCorList = new ArrayList<>(len);
        List<Integer> yCorList = new ArrayList<>(len);
        for(int[] p: people) {
            xCorList.add(p[0]);
            yCorList.add(p[1]);
        }
        return helper(xCorList) + helper(yCorList);
    }

    private int helper(List<Integer> list) {
        Collections.sort(list);
        int res = 0;
        int i = 0, j = list.size() - 1;
        while(i < j) {
            res += list.get(j--) - list.get(i++);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{1, 0}, {1, 1}};
        int[][] test2 = new int[][]{{-4, 3}, {-2, 1}, {1, 0}, {3, 2}};
        Solution sol = new Solution();
        System.out.println(sol.computeDistance(test));
        System.out.println(sol.computeDistance(test2));
    }

}
