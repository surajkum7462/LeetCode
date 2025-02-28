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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
        {
            return head;
        }
        ListNode middle = findMiddle(head);
        ListNode right = middle.next;
        middle.next = null;
        ListNode left = head;
       right= sortList(right);
        left=sortList(left);
        
        return merge(left,right);
    }

    public ListNode merge(ListNode l1 , ListNode l2)
    {
        ListNode dummy=  new ListNode(0);
        ListNode temp = dummy;
        while(l1!=null && l2!=null)
        {
            if(l1.val<=l2.val)
            {
                temp.next=l1;
                l1=l1.next;
            }
            else
            {
                temp.next=l2;
                l2=l2.next;
            }
            temp=temp.next;
        }
        if(l1!=null)
        {
            temp.next=l1;
        }
        else
        {
            temp.next=l2;
        }
        return dummy.next;
    }

    public ListNode findMiddle(ListNode head)
    {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;

        while(fast!=null && fast.next!=null)
        {
            prev=slow;
            fast = fast.next.next;
            slow=slow.next;
        }
        return prev;
    }
}