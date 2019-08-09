package topics.Design.l353DesignSnakeGame;
import java.util.*;
public class SnakeGame {
    Deque<int[]> queue;
    int m;
    int n;
    int curIndex;
    int[][] food;
    boolean end;
    Set<String> occupied;
    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        m = height;
        n = width;
        occupied = new HashSet<>();
        occupied.add(0 + "," + 0);
        queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        curIndex = 0;
        this.food = food;
        end = false;
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int[] curPos = new int[]{queue.peekLast()[0], queue.peekLast()[1]};
        if(direction.equals("U")) curPos[0] = curPos[0] - 1;
        else if(direction.equals("L")) curPos[1] = curPos[1] - 1;
        else if(direction.equals("R")) curPos[1] = curPos[1] + 1;
        else curPos[0] = curPos[0] + 1;
        String sig = curPos[0] + "," + curPos[1];
        if(end) return -1;
        else if(curPos[0] < 0 || curPos[0] >= m || curPos[1] < 0 || curPos[1] >= n) {
            end = true;
            return -1;
        }
        else if(curIndex < food.length && curPos[0] == food[curIndex][0] && curPos[1] == food[curIndex][1]) {
            queue.offer(curPos);
            occupied.add(sig);
            curIndex ++;
            return curIndex;
        }
        else {
            int[] toRemove = queue.pollFirst();
            String toRemoveSig = toRemove[0] + "," + toRemove[1];
            occupied.remove(toRemoveSig);
            queue.offer(curPos);
            if(occupied.contains(sig)) {
                end = true;
                return -1;
            }
            occupied.add(sig);
            return curIndex;
        }
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
