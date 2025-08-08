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
       ListNode dummyOdd = new ListNode(0);
       ListNode tempOdd = dummyOdd;

       ListNode dummyEven = new ListNode(0);
       ListNode tempEven = dummyEven;

       ListNode curr =  head;

       int i=1;
       while(curr!=null)
       {
          if(i%2==0)
          {
            tempEven.next=curr;
            tempEven = tempEven.next;
          }
          else
          {
             tempOdd.next=curr;
             tempOdd = tempOdd.next;
          }
          i++;
          curr = curr.next;
       }

      tempEven.next = null;
      tempOdd.next = dummyEven.next;
      return dummyOdd.next;
    }
}