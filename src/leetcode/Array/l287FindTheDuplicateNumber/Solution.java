package leetcode.Array.l287FindTheDuplicateNumber;
import java.util.*;

public class Solution {
    // space O(1) time O(nlogn)
    public int findDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; ++i) {
            if(nums[i] == nums[i - 1]) return nums[i];
        }
        return -1;
    }

    // same idea as leetcode142 LinkedListCycyleII
    // see every index as a linked list and it's corresponding value is the
    // list node that it connects to
    // using the Floyd's algorithm can help you find the entrance of the cycle
    // which must be the duplicate number (since two listNode point to it)
    // this video is helpful https://www.youtube.com/watch?time_continue=2&v=zbozWoMgKW0
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[slow];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;

    }
}
