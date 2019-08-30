package topics.DynammicProgramming.l943FindtheShortestSuperstring;
import java.util.*;
public class Solution {
    public String shortestSuperstring(String[] A) {
        int[][] cost = buildCost(A);
        int len = A.length;
        int last = -1, min = Integer.MAX_VALUE;
        // dp[i][j] i is a bitmask that represent what index has been visited
        // e.g. i = 101 represents that first and third nodes have been visited,
        // but not the second one
        int[][] dp = new int[1 << len][1 << len];
        int[][] parent = new int[1 << len][1 << len];

        for(int i = 0; i < (1 << len); ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
            Arrays.fill(parent[i], -1);
        }

        for(int i = 0; i < len; ++i) dp[1 << i][i] = A[i].length();

        for(int i = 1; i < (1 << len); ++i) {
            for(int j = 0; j < len; ++j) {
                if((i & (1 << j)) <= 0) continue;
                int prev = i - (1 << j);
                if(prev != 0)  {
                    for(int k = 0; k < len; ++k) {
                        if(dp[prev][k] + cost[k][j] < dp[i][j]) {
                            parent[i][j] = k;
                            dp[i][j] = dp[prev][k] + cost[k][j];
                        }
                    }
                }
                if(i == (1 << len) - 1 && dp[i][j] < min) {
                    last = j;
                    min = dp[i][j];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Deque<String> stack = new LinkedList<>();
        int s = (1 << len) - 1;
        while(last != -1) {
            int prev = parent[s][last];
            if(prev == -1) stack.push(A[last]);
            else stack.push(A[last].substring(A[last].length() - cost[prev][last]));
            s = s - (1 << last);
            last = prev;
        }
        while(!stack.isEmpty()) sb.append(stack.pop());
        return sb.toString();
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