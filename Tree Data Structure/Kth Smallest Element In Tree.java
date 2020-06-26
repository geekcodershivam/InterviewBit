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
    ArrayList<Integer> res=new ArrayList<>();
    public int kthsmallest(TreeNode A, int B) {
        per(A);
        return res.get(B-1);
    }
    public void per(TreeNode node){
        if(node==null) return;
        if(node.left!=null) per(node.left);
        res.add(node.val);
        if(node.right!=null) per(node.right);
    }
}
