package leetcode.Array.l41FirstMissingPositive;

public class Solution {
    // the length of the input array is known
    // the missing number could only be in the range between 1 and n + 1
    // so if we encounter a number that is within le the length of the input
    // we can swap it to index i - 1
    // through out the number that is out of the range
    // then iterate the whole array the find the first index that doesn't equal to
    // its entry + 1
    // that's the first missing positive we want
    public int firstMissingPositive(int[] A) {
        int i = 0;
        while(i < A.length){
            if(A[i] == i+1 || A[i] <= 0 || A[i] > A.length) i++;
            else if(A[A[i]-1] != A[i]) swap(A, i, A[i]-1);
            else i++;
        }
        i = 0;
        while(i < A.length && A[i] == i+1) i++;
        return i+1;
    }

    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}