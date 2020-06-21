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
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
            if(A==null) return res;
            Stack<TreeNode> ms=new Stack<>();
            ms.push(A);
            Stack<TreeNode> cs=new Stack<>();
            ArrayList<Integer> res1=new ArrayList<>();
             int level=1;
             while(ms.size()>0){
                 TreeNode node=ms.pop();
                 res1.add(node.val);
                 
                 if(level%2==1){
                     if(node.left!=null){
                         TreeNode ln=node.left;
                         cs.push(ln);
                     }
                     if(node.right!=null){
                         TreeNode rn=node.right;
                         cs.push(rn);
                     }
                 }
                 else{
                      if(node.right!=null){
                         TreeNode rn=node.right;
                         cs.push(rn);
                     }
                     if(node.left!=null){
                         TreeNode ln=node.left;
                         cs.push(ln);
                     }
                 }
                 
                 if(ms.size()==0){
                     ms=cs;
                     cs=new Stack<>();
                     level++;
                     res.add(res1);
                     res1=new ArrayList<>();
                 }
             }
            return res;
        }
    }