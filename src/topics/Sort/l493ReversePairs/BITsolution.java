package topics.Sort.l493ReversePairs;
import java.util.*;
public class BITsolution {

    int[] BIT;

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        int n = nums.length;

        int[] copy = nums.clone();
        Arrays.sort(copy);

        //discretization
        //so different num will be mapped to 0 - (p - 1)...in order...
        int p = 0;
        for (int num : copy) {
            if (p == 0 || num != copy[p - 1]) {
                copy[p++] = num;
            }
        }

        BIT = new int[p + 1];
        int cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            int index1 = binarySearch(1.0 * nums[i] / 2, 0, p, copy);
            //if all number are negative... the index could be p...
            int index2 = binarySearch(nums[i], 0, p - 1, copy);
            cnt += query(index1);
            update(index2 + 1); //need to add 1...
        }
        return cnt;
    }

    private int query(int i) {
        int sum = 0;
        while (i > 0) {
            sum += BIT[i];
            i -= (i & -i);
            //System.out.println("loop1");
        }
        return sum;
    }

    private void update(int i) {
        int n = BIT.length;
        while (i < n) {
            BIT[i] += 1;
            i += (i & -i);
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
            //System.out.println("loop3");
        }
        return lo;
    }
}
