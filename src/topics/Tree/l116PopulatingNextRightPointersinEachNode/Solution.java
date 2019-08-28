package topics.Tree.l116PopulatingNextRightPointersinEachNode;
import datastructure.TreeNodeWithNext.Node;
public class Solution {
    public Node connect(Node root) {
        Node dummy = root;
        if(root == null || root.left == null) return dummy;
        connectNodes(root.left, root.right);
        return dummy;
    }

    public void connectNodes(Node node1, Node node2) {
        node1.next = node2;
        if(node1.left != null) {
            connectNodes(node1.left, node1.right);
            connectNodes(node1.right, node2.left);
            connectNodes(node2.left, node2.right);
        }
    }
}
