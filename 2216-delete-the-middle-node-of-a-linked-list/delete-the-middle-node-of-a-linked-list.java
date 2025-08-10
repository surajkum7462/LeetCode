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
    public int findLen(ListNode head)
    {
        int len=0;
        while(head!=null)
        {
            len++;
            head=head.next;
        }
        return len;
    }
    public ListNode deleteMiddle(ListNode head) {
        if(head==null || head.next==null)
        {
            return null;
        }
       ListNode prev=null;
        int n=findLen(head);
      ListNode temp = head;
      int mid=n/2;
      int i=0;
      while(i<mid)
      {
        prev=temp;
         temp=temp.next;
         i++;
      }
      if(prev!=null)
      {
         prev.next=temp.next;
      }

      return head;

    }
}