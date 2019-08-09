package topics.Greedy.l621TaskScheduler;
// similar to leetcode 358
// but we can have gap here
public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        int[] valid = new int[26];
        for(char c: tasks) {
            count[c - 'A'] ++;
        }
        int curIndex = 0;
        int num = 0;
        while(num < tasks.length) {
            int nextTask = nextValid(count, valid, curIndex);
            if(nextTask != -1) {
                count[nextTask] --;
                valid[nextTask] = valid[nextTask] + n + 1;
                num++;
            }
            curIndex++;
        }
        return curIndex;
    }

    private int nextValid(int[] count, int[] valid, int curIndex) {
        int max = Integer.MIN_VALUE;
        int res = -1;
        for(int i = 0; i < count.length; ++i) {
            if(count[i] > 0 && valid[i] <= curIndex && count[i] > max) {
                max = count[i];
                res = i;
            }
        }
        return res;
    }
}
