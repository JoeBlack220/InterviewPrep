package topics.Math.l478GenerateRandomPointinaCircle;

public class Solution {
    double radius, x_center, y_center;
    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        // generate the distance to the center
        double len = Math.sqrt(Math.random()) * radius;
        // generate the degree offset
        double deg = Math.random() * 2 * Math.PI;
        double x = x_center + len * Math.cos(deg);
        double y = y_center + len * Math.sin(deg);
        return new double[]{x,y};
    }
}
