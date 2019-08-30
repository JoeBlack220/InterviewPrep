package topics.DepthFirstSearch.l805SplitArrayWithSameAverage;
import java.util.*;
public class Solution {
    public boolean splitArraySameAverage(int[] A) {
        int sum = 0, n = A.length;
        for (int a : A) {
            sum += a;
        }
        Arrays.sort(A);
        for (int i = 1; i <= n / 2; ++i) {
            if (sum * i % n == 0) {
                int target = sum * i / n;
                if (nSum(A, target, i, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    // find nSum
    boolean nSum(int[] a, int target, int k, int start) {
        int max = a[a.length - 1];
        if (a[start] * k > target || max * k < target) return false;
        for (int i = start; i < a.length - k + 1; i++) {
            if (i > start && a[i] == a[i - 1]) continue;
            if (a[i] + max * (k - 1) < target) continue;
            if (a[i] * k > target) break;
            if (a[i] * k == target) {
                if (a[i + k - 1] == a[i]) {
                    return true;
                }
            }
            if (nSum(a, target - a[i], k - 1, i + 1)) {
                return true;
            }
        }
        return false;
    }
}