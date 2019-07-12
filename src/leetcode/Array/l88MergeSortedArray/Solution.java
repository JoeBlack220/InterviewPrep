package leetcode.Array.l88MergeSortedArray;

public class Solution {
    // merge the elements from the back
    // time O(m + n) space O(1)
    // beats 100%    99.95%
    public void merge(int A[], int m, int B[], int n) {

        for(int i = m + n - 1; i>=0; i--)
        {
            if( m>0 && n>0)
            {
                if(B[n-1] > A[m-1])
                {
                    A[i] = B[n-1];
                    n--;
                }
                else
                {
                    A[i] = A[m-1];
                    m--;
                }
            }
            else if(m>0)
            {
                A[i] = A[m-1];
                m--;
            }
            else if(n>0)
            {
                A[i] = B[n-1];
                n--;
            }
        }

    }
}
