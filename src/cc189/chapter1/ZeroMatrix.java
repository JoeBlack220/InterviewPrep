package cc189.chapter1;
import leetcode.Array.l73SetMatrixZeroes.Solution;
public class ZeroMatrix {
    // see leetcode 73
    // space O(1) time O(n)
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] test = new int[][] {{0, 2, 3, 4, 3}, {4, 6, 7, 8, 3}, {1, 2, 5, 6, 0}
        , {7, 4, 2, 1, 6}};
        sol.setZeroes(test);
        for(int[] t: test) {
            for(int c : t) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
