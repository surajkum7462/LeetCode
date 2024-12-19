/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

    //     int size1=length(headA);
    //     int size2=length(headB);

    //              if(headA==null || headB==null)
    //     {
    //         return null;
    //     }
    //     int diff=size1-size2;
    //     ListNode ptr1=headA;
    //     ListNode ptr2=headB;
    //     if(diff>0)
    //     {
    //         while(diff>0)
    //         {
    //             ptr1=ptr1.next;
    //             diff--;
    //         }
    //     }
    //     else
    //     {
    //         while(diff<0)
    //         {
    //             ptr2=ptr2.next;
    //             diff++;
    //         }
    //     }
    //     while(ptr1!=ptr2)
    //     {
    //         ptr1=ptr1.next;
    //         ptr2=ptr2.next;
    //     }
    //     return ptr1;
    // }
    // public int length(ListNode head)
    // {
    //     ListNode temp=head;
    //     int len=0;
    //     while(temp!=null)
    //     {
    //         len++;
    //         temp=temp.next;
    //     }
    //     return len;



     ListNode d1 = headA;
    ListNode d2 = headB;
    
    while(d1 != d2) {
        d1 = d1 == null? headB:d1.next;
        d2 = d2 == null? headA:d2.next;
    }
    
    return d1;
    }
}