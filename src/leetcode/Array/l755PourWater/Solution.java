package leetcode.Array.l755PourWater;

public class Solution {
    public int[] pourWater(int[] heights, int V, int K) {
        for(int i = 0; i < V; ++i) {
            if(!(moveLeft(heights, K - 1, heights[K]) || moveRight(heights, K + 1, heights[K]))) {
                heights[K] ++;
            }
        }
        return heights;
    }

    private boolean moveLeft(int[] heights, int index, int height) {
        if(index < 0) return false;
        if(heights[index] < height) {
            if(!moveLeft(heights, index - 1, heights[index])) heights[index] ++;
            return true;
        }
        else if(heights[index] == height && moveLeft(heights, index - 1, height)) {
            return true;
        }
        else return false;
    }

    private boolean moveRight(int[] heights, int index, int height) {
        if(index >= heights.length) return false;
        if(heights[index] < height) {
            if(!moveRight(heights, index + 1, heights[index])) heights[index] ++;
            return true;
        }
        else if(heights[index] == height && moveRight(heights, index + 1, height)) {
            return true;
        }
        else return false;
    }

}
