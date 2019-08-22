package topics.BinarySearch.l668KthSmallestNumberinMultiplicationTable;

public class Solution {
    public int findKthNumber(int m, int n, int k) {
        int l = 1, r = m * n;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(lessThanX(mid, m, n) >= k) r = mid - 1;
            else l = mid + 1;
        }
        return l;
    }

    private int lessThanX(int x, int m, int n) {
        int res = 0;
        for(int i = 1; i <= m; ++i) {
            res += Math.min(x / i, n);
        }
        return res;
    }
}
