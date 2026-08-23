class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head.next==null) return null;
        ListNode fast=head.next;
        ListNode slow=head;
        int count=0;
        while(fast.next!=null &&  fast.next.next!=null ){
            slow=slow.next;
            fast=fast.next.next;
        }
        slow.next=slow.next.next;
        return head;
    }
}