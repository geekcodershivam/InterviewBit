/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    
    private ListNode Merge(ListNode l1, ListNode l2) {
           if(l1==null || l2==null) return l1==null? l2:l1;
           ListNode dm=new ListNode(-1);
           ListNode prev=dm;
           ListNode curr=l1;
           ListNode curr1=l2;

           while(curr!=null && curr1!=null){
               if(curr.val<=curr1.val){
                   prev.next=curr;
                   prev=curr;
                   curr=curr.next;
               }
               else {
                prev.next=curr1;
                prev=curr1;
                curr1=curr1.next;
               }
           }

           if(curr!=null){
               prev.next=curr;
           }
           if(curr1!=null){
            prev.next=curr1;
        }

          return dm.next;

        }
        private ListNode getMid(ListNode head) {
            if (head == null)
                return head;
            ListNode s = head;
            ListNode fast = head;
            while (fast != null && fast.next != null && fast.next.next != null) {
                s = s.next;
                fast = fast.next.next;
            }
            return s;
        }
        
    public ListNode sortList(ListNode A) {
        if(A==null || A.next==null) return A;
        ListNode mid=getMid(A);
        ListNode nhead=mid.next;
        mid.next=null;
        return Merge(sortList(A),sortList(nhead));
    }
}
