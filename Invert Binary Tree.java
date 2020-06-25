/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public TreeNode invertTree(TreeNode A) {
        if (A == null) {
        return null;
    }
    TreeNode right = invertTree(A.right);
    TreeNode left = invertTree(A.left);
    A.left = right;
    A.right = left;
    return A;
    }
}
