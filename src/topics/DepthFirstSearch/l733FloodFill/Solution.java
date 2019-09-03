package topics.DepthFirstSearch.l733FloodFill;

public class Solution {
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0 ,-1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[0].length == 0) return image;

        int oldColor = image[sr][sc];

        if(oldColor == newColor) return image;

        else dfs(sr, sc, oldColor, newColor, image);
        return image;
    }

    private void dfs(int x, int y, int oldColor, int newColor, int[][] image) {
        if(x < 0 || x >= image.length ||  y < 0 || y >= image[0].length || image[x][y] != oldColor) return;
        image[x][y] = newColor;
        for(int[] dir: dirs) {
            dfs(x + dir[0], y + dir[1], oldColor, newColor, image);
        }
    }
}
