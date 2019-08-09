package topics.BreadthFirstSearch.l133CloneGraph;
import datastructure.graphNode.Node;
import java.util.*;
public class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Node res = new Node(node.val, new ArrayList<>());
        HashMap<Integer, Node> map = new HashMap<>();
        map.put(res.val, res);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            Node curNodeCopy = map.get(curNode.val);
            for(Node curNeigh : curNode.neighbors){
                Node curNeighCopy;
                if(!map.containsKey(curNeigh.val)){
                    queue.offer(curNeigh);
                    curNeighCopy = new Node(curNeigh.val, new ArrayList<>());
                    map.put(curNeighCopy.val, curNeighCopy);
                }
                else curNeighCopy = map.get(curNeigh.val);
                curNodeCopy.neighbors.add(curNeighCopy);
            }
        }
        return res;
    }
}
