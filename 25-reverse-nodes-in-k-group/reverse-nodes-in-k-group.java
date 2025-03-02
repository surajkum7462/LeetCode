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
    public ListNode findKthNode(ListNode curr , int k)
    {
        k=k-1;
        while(curr!=null && k>0)
        {
            k--;
            curr=curr.next;
        }
        return curr;
    }
    public void reverse(ListNode head)
    {
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null)
        {
            ListNode next = curr.next;
            curr.next = prev;
            prev=curr;
            curr=next;

        }
       
    }
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;
        ListNode prevNode = null;
        while(temp!=null)
        {
            ListNode KthNode = findKthNode(temp,k);
            if(KthNode==null)
            {
              
              if(prevNode!=null)
              {
                 prevNode.next = temp;
              }

                break;
            }
            ListNode nextNode = KthNode.next;
            KthNode.next = null;
            reverse(temp);
            if(temp==head)
            {
                head = KthNode;
            }
            else
            {
                prevNode.next = KthNode;
            }
            prevNode=temp;
            temp=nextNode;
        }
        return head;
    }
}