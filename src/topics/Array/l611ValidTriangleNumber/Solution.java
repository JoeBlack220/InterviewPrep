package topics.Array.l611ValidTriangleNumber;
import java.util.Arrays;
public class Solution {
    // see 3 number smaller for some reference and difference
    // space O(1) time O(nlogn) beats 99.7%
    public static int triangleNumber(int[] A) {
        Arrays.sort(A);
        int count = 0, n = A.length;
        for (int i = n - 1; i >= 2; i--) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (A[l] + A[r] > A[i]) {
                    count += r - l;
                    r --;
                }
                else l ++;
            }
        }
        return count;
    }
}