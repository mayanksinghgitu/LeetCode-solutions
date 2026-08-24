class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode after=null;

        while (curr != null) {
            ListNode next = curr.next; 
            after=curr.next;          
            curr.next=prev;
            prev=curr;
            curr=after;
        }

        return prev;
    }
}