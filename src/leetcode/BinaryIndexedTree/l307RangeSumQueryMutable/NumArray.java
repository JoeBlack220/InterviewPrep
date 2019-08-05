package leetcode.BinaryIndexedTree.l307RangeSumQueryMutable;

public class NumArray {
    int[] sum;
    int[] nums;
    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        this.nums = nums;
        for(int i = 0; i < nums.length; ++i) {
            update_helper(i + 1, nums[i]);
        }
    }

    public void update_helper(int i, int val) {
        while(i < sum.length) {
            sum[i] += val;
            i += lowbit(i);
        }
    }

    public void update(int i, int val) {
        update_helper(i + 1, val - nums[i]);
        nums[i] = val;
    }

    private int query(int i) {
        int sumt = 0;
        while(i > 0) {
            sumt += sum[i];
            i -= lowbit(i);
        }
        return sumt;
    }

    public int sumRange(int i, int j) {
        return query(j + 1) - query(i);

    }

    private int lowbit(int n) {
        return n & (-n);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
