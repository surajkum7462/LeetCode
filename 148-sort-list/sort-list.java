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
        ListNode leftHead = head;
        ListNode rightHead = middle.next;
        middle.next=null;
        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);
        return merge(leftHead,rightHead);
    }

    public ListNode merge(ListNode left ,ListNode right)
    {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while(left!=null && right!=null)
        {
            if(left.val>=right.val)
            {
                temp.next=right;
                right=right.next;
            }
            else
            {
                temp.next=left;
                left=left.next;
            }
            temp=temp.next;
        }

        if(left!=null)
        {
            temp.next=left;
            
        }
        else {
            temp.next=right;
        }

        return dummy.next;
    }

    public ListNode findMiddle(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast!=null && fast.next!=null)
        {
            prev=slow;
            fast=fast.next.next;
            slow=slow.next;
        }
        return prev;
    }
}