package topics.DynammicProgramming.l673NumberofLongestIncreasingSubsequence;

public class Solution {
    public int findNumberOfLIS(int[] nums) {
        int l = nums.length;
        int[] cnt = new int[l], len = new int[l];
        int max_len = 1;
        int res = 0;
        for(int i = 0; i < l; ++i) {
            cnt[i] = 1;
            len[i] = 1;
            for(int j = 0; j < i; ++j) {
                if(nums[i] > nums[j]) {
                    int len_cur = len[j] + 1;
                    if(len_cur == len[i]) {
                        cnt[i] += cnt[j];
                    }
                    else if(len_cur > len[i]) {
                        cnt[i] = cnt[j];
                        len[i] = len_cur;
                    }
                }
            }
            if(len[i] == max_len) {
                res += cnt[i];
            }
            else if(len[i] > max_len) {
                max_len = len[i];
                res = cnt[i];
            }
        }
        return res;


    }
}