package topics.DepthFirstSearch.l943FindtheShortestSuperstring;
import java.util.*;
public class Solution {
    private int bestLen = Integer.MAX_VALUE;
    private List<Integer> res = new ArrayList<>();
    public String shortestSuperstring(String[] A) {
        int[][] cost = buildCost(A);
        int len = A.length;
        dfs(cost, 0, 0, len, new ArrayList<>());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < res.size(); ++i) {
            if(i == 0) sb.append(A[res.get(i)]);
            else {
                // System.out.println(cost[res.get(i - 1)][res.get(i)] + 1);
                // System.out.println(A[res.get(i)]);
                sb.append(A[res.get(i)].substring(A[res.get(i)].length() - cost[res.get(i - 1)][res.get(i)]));
            }
        }
        return sb.toString();
    }

    private void dfs(int[][] cost, int curLen, int bitmask, int depth, List<Integer> index) {
        if(curLen >= bestLen) return;
        if(depth == 0) {
            bestLen = curLen;
            res = new ArrayList<>();
            res.addAll(index);
            return;
        }

        for(int i = 0; i < cost.length; ++i) {
            if((bitmask & (1 << i)) > 0) continue;
            int inc = curLen == 0 ? cost[i][i] : cost[index.get(index.size() - 1)][i];
            index.add(i);
            dfs(cost, curLen + inc, bitmask | (1 << i), depth - 1, index);
            index.remove(index.size() - 1);
        }
    }

    private int[][] buildCost(String[] A) {
        int len = A.length;
        int[][] cost = new int[len][len];
        for(int i = 0; i < len; ++i) {
            for(int j = 0; j < len; ++j) {
                cost[i][j] = calcLen(A[i], A[j]);
            }
        }
        return cost;
    }

    private int calcLen(String s1, String s2) {
        for(int i = 1; i < s1.length(); ++i) {
            if(s2.startsWith(s1.substring(i))) return s2.length() - s1.length() + i;
        }
        return s2.length();
    }
}