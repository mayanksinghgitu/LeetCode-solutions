 
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode temp=head;
        ListNode node2=temp.next;
        ListNode node=node2;
        while(temp.next!=null && temp.next.next!=null){
            temp.next=temp.next.next;
            node.next=node.next.next;
            temp=temp.next;
            node=node.next;
        }
        temp.next=node2;
        return head;
    }
}