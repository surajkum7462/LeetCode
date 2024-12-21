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
    public ListNode reverseKGroup(ListNode head, int k) {

       ListNode temp=head;
       ListNode prevLast=null;
       while(temp!=null)
       {
         ListNode KthNode=findKthNode(temp,k);
         if(KthNode==null)
         {
            if(prevLast!=null)
            {
                prevLast.next=temp;
            }
            break;
         }
         ListNode nextNode=KthNode.next;
         KthNode.next=null;
         reverse(temp);
         if(temp==head)
         {
            head=KthNode;
         }
         else
         {
            prevLast.next=KthNode;
         }
         prevLast=temp;
         temp=nextNode;
       }
       return head;
        
    }
    public ListNode findKthNode(ListNode temp,int k)
    {
        k=k-1;
        while(temp!=null && k>0)
        {
            k--;
            temp=temp.next;
        }
        return temp;
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
}