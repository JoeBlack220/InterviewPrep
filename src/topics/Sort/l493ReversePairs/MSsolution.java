package topics.Sort.l493ReversePairs;

public class MSsolution {
    public int reversePairs(int[] nums) {
        // int[] test = new int[]{1, 2, 3, 4, 5, 6, 7};
        // System.out.println(binarySearch(test, 0, 6, 3));
        int res = sort(nums, new long[nums.length], 0, nums.length - 1);
        return res;
    }

    private int sort(int[] nums, long[] aux, int lo, int hi) {
        if(hi <= lo) return 0;
        int res = 0;
        int mid = lo + (hi - lo) / 2;
        res += sort(nums, aux, lo, mid);
        res += sort(nums, aux, mid + 1, hi);
        res += merge(nums, aux, lo, mid, hi);
        return res;
    }

    private int merge(int[] nums, long[] aux, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for(int k = lo; k <= hi; ++k) {
            aux[k] = nums[k];
        }
        int count = 0;
        for(int k = lo; k <= hi; ++k) {
            if(i > mid) nums[k] = (int)aux[j++];
            else if(j > hi) {
                int index = binarySearch(aux, mid + 1, hi, aux[i]);
                int inc = (index - mid - 1);
                count += inc;
                nums[k] = (int)aux[i++];
            }
            else if(aux[i] >= aux[j]) {
                nums[k] = (int)aux[j++];
            }
            else {
                int index = binarySearch(aux, mid + 1, hi, aux[i]);
                int inc = (index - mid - 1);
                count += inc;
                nums[k] = (int)aux[i++];
            }
        }
        return count;
    }

    private int binarySearch(long[] nums, int lo, int hi, long tar) {
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] * 2 < tar) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        return lo;
    }
}
