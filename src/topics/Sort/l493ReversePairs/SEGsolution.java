package topics.Sort.l493ReversePairs;
import java.util.*;
public class SEGsolution {

    int[] seg;

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        int n = nums.length;

        int[] copy = nums.clone();
        Arrays.sort(copy);

        //discretization
        int p = 0;
        for (int num : copy) {
            if (p == 0 || num != copy[p - 1]) {
                copy[p++] = num;
            }
        }

        int i = 0;
        while ((1 << i) < p) {
            i++;
        }

        seg = new int[(1 << (i + 1)) - 1];

        int cnt = 0;
        for (i = n - 1; i >= 0; i--) {
            int index1 = binarySearch(1.0 * nums[i] / 2, 0, p, copy);
            int index2 = binarySearch(nums[i], 0, p - 1, copy);
            cnt += query(0, index1 - 1, 0, p - 1, 0);
            update(index2, 0, p - 1, 0);
        }
        return cnt;
    }

    private int query(int tl, int tr, int cl, int cr, int index) {
        if (tl <= cl && tr >= cr) {
            return seg[index];
        }
        if (tr < cl || tl > cr) { return 0; }
        int mid = cl + (cr - cl) / 2;
        return query(tl, tr, cl, mid, 2 * index + 1) +
                query(tl, tr, mid + 1, cr, 2 * index + 2);
    }

    private void update(int i, int l, int r, int index) {
        if (l <= i && r >= i) {
            seg[index]++;
        }
        if (l == r) return;
        int mid = l + (r - l) / 2;
        if (mid < i) {
            update(i, mid + 1, r, 2 * index + 2);
        } else {
            update(i, l, mid, 2 * index + 1);
        }
    }

    //find the first index with num[index] * 2 >= num...
    private int binarySearch(double num, int lo, int hi, int[] nums) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] >= num) {
                hi = mid;
            } else {
                lo = mid + 1;

            }
        }
        return lo;
    }
}
