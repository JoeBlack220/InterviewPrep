package topics.Array.l11ContainerWithMostWater;

public class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int lo = 0, hi = height.length - 1;
        while(lo < hi){
            max = Math.max(max, (hi - lo) * Math.min(height[lo], height[hi]));
            if(height[lo] < height[hi]) lo++;
            else hi--;
        }
        return max;
    }
}