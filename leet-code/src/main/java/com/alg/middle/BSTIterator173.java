package com.alg.middle;

import java.util.Deque;
import java.util.LinkedList;

public class BSTIterator173 {

    private TreeNode cur;
    private Deque<TreeNode> stack;

    public BSTIterator173(TreeNode root) {
        cur = root;
        stack = new LinkedList<>();
    }

    public int next() {
        while (cur!=null){
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int ret = cur.val;
        cur = cur.right;
        return ret;
    }

    public boolean hasNext() {

        return cur!=null ||!stack.isEmpty();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
