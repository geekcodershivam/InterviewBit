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
        Pair(int state, TreeNode node){
            this.state=state;
            this.node=node;
        }
    }
    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> res=new ArrayList<>();
        Stack<Pair> st=new Stack<>();
        Pair rtp=new Pair(1,A);
        st.push(rtp);
        while(st.size()>0){
            Pair top=st.peek();
            if(top.state==1){
                top.state++;
                if(top.node.left!=null){
                    Pair ln=new Pair(1,top.node.left);
                    st.push(ln);
                }
            }
            else if(top.state==2){
                top.state++;
                 res.add(top.node.val);
                if(top.node.right!=null){
                    Pair rn=new Pair(1,top.node.right);
                    st.push(rn);
                   
                } 
            }
            else{
                st.pop();
            }
        }
        return res;
    }
}
