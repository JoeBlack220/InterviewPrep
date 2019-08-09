package topics.DynammicProgramming.l363MaxSumOfRectangleNoLargerThanK;
import java.util.*;
public class Solution {
    // similar to leetcode 1074
    // first calculate the prefix sum of each row
    // than fix two columns and iterate every row
    // this way we can get the sum of rectangle[0][i][k][j]
    // then we can minus the previous computed saved in the set which is
    // sum of rectangle[0][i][m][j] (m < k) to compute rectangle[m][i][k][j]
    // this way we compute all possible value that this matrix can produce
    // when we selected a certain triangle
    // then use the set to find the max sum no larger than k
    // time O(m * n ^ 2) space O(n)
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        for(int i = 0; i < m; ++i) {
            for(int j = 1; j < n; ++j) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < n; ++i) {
            for(int j = i; j < n; ++j) {
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int cur = 0;
                for(int l = 0; l < m; ++l) {
                    cur += matrix[l][j] - (i > 0 ? matrix[l][i - 1] : 0);
                    Integer last = set.ceiling(cur - k);
                    if(last != null) res = Math.max(cur - last, res);
                    set.add(cur);
                }
            }
        }
        return res;

    }
}