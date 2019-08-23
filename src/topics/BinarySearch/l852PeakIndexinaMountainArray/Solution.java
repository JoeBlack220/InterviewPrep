package topics.BinarySearch.l852PeakIndexinaMountainArray;

public class Solution {
    // find the first index that A[mid] >= A[mid + 1];
    public int peakIndexInMountainArray(int[] A) {
        int lo = 0, hi = A.length - 1;
        while(lo <= hi){
            int mi = lo + (hi - lo) / 2;
            if(A[mi] < A[mi + 1])
                lo = mi + 1;
            else
                hi = mi - 1;
        }
        return lo;
    }
}