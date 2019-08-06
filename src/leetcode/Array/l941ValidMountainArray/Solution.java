package leetcode.Array.l941ValidMountainArray;

public class Solution {
    public boolean validMountainArray(int[] A) {
        int mountainIndex = -1;
        for(int i = 0; i < A.length - 1; ++i) {
            if(mountainIndex == -1) {
                if(A[i] > A[i + 1]) mountainIndex = i;
            }
            else {
                if(A[i + 1] >= A[i]) return false;
            }
        }
        return mountainIndex != -1 && mountainIndex != 0;
    }
}
