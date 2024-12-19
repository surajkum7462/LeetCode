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
    public ListNode middleNode(ListNode head) {

         ListNode curr=head;
        int len=0;
        if(head==null)
        {
            return null;
        }
       
        
        while(curr!=null)
        {
            len++;
            curr=curr.next;
        }
        if(len==1)
        {
            return head;
        }
        if(len%2!=0)
        {
            ListNode temp=head;
          
            len=len/2;
            int i=0;
            while(i<len)
            {
               temp=temp.next;
               i++;
            }
            return temp;
        }
        else
        {
            ListNode temp=head;
            int i=0;
           len=len/2;
           while(i<len)
           {
            temp=temp.next;
            i++;
           }
           return temp;
        }
        
    }
}