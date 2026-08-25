class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node temp = head;
        while (temp != null) {
            Node copy = new Node(temp.val);
            copy.next = temp.next;
            temp.next = copy;
            temp = copy.next;
        }
        temp = head;
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }
        Node newHead = head.next;
        Node copyTemp = newHead;
        temp = head;
        while (temp != null) {
            temp.next = temp.next.next;
            if (copyTemp.next != null) {
                copyTemp.next = copyTemp.next.next;
            }
            temp = temp.next;
            copyTemp = copyTemp.next;
        }
        return newHead;
    }
}