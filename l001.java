import java.util.*;
import java.lang.*;
import java.io.*;

public class l001{
    public static class Node{
        Node left=null;
        Node right=null;
        int data=0;
        Node(int data){
            this.data=data;
        }
    }

    static int idx=0;
    public static Node contructTree(int[] arr){
        if(idx==arr.length || arr[idx]==-1){
            idx++;
           return null;
        }
        Node node=new Node(arr[idx++]);
        node.left=contructTree(arr);
        node.right=contructTree(arr);
        return node;
    }
    public static void Display(Node node){
        if(node==null) return;
        String str="";
        str+=((node.left!=null)?node.left.data:".");
        str+="<-"+node.data+"->";
        str+=((node.right!=null)?node.right.data:".");
        System.out.println(str);
        Display(node.left);
        Display(node.right);
    }

    public static int size(Node node){
        if(node==null) return 0;
        return size(node.left)+size(node.right)+1;
    }
    public static int height(Node node){
        if(node==null) return -1;
        return Math.max(height(node.left),height(node.right))+1;
    }
    public static int maximum(Node node){
        if(node==null) return(int)-1e8;
        return Math.max(node.data, Math.max(maximum(node.left),maximum(node.right)));
    }
    public static int minimum(Node node){
        if(node==null) return(int)1e8;
        return Math.min(node.data, Math.min(minimum(node.left),minimum(node.right)));
    }
    public static boolean find(Node node,int val){
        if(node==null) return false;
        if(node.data==val) return true;
        boolean res=false;
        return res=find(node.left,val)|| find(node.right,val);
    }

    //Traversal===================================================================
    public static void preorder(Node node){
        if(node==null) return;
        System.out.print(node.data+" ");
        if(node.left!=null) preorder(node.left);
        if(node.right!=null) preorder(node.right);
    }

    public static void Inorder(Node node){
        if(node==null) return;
        if(node.left!=null) Inorder(node.left);
        System.out.print(node.data+" ");
        if(node.right!=null) Inorder(node.right);
    }
     public static void postorder(Node node){
         if(node==null) return;
         if(node.left!=null) postorder(node.left);
         if(node.right!=null) postorder(node.right);
         System.out.print(node.data+" ");
     }
     //==================================================================================================

     public static boolean nodeToRoot(Node node,int val, ArrayList<Node> res){
         if(node==null) return false;
         if(node.data==val){
            res.add(node);
             return true;
         }
         boolean re=nodeToRoot(node.left,val,res) || nodeToRoot(node.right,val,res);
         if(re){
             res.add(node);
             return re;
         }

         return re;
     }

     public static void NodeTORootPath(Node node,int val){
         ArrayList<Node> res=new ArrayList<>();
         nodeToRoot(node,val,res);
         for(Node i: res){
             System.out.print(i.data+" ");
         }
     }
     public static void RootToLeaf_(Node node,ArrayList<Node> res,ArrayList<ArrayList<Node>> path){
        if(node==null) return;
        if(node.left==null && node.right==null){
            res.add(node);
            path.add(res);
            return;
        }
        res.add(node);
        RootToLeaf_(node.left,res,path);
        res.remove(res.size()-1);

        res.add(node);
        RootToLeaf_(node.right,res,path);
        res.remove(res.size()-1);
     }
     public static void RootToLeaf(Node node){
        ArrayList<ArrayList<Node>> res=new ArrayList<>();
        ArrayList<Node> path=new ArrayList<>();
        RootToLeaf_(node, path,res);
        for(int i=0; i<res.size(); i++){
            for(Node j: res.get(i)){
                System.out.print(j.data+" ");
            }
            System.out.println();
        }
    }

    public static void  kthtimedown(Node node, int k){
        if(node==null) return;
        if(k==0){
            System.out.print(node.data+" ");
            return;
        }
        kthtimedown(node.left,k-1);
        kthtimedown(node.right,k-1);
    }

    //=========================================================================================
    public static void levelorder( Node root){
        BFS1(root);
        System.out.println();
        BFS2(root);
        System.out.println();
        BFS3(root);
        System.out.println();
        BFS4(root);
    }

    public static class LPair{
        Node node;
        int level;
        LPair(Node node , int level){
            this.node=node;
            this.level=level;
        }
    }
    public static void BFS4(Node node){
        LinkedList<LPair> ml=new LinkedList<>();
        ml.addFirst(new LPair(node,1));
        int level=1;
        while(ml.size()>0){
            LPair p=ml.remove();
            
            if(p.level!=level){
                System.out.println();
                level=p.level;

            }
            System.out.print(p.node.data+" ");
            if(p.node.left!=null){
                
                ml.addLast(new LPair(p.node.left,level+1));
            }
            if(p.node.right!=null){
                ml.addLast(new LPair(p.node.right,level+1));
            }

        }
    }

    public static void BFS3(Node node){
        LinkedList<Node> ml=new LinkedList<>();
        ml.addFirst(node);
        while(ml.size()>0){
            int size=ml.size();
            while(size-->0){
                node =ml.removeFirst();
                System.out.print(node.data+" ");
                if(node.left!=null){
                    ml.addLast(node.left);
                }
                if(node.right!=null){
                    ml.addLast(node.right);
                }
            }

            System.out.println();
        }
        
    }
    public static void BFS2(Node node){
        LinkedList<Node> ml=new LinkedList<>();
        ml.addLast(node);
        ml.addLast(null);
        while(ml.size()!=1){
                node = ml.removeFirst();
                    System.out.print(node.data+" ");
                    if(node.left!=null){
                        ml.addLast(node.left);
                    }
                    if(node.right!=null){
                        ml.addLast(node.right);
                    }
                    
                if(ml.getFirst()==null){
                    ml.removeFirst();
                    System.out.println();
                    ml.addLast(null);
                    
                }
        }
    }
    public static void BFS1(Node node){
       LinkedList<Node> ml=new LinkedList<>();
       ml.addFirst(node);
       LinkedList<Node> cl=new LinkedList<>();
       while(ml.size()>0){
           int size=ml.size();
           while(size-->0){
               node =ml.removeFirst();
               System.out.print(node.data+" ");
               if(node.left!=null){
                   cl.addLast(node.left);
               }
               if(node.right!=null){
                cl.addLast(node.right);
            }
            if(size==0){
                System.out.println();
                ml=cl;
                cl=new LinkedList<>();
            }
           }
       }
    }
    //===================================================================================
    public static void ViewSet(Node node){
        leftView(node);
        System.out.println();
        rightView(node);
        System.out.println();
    }


    public static void rightView(Node node){
        LinkedList<Node> ml=new LinkedList<>();
        ml.addFirst(node);
        Node prev=null;
        while(ml.size()>0){
            int size=ml.size();
            
            while(size-->0){
             node =ml.removeFirst();
             prev=node;
             if(node.left!=null) ml.addLast(node.left);
             if(node.right!=null) ml.addLast(node.right);
            }
            System.out.println(prev.data);
        }
        
    }

    public static void leftView(Node node){
        LinkedList<Node> ml=new LinkedList<>();
        ml.addFirst(node);
        while(ml.size()>0){
            int size=ml.size();
            System.out.println(ml.getFirst().data);
            while(size-->0){
                node =ml.removeFirst();
                if(node.left!=null){
                    ml.addLast(node.left);
                }
                if(node.right!=null){
                    ml.addLast(node.right);
                } 
            }
        }
    }
    //================================================================================================
    public static class Vpair{
        Node node=null;
        int level=0;
        Vpair(Node node, int level){
            this.node=node;
            this.level=level;
        }
    }
    public static void Verticalorder(Node node){
        int minMax[]=new int[2];
        width(node,0,minMax);
        ArrayList<Integer>[] ans=new ArrayList[minMax[1]-minMax[0]+1];
        for(int i=0; i<ans.length; i++) ans[i]=new ArrayList<>();
        LinkedList<Vpair> ml=new LinkedList<>();
        ml.addFirst(new Vpair(node, Math.abs(minMax[0])));
        while(ml.size()>0){
            int size=ml.size();
            while(size-->0){
                Vpair p=ml.removeFirst();
                Node nnode=p.node;
                int level=p.level;
                ans[level].add(nnode.data);
                if(nnode.left!=null) ml.addLast(new Vpair(nnode.left,level-1));
                if(nnode.right!=null) ml.addLast(new Vpair(nnode.right,level+1));
            }
        }
        for(int i=0; i<ans.length; i++){
            for(int a:ans[i]){
                System.out.print(a+" ");
            }
            System.out.println();
        }        
    }


    public static void width(Node node, int level, int[]minMax){
        if(node==null) return;
        minMax[0]=Math.min(minMax[0],level);
        minMax[1]=Math.max(minMax[1],level);
        width(node.left,level-1,minMax);
        width(node.right,level+1,minMax);
    }

    public static void main(String[] args) {
    int[] arr={10,20,40,-1,-1,50,80,-1,-1,90,-1,-1,30,60,-1,100,-1,-1,70,110,-1,-1,120,-1,-1};
    Node root=contructTree(arr);
    // Display(root);
    // System.out.println("size"+size(root));
    // System.out.println("height"+height(root));
    // System.out.println("maximum"+maximum(root));
    // System.out.println("minimum"+minimum(root));
    // System.out.println("IsFind"+find(root,1000));
    // preorder(root);
    // System.out.println();
    // Inorder(root);
    // System.out.println();
    // postorder(root);
    // System.out.println();
    // NodeTORootPath(root,100);
    // System.out.println();
    // RootToLeaf(root);
    // System.out.println();
    // kthtimedown(root,2);
    // System.out.println();
    // levelorder(root);
    // System.out.println();
    ViewSet(root);
    System.out.println();
    Verticalorder(root);
    }

}