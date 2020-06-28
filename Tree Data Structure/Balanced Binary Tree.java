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
     public int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
     public boolean Balanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(Math.abs(height(root.left) - height(root.right)) == 1 || Math.abs(height(root.left) - height(root.right)) == 0) {
            return true && Balanced(root.left) && Balanced(root.right);
        }
        return false;
        
    }
    public int isBalanced(TreeNode A) {
      return   Balanced(A)==true ? 1: 0;
    }
}
