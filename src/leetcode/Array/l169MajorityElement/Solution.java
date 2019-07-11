package leetcode.Array.l169MajorityElement;

public class Solution {
    // Boyer-Moore Majority Vote Algorithm
    // http://www.cs.utexas.edu/~moore/best-ideas/mjrty/
    public int majorityElement(int[] nums) {
        int count = 0, candidate = nums[0];
        for(int num: nums) {
            if(num == candidate) count++;
            else if(count == 0){
                candidate = num;
                count++;
            }
            else count--;
        }
        return candidate;
    }
}
