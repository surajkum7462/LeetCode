/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
       if (head == null) {
            return null;
        }

        Node current = head;

        // Step 1: Create new nodes and interweave them with original list
        while (current != null) {
            Node newNode = new Node(current.val);
            newNode.next = current.next;
            current.next = newNode;
            current = newNode.next;
        }

        current = head;

        // Step 2: Set up random pointers for the new nodes
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        current = head;
        Node newHead = head.next;
        Node newCurrent = newHead;

        // Step 3: Separate the original and copied lists
        while (current != null) {
            current.next = newCurrent.next;
            current = current.next;

            if (current != null) {
                newCurrent.next = current.next;
                newCurrent = newCurrent.next;
            }
        }

        return newHead;
    }
}