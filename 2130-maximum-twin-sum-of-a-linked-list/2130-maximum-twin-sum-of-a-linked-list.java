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
    public ListNode Reverse(ListNode head){
        ListNode prv=null;
        ListNode crr=head;
        while(crr!=null){
            ListNode frd=crr.next;
            crr.next=prv;
            prv=crr;
            crr=frd;
        }
        return prv;
    }
    public int pairSum(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode left=head;
        ListNode right=Reverse(slow.next);
        int max=0;
        while(left!=slow.next && right!=null){
            max=Math.max((left.val+right.val),max);
            left=left.next;
            right=right.next;
        }
        return max;
        
    }
}