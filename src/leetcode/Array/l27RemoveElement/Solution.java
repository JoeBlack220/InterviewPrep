package leetcode.Array.l27RemoveElement;

public class Solution {
    // we maintain a int to record where should we put the element that is not
    // supposed to be removed currently
    // time O(n) space O(1)
    public int removeElement(int[] A, int elem) {
        int m = 0;
        for(int i = 0; i < A.length; i++){

            if(A[i] != elem){
                A[m] = A[i];
                m++;
            }
        }

        return m;
    }
}
