package topics.SegmentTree;

public class SegmentTree {
    class SegmentTreeNode {
        int start, end, sum;
        SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end, int val) {
            this.start = start;
            this.end = end;
            this.sum = val;
        }

        public SegmentTreeNode(int start, int end, int val, SegmentTreeNode l, SegmentTreeNode r) {
            this.start = start;
            this.end = end;
            this.sum = val;
            this.left = l;
            this.right = r;
        }
    }

    public SegmentTreeNode buildTree(int start, int end, int[] vals) {
        if(end == start) return new SegmentTreeNode(start, end, vals[start]);
        int mid = (start + end) / 2;
        SegmentTreeNode left = buildTree(start, mid, vals);
        SegmentTreeNode right = buildTree(mid + 1, end, vals);
        return new SegmentTreeNode(start, end, left.sum + right.sum, left, right);
    }

    public void updateTree(SegmentTreeNode root, int index, int val) {
        if(root.start == root.end && root.start == index) {
            root.sum = val;
            return;
        }
        int mid = (root.start + root.end) / 2;
        if(index <= mid) {
            updateTree(root.left, index, val);
        }
        else {
            updateTree(root.right, index, val);
        }
        root.sum = root.left.sum + root.right.sum;
    }

    public int querySum(SegmentTreeNode root, int i, int j) {
        if(root.start == i && root.end == j) return root.sum;
        int mid = (root.start + root.end) / 2;
        if(j <= mid) {
            return querySum(root.left, i, j);
        }
        else if(i > mid) {
            return querySum(root.right, i, j);
        }
        else {
            return querySum(root.left, i, mid) + querySum(root.right, mid + 1, j);
        }
    }
}
