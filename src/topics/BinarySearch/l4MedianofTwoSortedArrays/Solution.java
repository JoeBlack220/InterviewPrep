package topics.BinarySearch.l4MedianofTwoSortedArrays;

public class Solution {
    // space O(1) time O(log(min(m, n)))
    // suppose nums1 has length len1, nums2 has length len2, total length len1 + len2
    // k = (len1 + len2 + 1) / 2
    // if len1 + len2 is odd, the median is the kth number
    // if len1 + len2 is even, the median is the average of kth and (k + 1)th number
    // so we should find out how many elements of nums1 and how many elements of nums2 belongs to the first k number
    // we can use binary search to achieve that
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        if(len1 > len2) return findMedianSortedArrays(nums2, nums1);
        int k = (len1 + len2 + 1) / 2, l = 0, r = len1 - 1;
        while(l <= r) {
            int nums1Num = l + (r - l) / 2;
            int nums2Num = k - nums1Num;
            // we should find the biggest nums1Num that nums1[nums1Num] >= nums2[nums2Num - 1]
            if(nums1[nums1Num] < nums2[nums2Num - 1]) {
                l = nums1Num + 1;
            }
            else {
                r = nums1Num - 1;
            }
        }
        // m1 + m2 = k
        // since array index is started at 0
        // so the kth number is actually Math.max(m1 - 1 th number in nums1, m2 - 1 the number in nums2);
        // k + 1 th number is Math.min(m1th number in nums1, m2the number in nums2);
        int m1 = l, m2 = k - l;
        int c1 = Math.max(m1 <= 0 ? Integer.MIN_VALUE: nums1[m1 - 1],
                m2 <= 0 ? Integer.MIN_VALUE: nums2[m2 - 1]);

        if((len1 + len2) % 2 != 0) return c1;

        int c2 = Math.min(m1 >= len1 ? Integer.MAX_VALUE: nums1[m1],
                m2 >= len2 ? Integer.MAX_VALUE: nums2[m2]);

        return (double)(c1 + c2) / 2;
    }
}