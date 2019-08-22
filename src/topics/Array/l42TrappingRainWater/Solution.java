package topics.Array.l42TrappingRainWater;

public class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] water = new int[len];
        int last = -1;
        for(int i = 0; i < len; ++i) {
            last = Math.max(height[i], last);
            water[i] = last;
        }
        last = -1;
        int res = 0;
        for(int i = len - 1; i >= 0; --i) {
            last = Math.max(height[i], last);
            water[i] = Math.min(water[i], last);
            res += water[i] - height[i];
        }
        return res;

    }
}