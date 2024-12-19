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

        ListNode curr=head;
        int len=0;
        while(curr!=null)
        {
            len++;
            curr=curr.next;
        }
        curr=head;
        int n=len/2;
        int i=0;
        ListNode prev=null;
        while(i<n)
        {
            prev=curr;
            curr=curr.next;
            i++;
        }
        if(prev==null)
        {
            head=curr.next;
        }
        else
        {
            prev.next=curr.next;
        }
       
        return head;
    }
}