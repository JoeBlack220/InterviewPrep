package topics.Math.l492ConstructtheRectangle;

public class Solution {
    public int[] constructRectangle(int area) {
        int limit = (int)Math.sqrt(area);
        for(int i = limit; i > 0; --i) {
            if(area % i == 0) {
                return new int[]{area / i, i};
            }
        }
        return new int[]{};
    }
}