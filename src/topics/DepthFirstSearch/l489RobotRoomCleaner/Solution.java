package topics.DepthFirstSearch.l489RobotRoomCleaner;
import datastructure.Robot;
import java.util.Set;
import java.util.HashSet;
public class Solution {
    // key point, have a set to check already visited tile
    // There is a corner case that the robot can go backwards
    // so we should check all four directions
    // the directions is tricky, it's relevant to the last direction we take

    public void cleanRoom(Robot robot) {
        Set<String> set = new HashSet<>();
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        moveAndClean(robot, 0, 0, dirs, 0, set);
    }
    private void moveAndClean(Robot robot, int curX, int curY, int[][] dirs, int curDir, Set<String> set) {
        // System.out.println(curX + "," + curY);
        if(set.add(curX + "," + curY)) {
            robot.clean();
            for(int i = 0; i < 4; ++i) {
                int nextDir = (curDir + i) % 4;
                int nextX = curX + dirs[nextDir][0];
                int nextY = curY + dirs[nextDir][1];
                if(robot.move()) moveAndClean(robot, nextX, nextY, dirs, nextDir, set);
                robot.turnRight();
            }
        }
        robot.turnLeft();
        robot.turnLeft();
        robot.move();
        robot.turnLeft();
        robot.turnLeft();
    }
}
