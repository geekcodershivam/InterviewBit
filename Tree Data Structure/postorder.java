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
    public class Pair{
        int state;
        TreeNode node;
        
        Pair(TreeNode node,int state){
            this.node=node;
            this.state=state;
        }
        
    }
    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> res=new ArrayList<>();
        Stack<Pair> st=new Stack<>();
        Pair rtp=new Pair(A,1);
        st.push(rtp);
        while(st.size()>0){
            Pair top=st.peek();
        if(top.state==1){
         top.state++;
         if(top.node.left!=null){
           Pair ln=new Pair(top.node.left,1);
           st.push(ln);  
         }
         
        }
        else if(top.state==2){
         top.state++;
         if(top.node.right!=null)
         {
             Pair rn=new Pair(top.node.right,1);
             st.push(rn);
         }
         
        }
        else if(top.state==3){
            res.add(top.node.val);  
            st.pop();
        }
        }
        return res;
    }
}
