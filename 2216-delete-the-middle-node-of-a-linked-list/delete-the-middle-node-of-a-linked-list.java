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
    public ListNode deleteMiddle(ListNode head) {
        if(head==null || head.next==null)
        {
            return null;
        }
        int len = findLen(head);
        int mid = len/2;
        ListNode curr = head;
        ListNode prev = null;
        int i=0;
        while(i<mid)
        {
            prev=curr;

            curr=curr.next;

            i++;
        }
         prev.next=curr.next;
       return head;
    }

     public int findLen(ListNode head)
    {
        ListNode curr = head;
        int len =0;
        while(curr!=null)
        {
            len++;
            curr=curr.next;
        }
        return len;
    }
}