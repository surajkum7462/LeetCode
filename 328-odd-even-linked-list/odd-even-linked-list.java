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
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(0);
        ListNode oddTemp = odd;
        ListNode even = new ListNode(0);
        ListNode evenTemp=even;
        ListNode curr=head;
        int i=1;
        while(curr!=null)
        {
            if(i%2!=0)
            {
                oddTemp.next=curr;
                oddTemp=oddTemp.next;
               
            }
            else
            {
                evenTemp.next=curr;
                evenTemp=evenTemp.next;
                
            }
            i++;
            curr=curr.next;
        }
        evenTemp.next=null;
         oddTemp.next = even.next;
         return odd.next;

    }
}