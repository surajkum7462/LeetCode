/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode headNew=reverse(head);
        ListNode curr=headNew;
        int i=1;
        int len=length(headNew);
        if(head==null || len==1)
        {
            return null;
        }
        ListNode prev=null;
        while(i<n)
        {
            prev=curr;
           curr=curr.next;
           i++;
        }
        if(prev==null)
        {
            headNew=curr.next;
        }
        else
        {
             prev.next=curr.next;
        }
      
        
        return reverse(headNew);

       
        
    }
     public ListNode reverse(ListNode head)
     {
        ListNode curr=head;
        ListNode prev=null;
        
        while(curr!=null)
        {
          ListNode temp=curr.next;
          curr.next=prev;
          prev=curr;
          curr=temp;
        }
        return prev;
     }

     public int length(ListNode head)
     {
        ListNode curr=head;
        int len=0;
        while(curr!=null)
        {
            len++;
            curr=curr.next;
        }
        return len;
     }
}