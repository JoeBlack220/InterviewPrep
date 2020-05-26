package topics.Tree.l558LogicalOrofTwoBinaryGridsRepresentedasQuad;
import datastructure.QuadNode.*;
public class Solution {
    public Node intersect(Node quadTree1, Node quadTree2) {
        if(quadTree1 == null || quadTree2 == null) return null;
        return recursive(quadTree1, quadTree2, quadTree1.val, quadTree2.val);
    }
    
    private Node recursive(Node quadTree1, Node quadTree2, boolean val1, boolean val2) {
        if((quadTree1 == null || quadTree1.isLeaf) && (quadTree2 == null || quadTree2.isLeaf)) {
            boolean val = (quadTree1 == null ? val1 : quadTree1.val) || (quadTree2 == null ? val2 : quadTree2.val);
            // System.out.println(val + " ");
            return new Node(val, true, null, null, null, null);
        }
        
        Node topLeft1 = null, topRight1 = null, bottomLeft1 = null, bottomRight1 = null;
        Node topLeft2 = null, topRight2 = null, bottomLeft2 = null, bottomRight2 = null;
        boolean nVal1 = val1, nVal2 = val2;
        
        if(quadTree1 != null) {
            topLeft1 = quadTree1.topLeft;
            topRight1 = quadTree1.topRight;
            bottomRight1 = quadTree1.bottomRight;
            bottomLeft1 = quadTree1.bottomLeft;
            nVal1 = quadTree1.val;
        }
        
        if(quadTree2 != null) {
            topLeft2 = quadTree2.topLeft;
            topRight2 = quadTree2.topRight;
            bottomRight2 = quadTree2.bottomRight;
            bottomLeft2 = quadTree2.bottomLeft;
            nVal2 = quadTree2.val;
        }
        
        Node topLeftN = recursive(topLeft1, topLeft2, nVal1, nVal2);
        Node topRightN = recursive(topRight1, topRight2, nVal1, nVal2);
        Node bottomLeftN = recursive(bottomLeft1, bottomLeft2, nVal1, nVal2);
        Node bottomRightN = recursive(bottomRight1, bottomRight2, nVal1, nVal2);
        if(topLeftN.isLeaf == true && topRightN.isLeaf == true && bottomLeftN.isLeaf == true && bottomRightN.isLeaf == true) {
            if(topLeftN.val == topRightN.val && bottomLeftN.val == bottomRightN.val && bottomLeftN.val == topRightN.val) {
                return new Node(topLeftN.val, true, null, null, null, null);
            }
        }
        
        return new Node(true, false, topLeftN, topRightN, bottomLeftN, bottomRightN);
        
    }
    
}