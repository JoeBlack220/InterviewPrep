package leetcode.Design.l341FlattenNestedListIterator;
import java.util.*;
import datastructure.NestedInteger;
public class NestedIterator implements Iterator<Integer> {
    List<NestedInteger> root;
    NestedIterator cur;
    int curIndex;
    public NestedIterator(List<NestedInteger> nestedList) {
        root = nestedList;
        curIndex = 0;
    }

    @Override
    public Integer next() {
        if(root.get(curIndex).isInteger()) {
            Integer res = root.get(curIndex).getInteger();
            curIndex ++;
            return res;
        }
        else {
            return cur.next();
        }
    }

    @Override
    public boolean hasNext() {
        if(curIndex >= root.size()) return false;
        else if(root.get(curIndex).isInteger()) {
            cur = null;
            return true;
        }
        else{
            if(cur != null) {
                if(cur.hasNext()) return true;
                else {
                    curIndex ++;
                    cur = null;
                    return hasNext();
                }
            }
            else {
                cur = new NestedIterator(root.get(curIndex).getList());
                return hasNext();
            }
        }
    }
}
