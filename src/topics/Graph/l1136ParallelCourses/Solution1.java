package topics.Graph.l1136ParallelCourses;
import java.util.*;
public class Solution1 {
    // dfs + memoization
    Map<Integer, List<Integer>> map = new HashMap<>();

    public int minimumSemesters(int n, int[][] rel) {

        for (int[] r: rel) {
            map.putIfAbsent(r[1], new ArrayList<>());
            map.get(r[1]).add(r[0]);
        }

        //dp[i] = 0 - not visited
        //      > 0 - visited
        //      = -1 - cycle
        int[] dp = new int[n+1];

        int min = 0;
        for (int i=1; i<=n; i++) {
            if (dp[i] == 0) {
                int sem = dfs(i, dp);
                if (sem == -1) return -1;
                min = Math.max(sem, min);
            }
        }

        return min;
    }

    private int dfs(int course, int[] dp) {
        if (dp[course] == -1) return -1;
        if (dp[course] > 0) return dp[course];

        dp[course] = -1;
        int min = 1;
        if (map.containsKey(course)) {
            List<Integer> deps = map.get(course);
            for (int d : deps) {
                int sem = dfs(d, dp);
                if (sem == -1) {
                    min = -1;
                    break;
                }
                min = Math.max(min, sem+1);
            }
        }

        dp[course] = min;
        return min;
    }
}