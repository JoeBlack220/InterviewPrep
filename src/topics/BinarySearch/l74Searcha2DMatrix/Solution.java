package topics.BinarySearch.l74Searcha2DMatrix;
// just flatten the 2d array to 1d and do binary search
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int lo = 0, hi = m * n - 1;
        int mid = 0;
        while(lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if(matrix[mid / n][mid % n] < target) lo = mid + 1;
            else if(matrix[mid / n][mid % n] > target) hi = mid - 1;
            else return true;
        }
        return false;
    }
}

// template 2 version
class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int lo = 0, hi = m * n;
        int mid = 0;
        while(lo < hi) {
            mid = lo + (hi - lo) / 2;
            if(matrix[mid / n][mid % n] < target) lo = mid + 1;
            else if(matrix[mid / n][mid % n] > target) hi = mid;
            else return true;
        }
        return false;
    }
}