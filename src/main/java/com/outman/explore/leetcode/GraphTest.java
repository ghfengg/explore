package com.outman.explore.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class GraphTest {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode leve1Left = new TreeNode(3);
        TreeNode leve1right = new TreeNode(5);
        root.left = leve1Left;
        root.right = leve1right;

        TreeNode leve2Left = new TreeNode(7);
        TreeNode leve2right = new TreeNode(9);

        leve1Left.left = leve2Left;
        leve1Left.right = leve2right;

        System.out.println(maxDepth(root));

    }

    /**
     * DFS计算最大深度
     *
     * @param root
     * @return
     */
    static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

    static int bfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
