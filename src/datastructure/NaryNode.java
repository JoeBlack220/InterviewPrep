package datastructure;
import java.util.List;
public class NaryNode {
    public int val;
    public List<Node> children;

    public NaryNode() {}

    public NaryNode(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}