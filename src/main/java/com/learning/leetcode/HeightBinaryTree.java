package com.learning.leetcode;
/**
 * Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class HeightBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		System.out.println(maxDepth(root));

	}

	public static int maxDepth(TreeNode root) {
		if (root == null)
			return 0;

		int leftDepth = maxDepth(root.left);
		int rightDepth = maxDepth(root.right);

		int bigger = Math.max(leftDepth, rightDepth);

		return bigger + 1;
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
