package leetcode.Array.l835ImageOverlap;
import java.util.*;
public class Solution {
    // brute force
    // we can move A len - 1 unit to all four directions
    // simulate those moves and count the overlap image numbers
    // return the largest overlap numbers among those moves
    // time O(n^4) spaceO(n^2)
    // time beats 77.55% space beats 100%
    // but waste time when we are dealing with sparse matrices
    public int largestOverlap(int[][] A, int[][] B) {
        int len = A.length;
        int[][] dp = new int[len * 2 - 1][len * 2 - 1];
        for(int i = 0; i < len; ++i) {
            for(int j = 0; j < len; ++j) {
                if(A[i][j] == 0) continue;
                else {
                    for(int m = - len + 1; m <= len - 1; ++m) {
                        for(int n = - len + 1; n <= len - 1; ++n) {
                            int x = i + m;
                            int y = j + n;
                            if(x < 0 || x >= len || y < 0 || y >= len) continue;
                            else if(B[x][y] == 1) dp[m + len - 1][n + len - 1] ++;
                        }
                    }
                }
            }
        }
        int res = 0;
        for(int[] row: dp) {
            for(int num: row) res = Math.max(res, num);
        }
        return res;
    }


    // record the coordinates that are 1 int the matrix
    // use a hash map to record the number of overlap pixels after same move
    // time O(n^2) space O(n^2)
    // time beats 22.04% space beats 63.82%
    public int largestOverlap1(int[][] A, int[][] B) {
        int rows = A.length, cols = A[0].length;
        List<int[]> la = new ArrayList<>(), lb = new ArrayList<>(); // two lists to save pixel coordinates
        for (int r = 0; r<rows; r++)
            for (int c = 0; c<cols; c++){
                if (A[r][c] == 1) la.add(new int[]{r,c}); // save the pixel coordinates
                if (B[r][c] == 1) lb.add(new int[]{r,c});
            }
        Map<String, Integer> map = new HashMap<>(); // map to map the vector (from a pixel in A to a pixel in B) to its count
        for (int[] pa : la)
            for (int[] pb : lb) {
                String s = (pa[0] - pb[0]) + " " + (pa[1]-pb[1]); // get the vector from a pixel in A to a pixel in B
                map.put(s, map.getOrDefault(s, 0) + 1); // count the number of same vectors
            }
        int max = 0;
        for (int count : map.values())
            max = Math.max(max, count);
        return max;
    }

    // same as the last approach, but use one number to represent to coordinates
    // save more space
    // time beats 55.92% space beats 67.84%
    public int largestOverlap2(int[][] A, int[][] B) {
        int N = A.length;
        List<Integer> LA = new ArrayList<>();
        List<Integer> LB = new ArrayList<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < N * N; ++i) if (A[i / N][i % N] == 1) LA.add(i / N * 100 + i % N);
        for (int i = 0; i < N * N; ++i) if (B[i / N][i % N] == 1) LB.add(i / N * 100 + i % N);
        for (int i : LA) for (int j : LB)
            count.put(i - j, count.getOrDefault(i - j, 0) + 1);
        int res = 0;
        for (int i : count.values()) res = Math.max(res, i);
        return res;
    }
    // same as the first approach, but doesn't use a matrix to record the count
    // reorganize the loop
    // time O(n^4) space O(1)
    public int largestOverlap3(int[][] A, int[][] B) {
        int n=A.length;
        int res=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                res=Math.max(res,Math.max(helper(A,B,i,j),helper(B,A,i,j)));
            }
        }
        return res;

    }
    public int helper(int[][] A,int[][] B,int rowoffset,int coloffset){
        int n=A.length;
        int sum=0;
        for(int i=rowoffset;i<n;i++){
            for(int j=coloffset;j<n;j++){
                sum+=A[i][j]*B[i-rowoffset][j-coloffset];
            }
        }
        return sum;
    }
}
