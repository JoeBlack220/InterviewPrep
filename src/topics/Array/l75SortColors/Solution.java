package topics.Array.l75SortColors;

public class Solution {
    // pointers solution
    public void sortColors(int[] nums) {
        int len = nums.length;
        int i = 0, zeroes = 0, twos = len - 1;
        while(i < len) {
            if(nums[i] == 0 && i > zeroes) exch(nums, i, zeroes++);
            else if(nums[i] == 2 && i < twos) exch(nums, i, twos--);
            else i++;
        }
    }
    private void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// two-pass count sort
class Solution2 {
    public void sortColors(int A[]) {
        int num0 = 0, num1 = 0, num2 = 0;

        for(int i = 0; i < A.length; i++) {
            if (A[i] == 0) ++num0;
            else if (A[i] == 1) ++num1;
            else if (A[i] == 2) ++num2;
        }

        for(int i = 0; i < num0; ++i) A[i] = 0;
        for(int i = 0; i < num1; ++i) A[num0+i] = 1;
        for(int i = 0; i < num2; ++i) A[num0+num1+i] = 2;
    }
}

// two-pass count sort
class Solution3 {
    public void sortColors(int[] nums) {
        int[] buckets = new int[3];
        for(int num : nums) buckets[num]++;
        for(int p = 0, val = 0; val < 3; val++) {
            for(int count = 0; count < buckets[val]; count++) {
                nums[p++] = val;
            }
        }
    }
}