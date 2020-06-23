**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode getMid(ListNode head){
        if(head==null) return null;
        ListNode s=head;
        ListNode f=head;
        while(f!=null && f.next!=null){
            s=s.next;
            f=f.next.next;
        }
        return s;
    }
     public ListNode reverse(ListNode head){
        if(head==null) return null;
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null){
            ListNode forw=curr.next;
            curr.next=prev;
            prev=curr;
            curr=forw;
        }
        return prev;
    }
    public ListNode reorderList(ListNode A) {
        if(A==null) return null;
        ListNode curr=A;
        ListNode mid=getMid(curr);
        ListNode nnode=mid.next;
        mid.next=null;
        nnode=reverse(nnode);
        ListNode curr1=nnode;
        while(curr!=null && curr1!=null){
            ListNode forw1=curr.next;
            ListNode forw2=curr1.next;
            
            curr.next=curr1;
            curr1.next=forw1;
            
            curr=forw1;
            curr1=forw2;
        }
        return A;
    }
}