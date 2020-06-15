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
    public void preorder(TreeNode node,List<Integer> list){
        if (node != null) {
            list.add(node.val);
            preorder(node.left, list);
            preorder(node.right, list);
        }
    }
    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> list = new ArrayList<>();
        preorder(A, list);
        return list;
    }
}
