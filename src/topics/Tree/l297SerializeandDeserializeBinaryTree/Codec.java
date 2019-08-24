package topics.Tree.l297SerializeandDeserializeBinaryTree;
import datastructure.TreeNode;
public class Codec {
    final String split = ",";
    final String end = "X";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(sb, root);
        return sb.toString();
    }

    private void buildString(StringBuilder sb, TreeNode root) {
        if(root == null) {
            sb.append(end);
            sb.append(split);
        }
        else {
            sb.append(root.val);
            sb.append(split);
            buildString(sb, root.left);
            buildString(sb, root.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(split);
        int[] pointer = new int[]{0};
        return buildTree(nodes, pointer);
    }

    private TreeNode buildTree(String[] nodes, int[] pointer) {
        if(nodes[pointer[0]].equals(end)) {
            pointer[0] ++;
            return null;
        }
        TreeNode res = new TreeNode(Integer.parseInt(nodes[pointer[0]++]));
        res.left = buildTree(nodes, pointer);
        res.right = buildTree(nodes, pointer);
        return res;
    }
}