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
        if(head==null || head.next==null)
        {
            return null;
        }
        ListNode reverseHead = reverse(head);
        ListNode curr = reverseHead;
        ListNode prev = null;

        int i=1;
        while(i<n)
        {
           prev=curr;
           curr=curr.next;
           i++;
        }
        if(prev==null)
        {
            reverseHead=curr.next;
        }
        else
        {
            prev.next = curr.next;
        }

        return reverse(reverseHead);
        
    }

    public ListNode reverse(ListNode head)
    {
        ListNode curr= head;
        ListNode temp=null;
        while(curr!=null)
        {
            ListNode next = curr.next;
            curr.next=temp;
            temp=curr;
            curr=next;
        }
        return temp;
    }

   
}