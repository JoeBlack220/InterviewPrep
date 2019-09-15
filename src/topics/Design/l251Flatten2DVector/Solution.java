package topics.Design.l251Flatten2DVector;

public class Solution {
    int[][] matrix;
    int m;
    int n;
    public Solution(int[][] v) {
        matrix = v;
        m = 0;
        n = 0;
    }

    public int next() {
        hasNext();
        int res = matrix[m][n];
        n++;
        return res;
    }

    public boolean hasNext() {
        if(m >= matrix.length) return false;
        if(n >= matrix[m].length) {
            m++;
            n = 0;
            return hasNext();
        }
        return true;
    }
}