/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

        ListNode fastptr=head;
        ListNode slowptr=head;
        while(fastptr!=null && fastptr.next!=null)
        {
            fastptr=fastptr.next.next;
            slowptr=slowptr.next;
            if(slowptr==fastptr)
            {
                return true;
            }
        }
        return false;
    }
}