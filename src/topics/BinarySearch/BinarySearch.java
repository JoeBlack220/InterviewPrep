package topics.BinarySearch;

public class BinarySearch {
    // template 1

//    Most basic and elementary form of Binary Search
//    Search Condition can be determined without comparing
//    to the element's neighbors (or use specific elements around it)
//    No post-processing required because at each step,
//    you are checking to see if the element has been found. If you reach the end
//    , then you know the element is not found
//    Initial Condition: left = 0, right = length-1
//    Termination: left > right
//    Searching Left: right = mid-1
//    Searching Right: left = mid+1
    int binarySearch(int[] nums, int target){
        if(nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;
        while(left <= right){
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){ return mid; }
            else if(nums[mid] < target) { left = mid + 1; }
            else { right = mid - 1; }
        }

        // End Condition: left > right
        return -1;
    }
    // template2

//    An advanced way to implement Binary Search.
//    Search Condition needs to access element's immediate right neighbor
//    Use element's right neighbor to determine if condition
//    is met and decide whether to go left or right
//    Guarantees Search Space is at least 2 in size at each step
//    Post-processing required. Loop/Recursion ends when you have 1 element left.
//    Need to assess if the remaining element meets the condition.
//    Initial Condition: left = 0, right = length
//    Termination: left == right
//    Searching Left: right = mid
//    Searching Right: left = mid+1
    int binarySearch2(int[] nums, int target){
        if(nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length;
        while(left < right){
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){ return mid; }
            else if(nums[mid] < target) { left = mid + 1; }
            else { right = mid; }
        }

        // Post-processing:
        // End Condition: left == right
        if(left != nums.length && nums[left] == target) return left;
        return -1;
    }

    // template3
//    An alternative way to implement Binary Search
//    Search Condition needs to access element's immediate left and right neighbors
//    Use element's neighbors to determine if condition is met and
//    decide whether to go left or right
//    Guarantees Search Space is at least 3 in size at each step
//    Post-processing required. Loop/Recursion ends when you have 2 elements left.
//    Need to assess if the remaining elements meet the condition.
//    Initial Condition: left = 0, right = length-1
//    Termination: left + 1 == right
//    Searching Left: right = mid
//    Searching Right: left = mid
    int binarySearch3(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;
        while (left + 1 < right){
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        // Post-processing:
        // End Condition: left + 1 == right
        if(nums[left] == target) return left;
        if(nums[right] == target) return right;
        return -1;
    }
}
